package server;

import com.google.gson.Gson;
import disk.System;
import engine.Engine;
import result.QueryResult;
import result.Result;
import types.MsgTypes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Server {
    private final static String USERNAME = "OFADB";
    private final static String PASSWORD = "OFADB";
    private ServerSocket serverSocket;
    private DataInputStream inputStream;

    private Server() {
        try {
            serverSocket = new ServerSocket(8080, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        java.lang.System.out.println("Server is starting...");
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void start() {
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                java.lang.System.out.println("New connection accepted: " +
                        socket.getInetAddress() + ":" + socket.getPort());
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            PostData postData = null;
            try {
                InputStream inputStream = socket.getInputStream();
                postData = getPostData(inputStream);
                socket.shutdownInput();
            } catch (Exception e) {
                java.lang.System.out.println("Client disconnected");
            }

            try {
                OutputStream outputStream = socket.getOutputStream();
                doResponse(outputStream, postData);
                socket.shutdownOutput();
            } catch (Exception e) {
                java.lang.System.out.println("Client disconnected");
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private void doResponse(OutputStream os, PostData data) throws IOException {
        String resJson;

        if (data == null) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, "Format error", null);
            os.write(resJson.getBytes());
            return;
        }

        if (!verifyClient(data.userName, data.password)) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, "Invalid user", null);
            os.write(resJson.getBytes());
            return;
        }

        try {
            switch (data.type) {
                case MSG_POST_SQL:
                    System.loadSystem();
                    System.loadDataBase("testbase");
                    Result result = Engine.expressionExec(data.sql);
                    os.write(getResJson(result).getBytes());
                    break;
                case MSG_POST_CONNECT:
                    os.write(getResJson(MsgTypes.MSG_RES_SUCCESS, "Connection is stable", null).getBytes());
                    break;
                default:
                    throw new RuntimeException("Post form is incorrect");
            }
        } catch (Exception e) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, e.getMessage(), null);
            os.write(resJson.getBytes());
        }
    }

    private boolean verifyClient(String userName, String password) {
        return userName.equals(USERNAME) && password.equals(PASSWORD);
    }

    private PostData getPostData(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        StringBuilder jsonStr = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            jsonStr.append(line);
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonStr.toString(), PostData.class);
    }

    private String getResJson(Result result) throws IOException {
        if (Objects.requireNonNull(result).getClass() == QueryResult.class) {
            QueryResult queryResult = (QueryResult) result;
            TableData tableData = new TableData();
            tableData.columnNames = queryResult.getColumnName();
            while (queryResult.hasNext()) {
                tableData.data.add(queryResult.next());
            }
            return getResJson(MsgTypes.MSG_RES_SUCCESS, "Query success", tableData);
        } else {
            return getResJson(MsgTypes.MSG_RES_SUCCESS, "message", null);
        }
    }

    private String getResJson(MsgTypes type, String message, TableData tableData) {
        ResData resData = new ResData();
        resData.type = type;
        resData.message = message;
        resData.tableData = tableData;

        return new Gson().toJson(resData);
    }
}

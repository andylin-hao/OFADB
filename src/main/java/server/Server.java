package server;

import disk.System;
import engine.Engine;
import result.InfoResult;
import result.MsgResult;
import utils.Utils;
import result.QueryResult;
import result.Result;
import types.MsgTypes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private final static String USERNAME = "OFADB";
    private final static String PASSWORD = "OFADB";
    private ServerSocket serverSocket;

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
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            PostData postData = null;
            try {
                InputStream inputStream = socket.getInputStream();
                postData = (PostData) Utils.deserialize(inputStream.readAllBytes());
                socket.shutdownInput();
                java.lang.System.out.println("Message received");
            } catch (Exception e) {
                java.lang.System.out.println("Client disconnected");
            }

            try {
                OutputStream outputStream = socket.getOutputStream();
                doResponse(outputStream, postData);
                socket.shutdownOutput();
                java.lang.System.out.println("Result sent");
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
        byte[] resStr;

        if (data == null) {
            resStr = getResStr(MsgTypes.MSG_RES_ERR, "Format error", null);
            os.write(resStr);
            return;
        }

        if (!verifyClient(data.userName, data.password)) {
            resStr = getResStr(MsgTypes.MSG_RES_ERR, "Invalid user", null);
            os.write(resStr);
            return;
        }

        try {
            switch (data.type) {
                case MSG_POST_SQL:
                    System.loadSystem();
                    String[] sqlStatements = data.sql.split(";");
                    Result result = null;
                    for (String sql: sqlStatements)
                        result = Engine.expressionExec(sql);
                    os.write(getResStr(result));
                    break;
                case MSG_POST_CONNECT:
                    os.write(getResStr(MsgTypes.MSG_RES_SUCCESS, "Connection is stable", null));
                    break;
                default:
                    throw new RuntimeException("Post form is incorrect");
            }
        } catch (Exception e) {
            resStr = getResStr(MsgTypes.MSG_RES_ERR, e.getMessage(), null);
            os.write(resStr);
        }
    }

    private boolean verifyClient(String userName, String password) {
        return userName.equals(USERNAME) && password.equals(PASSWORD);
    }

    private byte[] getResStr(Result result) throws IOException {
        if (Objects.requireNonNull(result).getClass() == QueryResult.class) {
            QueryResult queryResult = (QueryResult) result;
            TableData tableData = new TableData();
            tableData.columnNames = queryResult.getColumnName();
            while (queryResult.hasNext()) {
                tableData.data.add(queryResult.next());
            }
            return getResStr(MsgTypes.MSG_RES_SUCCESS, "Query success", tableData);
        } else if (result.getClass() == MsgResult.class) {
            return getResStr(MsgTypes.MSG_RES_SUCCESS, ((MsgResult) result).getMsg(), null);
        } else if (result.getClass() == InfoResult.class) {
            return getResStr(MsgTypes.MSG_RES_SUCCESS, "Information acquired", ((InfoResult) result).getTableData());
        } else
            return getResStr(MsgTypes.MSG_RES_ERR, "Internal error", null);
    }

    private byte[] getResStr(MsgTypes type, String message, TableData tableData) throws IOException {
        ResData resData = new ResData();
        resData.type = type;
        resData.message = message;
        resData.tableData = tableData;

        return Utils.serialize(resData);
    }

}

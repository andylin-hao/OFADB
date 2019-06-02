package server;

import com.google.gson.Gson;
import engine.Engine;
import result.QueryResult;
import result.Result;
import types.MsgTypes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet(name = "Server")
public class Server extends HttpServlet {
    private final static String USERNAME = "OFADB";
    private final static String PASSWORD = "OFADB";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        PrintWriter writer;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            return;
        }
        String resJson;


        PostData data;
        try {
            data = getPostData(request);
        } catch (Exception e) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, "Format error", null);
            writer.println(resJson);
            return;
        }

        if (!verifyClient(data.userName, data.password)) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, "Invalid user", null);
            writer.println(resJson);
            return;
        }

        try {
            switch (data.type) {
                case MSG_POST_SQL:
                    Result result = Engine.expressionExec(data.sql);
                    writer.println(getResJson(result));
                    break;
                case MSG_POST_CONNECT:
                    writer.println(getResJson(MsgTypes.MSG_RES_SUCCESS, "Connection is stable", null));
                    break;
                default:
                    throw new RuntimeException("Post form is incorrect");
            }
        } catch (Exception e) {
            resJson = getResJson(MsgTypes.MSG_RES_ERR, e.getMessage(), null);
            writer.println(resJson);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private boolean verifyClient(String userName, String password) {
        return userName.equals(USERNAME) && password.equals(PASSWORD);
    }

    private PostData getPostData(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder jsonStr = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){
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

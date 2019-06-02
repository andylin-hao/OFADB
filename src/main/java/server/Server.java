package server;

import com.google.gson.Gson;
import javafx.geometry.Pos;

import javax.json.Json;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Server")
public class Server extends HttpServlet {
    private final static String USERNAME = "OFADB";
    private final static String PASSWORD = "OFADB";
    private PrintWriter writer;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        writer = response.getWriter();

        PostData data = getPostData(request);
        if (!verifyClient(data.userName, data.password)) {
            writer.println("Invalid user");
            return;
        }

        ResData resData = new ResData();
        String resDataJson = new Gson().toJson(resData);
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

        return new Gson().fromJson(jsonStr.toString(), PostData.class);
    }

    private class ResData {
        String type;
        String message;
        TableData tableData;
    }

    private class TableData {
        String[] columnNames;
        Object[][] data;
        boolean isFinish;
    }

    private class PostData {
        String userName;
        String password;
        String sql;
    }
}

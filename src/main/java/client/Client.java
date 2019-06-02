package client;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import server.PostData;
import server.ResData;
import types.MsgTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Client extends JFrame {
    private File file;
    private JTextArea textArea = new JTextArea(200, 100);
    private JLabel label = new JLabel("No message");
    private JTable table = new JTable();
    private JButton button = new JButton("Confirm");
    private JScrollPane scrollPaneTable;

    private final static String URL = "http://localhost:8080/OFADB_war_exploded/result";
    private final static String USERNAME = "OFADB";
    private final static String PASSWORD = "OFADB";

    public static void main(String[] args) {
        Client client = new Client();
        client.setVisible(true);
    }

    private Client() {
        super();
        initUI();
        connectToServer();
    }

    private void connectToServer() {
        ResData res = send(getPostJson(MsgTypes.MSG_POST_CONNECT, ""));
        processRes(res);
    }

    private void processRes(ResData res) {
        switch (res.type) {
            case MSG_RES_ERR:
                this.label.setText(res.message);
                break;
            case MSG_RES_SUCCESS:
                if (res.tableData != null) {
                    Object[] columnNames = res.tableData.columnNames;
                    Object[][] data = new Object[columnNames.length][res.tableData.data.size()];
                    this.table = new JTable(res.tableData.data.toArray(data), columnNames);
                    this.scrollPaneTable.removeAll();
                    this.scrollPaneTable.add(this.table);
                }

                this.label.setText(res.message);
            default:
                this.label.setText("Wrong format of response data");
        }
    }

    private ResData send(String data) {
        RequestConfig defaultRequestConfig = RequestConfig.custom()
                .setSocketTimeout(3000)
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000).build();

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost(URL);

        post.setConfig(defaultRequestConfig);

        StringEntity stringEntity = new StringEntity(data, StandardCharsets.UTF_8);
        stringEntity.setContentType("application/json");
        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        post.setEntity(stringEntity);

        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };

        try {
            String resStr = httpClient.execute(post, responseHandler);
            return new Gson().fromJson(resStr, ResData.class);
        } catch (IOException e) {
            ResData resData = new ResData();
            resData.type = MsgTypes.MSG_RES_ERR;
            resData.message = e.getMessage();
            resData.tableData = null;
            return resData;
        }
    }

    private void initUI() {
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();

        textArea.setLineWrap(true);
        JScrollPane scrollPaneText = new JScrollPane(textArea);
        scrollPaneTable = new JScrollPane(table);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPaneText, scrollPaneTable);
        splitPane.setDividerLocation(200);
        splitPane.setDividerSize(1);

        upPanel.setLayout(new BorderLayout());
        downPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        upPanel.add(splitPane);
        downPanel.add(label);
        downPanel.add(button);

        add(upPanel, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Open");
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(getContentPane()) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    try {
                        fileSelected();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menu.add(menuItem);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = textArea.getText();
                if (sql.equals(""))
                    return;
                ResData res = send(getPostJson(MsgTypes.MSG_POST_SQL, sql));
                processRes(res);
            }
        });

        setTitle("OFADB");
        setSize(800, 600);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fileSelected() throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        BufferedReader buffer = new BufferedReader(reader);
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = buffer.readLine()) != null) {
            content.append(line);
            content.append('\n');
        }
        textArea.setText(content.toString());
    }

    private String getPostJson(MsgTypes type, String sql) {
        PostData postData = new PostData();
        postData.type = type;
        postData.userName = USERNAME;
        postData.password = PASSWORD;
        postData.sql = sql;

        return new Gson().toJson(postData);
    }
}


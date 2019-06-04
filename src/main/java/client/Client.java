package client;

import utils.Utils;
import server.PostData;
import server.ResData;
import types.MsgTypes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client extends JFrame {
    private File file;
    private JTextArea textArea = new JTextArea(200, 100);
    private JLabel label = new JLabel("No message");
    private JTable table = new JTable();
    private JButton button = new JButton("Confirm");

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
        send(getPostStr(MsgTypes.MSG_POST_CONNECT, ""));
    }

    private void send(final byte[] data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ResData resData = sendToServer(data);
                processRes(resData);
            }
        }).start();
    }

    private void processRes(ResData res) {
        switch (res.type) {
            case MSG_RES_ERR:
                label.setText(res.message);
                break;
            case MSG_RES_SUCCESS:
                if (res.tableData != null) {
                    Object[] columnNames = res.tableData.columnNames;
                    Object[][] data = new Object[res.tableData.data.size()][columnNames.length];
                    for (int i = 0;i<res.tableData.data.size();i++) {
                        data[i] = res.tableData.data.get(i);
                    }
                    DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
                    tableModel.setDataVector(data, columnNames);
                    table.setModel(tableModel);
                }

                label.setText(res.message);
                break;
            default:
                label.setText("Wrong format of response data");
        }
    }

    private ResData sendToServer(byte[] data) {
        try {
            Socket socket = new Socket("localhost", 8080);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(data);
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            ResData resData = (ResData) Utils.deserialize(inputStream.readAllBytes());
            socket.shutdownInput();

            socket.close();

            return resData;
        } catch (Exception e) {
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
        JScrollPane scrollPaneTable = new JScrollPane(table);
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
                send(getPostStr(MsgTypes.MSG_POST_SQL, sql));
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

    private byte[] getPostStr(MsgTypes type, String sql)  {
        PostData postData = new PostData();
        postData.type = type;
        postData.userName = USERNAME;
        postData.password = PASSWORD;
        postData.sql = sql;

        try {
            return Utils.serialize(postData);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "".getBytes();
    }
}


package client;

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

    public static void main(String[] args) {
        Client client = new Client();
        client.setVisible(true);
    }

    private Client() {
        super();
        initUI();
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
}


package Day78;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class Client {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private PrintWriter out;
    private String username;

    public Client() {
        /// Ask username first
        username = JOptionPane.showInputDialog("Enter your name:");
        if (username == null || username.trim().isEmpty()) {
            System.exit(0);
        }

        JFrame frame = new JFrame("Chat - " + username);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        /// Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.DARK_GRAY);
        chatArea.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(chatArea);


        /// Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        // Remove default border
        inputField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.CYAN));

        inputField.setBackground(new Color(50, 50, 50));
        inputField.setForeground(Color.WHITE);

        // Caret (typing cursor) color
        inputField.setCaretColor(Color.CYAN);

        inputField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.CYAN);
        sendButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);


        frame.setVisible(true);

        connectToServer();

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e-> sendMessage());
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            out = new PrintWriter(socket.getOutputStream(), true);

            /// Send username first
            out.println(username);

            /// Receive message thread
            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {

                        String finalMessage = message;
                        SwingUtilities.invokeLater(() -> {
                            chatArea.append(finalMessage + "\n");
                            chatArea.setCaretPosition(chatArea.getDocument().getLength());
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();

        if (!message.isEmpty()) {
            out.println(message);
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}

package Day76;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private PrintWriter out;

    public Client() {
        JFrame frame = new JFrame("Chat Client");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        /// Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        /// Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        connectToServer();

        /// Send button actions
        sendButton.addActionListener(e -> sendMessage());

        /// Press enter to send
        inputField.addActionListener(e -> sendMessage());
    }

    private void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            out = new PrintWriter(socket.getOutputStream(), true);

            /// thread to receive messages
             new Thread(() -> {
                 try {
                     String message;
                     while ((message = in.readLine()) != null) {

                         String finalMessage = message;
                         SwingUtilities.invokeLater(() -> {
                             chatArea.append(finalMessage + "\n");
                         });
                     }
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }).start();
        } catch (Exception e) {
            SwingUtilities.invokeLater(() -> {
                chatArea.append("Disconnected from server\n");
            });
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

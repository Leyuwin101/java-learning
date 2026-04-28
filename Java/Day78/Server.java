package Day78;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;


public class Server {
    private static Map<String, PrintWriter> clients = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is now running");

            while (true) {
                Socket socket = serverSocket.accept();

                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                out = new PrintWriter(socket.getOutputStream(), true);

                /// First message = username
                username = in.readLine();

                if (username == null) return;

                while(clients.containsKey(username)) {
                    out.println("Username already taken. Try another");
                    username = in.readLine();

                    if (username == null) return;
                }

                synchronized (clients) {
                    clients.put(username, out);
                }

                broadcast("[SYSTEM] " + username + " joined the chat");

                String message;
                while ((message = in.readLine()) != null) {

                    message = message.trim();

                    /// EXIT COMMAND
                    if (message.equalsIgnoreCase("/exit")) {
                        disconnect();
                    }

                    /// LIST USERS
                    if (message.equalsIgnoreCase("/list")) {
                        sendUserList();
                        continue;
                    }

                    /// PRIVATE MESSAGE
                    if (message.startsWith("@")) {
                        handlePrivateMessage(message);
                        continue;
                    }

                    /// NORMAL BROADCAST
                    broadcast(username + ": " + message);
                }
            } catch (Exception e) {
                System.out.println("Connection lost: " + username);
            } finally {
                disconnect();
            }
        }

        private void handlePrivateMessage(String message) {
            try {
                String[] split = message.split(" ", 2);

                if (split.length < 2) {
                    out.println("[SYSTEM] Invalid private message format");
                    return;
                }

                String targetUser = split[0].substring(1); /// remove @
                String msg = split[1];

                PrintWriter targetOut = clients.get(targetUser);

                if (targetOut != null) {
                    targetOut.println("[PRIVATE] " + username + ": " + msg);
                    out.println("[PRIVATE to " + targetUser + "] " + msg);
                } else {
                    out.println("[SYSTEM] User not found");
                }
            } catch (Exception e) {
                out.println("[SYSTEM] Error sending private message");
            }
        }

        private void sendUserList() {
            StringBuilder sb = new StringBuilder();
            sb.append("Online users:\n");

            synchronized (clients) {
                for (String user : clients.keySet()) {
                    sb.append("- ").append(user).append("\n");
                }
            }

            out.println(sb.toString());
        }

        private void broadcast(String message) {
            synchronized (clients) {
                for (PrintWriter client : clients.values()) {
                    client.println(message);
                }
            }
        }

        private void disconnect() {
            try {
                if (username != null) {
                    synchronized (clients) {
                        clients.remove(username);
                    }
                    broadcast("[System] " + username + " left the chat");
                }

                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

package Day77;

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
                    broadcast(username + ": " + message);
                }
            } catch (Exception e) {
                System.out.println("Connection lost: " + username);
            } finally {
                /// Remove client
                if (username != null) {
                    synchronized (clients) {
                        clients.remove(username);
                    }
                    broadcast("[SYSTEM] " + username + " left the chat");
                }

                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clients) {
                for (PrintWriter client : clients.values()) {
                    client.println(message);
                }
            }
        }
    }
}

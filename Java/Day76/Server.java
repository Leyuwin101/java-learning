package Day76;

import Day75.Client;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static List<PrintWriter> clients = new ArrayList<>();
    private static int clientCounter = 1;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is now running");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private String clientName;


        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientName = "Client-" + (clientCounter++);
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );

                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clients) {
                    clients.add(out);
                }

                broadcast(clientName + " joined the chat");

                String message;
                while ((message = in.readLine()) != null) {
                    broadcast(clientName + ": " + message);
                }

            } catch (Exception e) {
                System.out.println("Client disconnected");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                synchronized (clients) {
                    clients.remove(out);
                }

                broadcast(clientName + " left the chat");
            }
        }

        private void broadcast(String message) {
            System.out.println("[SERVER LOG] " + message);

            synchronized (clients) {
                Iterator<PrintWriter> iterator = clients.iterator();

                while (iterator.hasNext()) {
                    PrintWriter client = iterator.next();

                    if (client.checkError()) {
                        iterator.remove();
                        continue;
                    }

                    client.println(message);
                }
            }
        }
    }



}

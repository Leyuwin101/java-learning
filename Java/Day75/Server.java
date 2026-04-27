package Day75;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        /// 🖥️ Server (waits + responds)
        /// 💻 Client (connects + sends message)

        /// Server is responsible for listening for incoming client connection and responding to request
        try {
            /// Create a ServerSocket that listens on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started... waiting for client");

            /// Accepts an incoming client connection (blocking call)
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            /// input stream to receive data from client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            /// Output stream to send data to the client
            /// 'true' enables auto-flush after each println
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            /// Read a message sent by the client
            String message = in.readLine();
            System.out.println("Client say: " + message);

            /// Send a response back to the client
            out.println("Hello Client, Message Received");

            /// Close client connection
            socket.close();

            /// Stop the server
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


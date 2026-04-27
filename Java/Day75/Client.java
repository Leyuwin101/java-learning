package Day75;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        /// 🖥️ Server:
        /// Opens port 5000
        /// Waits for client
        /// Receives message
        /// Sends response

        /// 💻 Client:
        /// Connects to localhost:5000
        /// Sends message
        /// Receives reply


        /// Client is responsible for connecting to the server and exchanging messages
        try {
            /// Connect to the server running on localhost at port 5000
            Socket socket = new Socket("localhost", 5000);

            /// Input stream to receive response from the server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            /// Output stream to send message to the server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            /// Send message to server
            out.println("Hello server");

            /// Receive response from the server
            String response = in.readLine();
            System.out.println("Server says: " + response);

            /// Close the connection
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

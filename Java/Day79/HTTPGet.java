package Day79;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGet {
    public static void main(String[] args) {
        /// 1. HTTP Methods
        /// GET → retrieve data
        /// POST → send data
        /// PUT → update
        /// DELETE → remove
        /// 2. Status Codes
        /// 200 → OK
        /// 404 → Not found
        /// 500 → Server error

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/users");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            System.out.println("Status: " + status);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            in.close();

            System.out.println("Response: \n");
            System.out.print(response.toString());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

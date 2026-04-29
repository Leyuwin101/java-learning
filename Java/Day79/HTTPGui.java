package Day79;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGui extends JFrame{
    private JTextArea outputArea;
    private JButton loadButton;

    public HTTPGui() {
        setTitle("API USERS");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        loadButton = new JButton("Load Users");

        loadButton.addActionListener(e -> fetchUser());

        add(loadButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }


    private void fetchUser() {

        outputArea.setText("Loading data...\n");

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() {
                String apiUrl = "https://jsonplaceholder.typicode.com/users";

                try {
                    URL url = new URL(apiUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    int responseCode = conn.getResponseCode();

                    /// Handle HTTP errors
                    if (responseCode != 200) {
                        return "HTTP Error: " + responseCode;
                    }


                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }

                    br.close();
                    conn.disconnect();

                    JSONArray jsonArray = new JSONArray(response.toString());

                    StringBuilder formatted = new StringBuilder();
                    formatted.append("=== USERS LIST ===\n\n");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject user = jsonArray.getJSONObject(i);

                        formatted.append("ID: ").append(user.getInt("id")).append("\n");
                        formatted.append("Name: ").append(user.getString("name")).append("\n");
                        formatted.append("Username: ").append(user.getString("username")).append("\n");
                        formatted.append("Email: ").append(user.getString("email")).append("\n");
                        formatted.append("--------------------------\n");
                    }

                    return formatted.toString();

                } catch (Exception e) {
                    outputArea.setText("Error: " + e.getMessage());
                }

                return null;
            }

            @Override
            protected void done() {
                try {
                    outputArea.setText(get());
                } catch (Exception e) {
                    outputArea.setText("Error updating UI");
                }
            }

        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HTTPGui().setVisible(true);
        });
    }
}

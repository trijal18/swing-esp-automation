package post;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class POST {

    private String key;
    private String value;

    public POST() {
        this.key = "";
        this.value = "";
    }

    public POST(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void sendPostRequest() {
        try {
            // Specify the URL of your Flask app
            URL url = new URL("http://127.0.0.1:5000/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to POST
            connection.setRequestMethod("POST");

            // Set headers
            connection.setRequestProperty("Content-Type", "application/json");

            // Enable output on the connection
            connection.setDoOutput(true);

            // Write the data to the output stream
            String data = "{\"" + key + "\": \"" + value + "\"}";
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(data.getBytes());
            outputStream.flush();
            outputStream.close();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response: " + response.toString());

            // Disconnect
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        POST postRequest = new POST("key", "value");
        postRequest.sendPostRequest();
    }
}

import java.net.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class AgeCountingFromResponse {
    public static void main(String[] args) {
        String urlString = "https://coderbyte.com/api/challenge/json/age-counting";
        String challengeToken = "g7tw5feoca8";

        try {
            // Create a URL object
            URL url = new URL(urlString);
            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set the request method to GET
            connection.setRequestMethod("GET");
            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());
                String data = jsonResponse.getString("data");

                // Count ages >= 50
                int count = countAges(data);
                // Prepare the final output
                String finalOutput = count + ":" + challengeToken;
                // Reverse the output
                String reversedOutput = new StringBuilder(finalOutput).reverse().toString();

                // Print the result
                System.out.println(reversedOutput);
            } else {
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countAges(String data) {
        String[] items = data.split(", ");
        int count = 0;

        for (String item : items) {
            String[] parts = item.split(", ");
            for (String part : parts) {
                if (part.startsWith("age=")) {
                    int age = Integer.parseInt(part.split("=")[1]);
                    if (age >= 50) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

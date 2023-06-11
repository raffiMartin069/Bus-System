package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

public class Country {
    private static final String API_URL = "https://restcountries.com/v3.1/all";
    private static ObservableList<String> countryNames = FXCollections.observableArrayList();

    public static ObservableList<String> fetchCountryData() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Parse the JSON response and extract country names
                String jsonString = response.toString();
                JSONArray jsonArray = new JSONArray(jsonString);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject countryObj = jsonArray.getJSONObject(i);
                    JSONObject nameObj = countryObj.getJSONObject("name");

                    String countryName = nameObj.getString("common");
                    countryNames.add(countryName);
                    
                    Collections.sort(countryNames);
                    
                }
                System.out.println("\nAPI Connection Successful");
            } else {
                System.out.println("Failed to fetch country data. Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryNames;
    }
}

package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String baseUrl = "https://petstore.swagger.io/v2/";
        String jsonContent = """
                {
                  "id": 0,
                  "category": {
                    "id": 0,
                    "name": "string"
                  },
                  "name": "Ratmir",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": 0,
                      "name": "string"
                    }
                  ],
                  "status": "available"
                }""";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request_get = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "pet/5"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpRequest request_post = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "pet"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonContent))
                .build();

        HttpResponse<String> response = client.send(request_get, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response_2 = client.send(request_post, HttpResponse.BodyHandlers.ofString());
        JsonObject answer = JsonParser.parseString(response.body()).getAsJsonObject();

        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Name: " + answer.get("name"));
        System.out.println("Response Body: " + response.body());
        System.out.println("Response Request: " + response.request());
        System.out.println("**********************************************\n\n");

        System.out.println("Response Code: " + response_2.statusCode());
        System.out.println("Response Body: " + response_2.body());
        System.out.println("Response Request: " + response_2.request());
        System.out.println("**********************************************\n\n");
    }
}

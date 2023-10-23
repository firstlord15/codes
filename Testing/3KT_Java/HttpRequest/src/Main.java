import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String baseUrl = "https://petstore.swagger.io/v2/";
        String jsonContent = "{\"id\": 1000, \"name\": \"Ratmir\", \"status\": \"available\"}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request_get = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "pet/5"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

//        HttpRequest request_post = HttpRequest.newBuilder()
//                .uri(URI.create(baseUrl + "pet/1000"))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonContent))
//                .build();

        HttpResponse<String> response = client.send(request_get, HttpResponse.BodyHandlers.ofString());
//        HttpResponse<String> response_2 = client.send(request_get, HttpResponse.BodyHandlers.ofString());


        String answer = response.body();
//        answer = ;


        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + answer);
        System.out.println("Response Request: " + response.request());
        System.out.println("**********************************************\n\n");

//        System.out.println("Response Code: " + response_2.statusCode());
//        System.out.println("Response Body: " + response_2.body());
//        System.out.println("Response Request: " + response_2.request());
//        System.out.println("**********************************************\n\n");
    }
}

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class Main {
    public static void Request_info(HttpResponse<String> response){
        System.out.printf("Status: %d\nBody: %s\nRequest: %s\n", response.statusCode(), response.body(), response.request());
        System.out.println("**********************************************\n\n");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // Первый кейс
        String AllListUrl = "https://dog.ceo/api/breeds/list/all";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request_get = HttpRequest.newBuilder()
                .uri(URI.create(AllListUrl))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request_get, HttpResponse.BodyHandlers.ofString());

        Request_info(response); // Созданая мною функция для выводы информации

        // Второй кейс
        String
    }
}
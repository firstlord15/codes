package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.json.JsonString;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.StringReader;

public class Main {
    @Test
    public static void test_first_case(String Url, String num) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request_get = HttpRequest.newBuilder()
                .uri(URI.create(Url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = client.send(request_get, HttpResponse.BodyHandlers.ofString());

        // Проверка статуса ответа (HTTP 200 OK)
        assert response.statusCode() == 200;


        // Попытка разобрать JSON-строку в объект JSON
        try (JsonReader jsonReader = Json.createReader(new StringReader(response.body()))) {
            JsonObject jsonObject = jsonReader.readObject();

            // Проверка наличия поля "message" и что оно не пустое
            if (jsonObject.containsKey("message")) {
                JsonValue messageValue = jsonObject.get("message");
                if (messageValue.getValueType() == JsonValue.ValueType.ARRAY) {
                    if (!messageValue.asJsonArray().isEmpty()) {
                        System.out.println("Field 'message' is not empty.");
                    } else {
                        System.out.println("Field 'message' is empty.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to parse JSON.");
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        // Первый кейс
        String AllListUrl = "https://dog.ceo/api/breeds/list/all";


        test_first_case(AllListUrl, "Первый"); // Созданая мною функция для выводы информации
    }
}
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestingSQLConnection {
    public static void apply_test (String DB_URL, String USER, String PASS) {
        System.out.println("Тестирование подключения к PostgresSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgresSQL JDBC Driver не был найден. Скачайте или укажите import библиотеки");
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("PostgresSQL JDBC Driver successfully connected");

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)){
            System.out.println("Вы успешно подключились к database!");
        } catch (SQLException e) {
            System.out.println("Подключение провалилось!");
            System.out.println(e.getMessage());
        }
    }
}

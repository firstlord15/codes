package org.example;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void applyConnection(String DB_URL, String USER, String PASS){
        try (java.sql.Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement();){
//            statement.execute("INSERT INTO persons(first_name, last_name, age) values ('None', 'Nonenov', 19)");
            System.out.println(statement.executeQuery("SELECT * from persons"));
        } catch (SQLException e) {
            System.out.println("Подключение провалилось!");
            System.out.println(e.getMessage());
        }
    }

    public static void applyFunction(String DB_URL, String USER, String PASS){

    }
}

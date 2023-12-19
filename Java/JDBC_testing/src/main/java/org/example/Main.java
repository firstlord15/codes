package org.example;

import static org.example.TestingSQLConnection.apply_test;
import static org.example.Connection.applyConnection;

public class Main {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5555/postgres";
    static final String USER = "postgres";
    static final String PASS = "test";

    public static void main(String[] args) {
        // apply_test(DB_URL, USER, PASS);
        // applyConnection(DB_URL, USER, PASS);

        User user = new User();
        Class<?> clazz = user.getClass();

        System.out.println(clazz.getDeclaredAnnotation(test.class));
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String USER = "postgres";
        String PASSWORD = "0909";

        User user = new User();
        EntityManager entityManager = new EntityManager(DB_URL, USER, PASSWORD);

        entityManager.test_connection();
        entityManager.createTable(user);
        entityManager.save(user);
    }
}
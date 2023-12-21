package org.example;

import org.example.models.*;

import static org.example.JdbcExecutor.test_connection;

public class Main {
    public static void main(String[] args) {
        String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String USER = "postgres";
        String PASSWORD = "0909";

        User user = new User(1, "firstlord15", "q1w2e3r4t5y");
        Dog dog = new Dog(1, "Ogi", 15);
        EntityManager entityManager = new EntityManager(DB_URL, USER, PASSWORD);

        entityManager.drop(User.class); // удаляют таблицы, если они есть
        entityManager.drop(Dog.class);

        test_connection(DB_URL, USER, PASSWORD);
        entityManager.createTable(User.class);
        entityManager.save(user);
        System.out.println("1");

        entityManager.createTable(Dog.class);
        entityManager.save(dog);
        System.out.println("2");
    }
}
package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println();
        User user = new User("1");
        System.out.println("Name: " + user.getName());
        System.out.println("Surname: " + user.getSurname());
        System.out.println("Test: " + user.getTest());

    }
}
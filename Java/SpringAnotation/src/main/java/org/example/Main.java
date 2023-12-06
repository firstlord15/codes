package org.example;

public class Main {
    public static void main(String[] args) {
        User user = new User("1");
        System.out.println("Name: " + user.getName());
        System.out.println("Surname: " + user.getSurname());
        System.out.println("Test: " + user.getTest());
    }
}
package org.example;

import java.util.Scanner;

public class Menu {
    Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("[Основное меню]");
        System.out.println("[1] Просмотр цикла документов");
        System.out.println("[2] Создание цикла документов");
        System.out.println("[3] Редактирование цикла документов");
        System.out.println("[4] Удаление цикла документов");

        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
        } else {
            System.out.println("Извините, но это явно не число. Введите заново");
            menu();
        }
    }


    public void method(){
        ViewDocument viewDocument = new ViewDocument();
    }
}




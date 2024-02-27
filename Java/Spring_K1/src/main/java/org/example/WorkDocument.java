package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkDocument {
    Scanner scanner = new Scanner(System.in);

    public void doDocument(){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        System.out.println("Введите id: ");
        int id = scanner.nextInt();

        System.out.println("Введите orderNumber: ");
        int orderNumber = scanner.nextInt();
        LocalDate orderDate = LocalDate.now();

        System.out.println("Введите buyerName: ");
        String buyerName = scanner.next();

        while(true){
            System.out.println("Введите название продукта и через пробел, его цену: ");
            String nameAndPrice = scanner.next();

            productName.add(nameAndPrice.split(" ")[0].trim());
            unitPrice.add(Double.valueOf(nameAndPrice.split(" ")[1].trim()));

            if (nameAndPrice.trim().equals("exit")) break;
        }

        Order order = new Order(id, orderNumber, orderDate, buyerName, unitPrice, productName);
        PaymentInvoice paymentInvoice = new PaymentInvoice(id, );
    }
}

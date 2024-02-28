package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Сделать общий number
public class WorkDocument {
    private final Scanner scanner;

    public WorkDocument() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> createDocument(String name) {
        List<String> result = new ArrayList<>();
        result.add(enterValue("Введите id: "));
        result.add(enterValue("Введите Number: "));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    private String enterValue(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim().toLowerCase();
    }

    public PaymentInvoice createPaymentInvoice() {
        List<String> documentData = createDocument("customerName");
        return new PaymentInvoice(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Payment createPayment(){
        List<String> documentData = createDocument("nameSupplier");
        return new Payment(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Invoice createInvoice(){
        List<String> documentData = createDocument("clientName");
        return new Invoice(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Order createOrder(){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();

        List<String> documentData = createDocument("buyerName");

        System.out.println("\nВведите amount: \n");
        int amount = scanner.nextInt();

        while(true){
            System.out.println("\nВведите название продукта и через пробел его цену: ");
            String nameAndPrice = scanner.next();

            productName.add(nameAndPrice.split(" ")[0].trim());
            unitPrice.add(Double.valueOf(nameAndPrice.split(" ")[1].trim()));

            if (nameAndPrice.trim().equalsIgnoreCase("exit")) break;
        }

        return new Order(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(), documentData.get(3),
                amount, unitPrice, productName
        );
    }

    public void doDocument(){

    }
}

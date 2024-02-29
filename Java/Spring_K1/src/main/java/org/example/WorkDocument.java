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

    public List<String> createDoc(String name) {
        List<String> result = new ArrayList<>();
        result.add(enterValue("Введите id: "));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    private String enterValue(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim().toLowerCase();
    }

    public PaymentInvoice createPaymentInvoice(int number) {
        List<String> documentData = createDoc("customerName");
        return new PaymentInvoice(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Payment createPayment(int number){
        List<String> documentData = createDoc("nameSupplier");
        return new Payment(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Invoice createInvoice(int number){
        List<String> documentData = createDoc("clientName");
        return new Invoice(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(3)
        );
    }

    public Order createOrder(int number){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        List<Integer> productAmount = new ArrayList<>();

        List<String> documentData = createDoc("buyerName");

        while(true){
            System.out.println("\nВведите в формате [<Название продукта> <Кол-во> <Цена>]: ");
            String nameAndPrice = scanner.next().trim();

            productName.add(nameAndPrice.split(" ")[0].trim());
            unitPrice.add(Double.valueOf(nameAndPrice.split(" ")[1].trim()));
            productAmount.add(Integer.valueOf(nameAndPrice.split(" ")[2].trim()));

            if (nameAndPrice.trim().equalsIgnoreCase("exit")) break;
        }

        return new Order(
                Integer.parseInt(documentData.get(0)), number,
                LocalDate.now(), documentData.get(3), productAmount,
                unitPrice, productName
        );
    }


    public SaveDocuments doDocs(){
        System.out.println("\nВведите number: \n");
        int number = scanner.nextInt();

        return new SaveDocuments(
                createOrder(number),
                createPaymentInvoice(number),
                createPayment(number),
                createInvoice(number)
        );
    }
}

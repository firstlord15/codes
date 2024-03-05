package org.example;

import org.example.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateDocuments {
    private final Scanner scanner;

    public CreateDocuments() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> createDoc(String name) {
        List<String> result = new ArrayList<>();
        result.add(enterValue("Введите id: "));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    public List<String> createDoc(String name, int id) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(id));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    private String enterValue(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public PaymentInvoice createPaymentInvoice(int number, int id) {
        List<String> documentData = createDoc("customerName", id);

        String comments = enterValue("Введите comments: ");

        return new PaymentInvoice(
                Integer.parseInt(documentData.get(0)), number,
                LocalDateTime.now(),
                documentData.get(1),
                comments
        );
    }

    public Payment createPayment(int number, int id){
        List<String> documentData = createDoc("nameSupplier", id);
        return new Payment(
                Integer.parseInt(documentData.get(0)), number,
                LocalDateTime.now(), documentData.get(1)
        );
    }

    public Invoice createInvoice(int number, int id){
        List<String> documentData = createDoc("clientName", id);

        String address = enterValue("Введите address: ");

        return new Invoice(
                Integer.parseInt(documentData.get(0)), number,
                LocalDateTime.now(),
                documentData.get(1), address
        );
    }

    public Order createOrder(int number){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        List<Integer> productAmount = new ArrayList<>();

        List<String> documentData = createDoc("buyerName");

        while (true) {
            System.out.println("\nВведите в формате [<Название продукта> <Кол-во> <Цена>], или 'exit' для завершения: ");
            String nameAndPrice = scanner.nextLine();
            if (nameAndPrice.equalsIgnoreCase("exit")) break;

            String[] parts = nameAndPrice.split(" ");
            if (parts.length != 3) {
                System.out.println("Неверный формат ввода. Попробуйте снова.");
                continue;
            }

            String productNameStr = parts[0].trim();
            int amount;
            double price;

            try {
                amount = Integer.parseInt(parts[1].trim());
                price = Double.parseDouble(parts[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка при чтении количества или цены продукта. Попробуйте снова.");
                continue;
            }

            productName.add(productNameStr);
            productAmount.add(amount);
            unitPrice.add(price);
        }

        System.out.println();
        return new Order(
                Integer.parseInt(documentData.get(0)), number,
                LocalDateTime.now(), documentData.get(1), productAmount,
                unitPrice, productName
        );
    }

    public ArrayList<Document> doDocs(){
        ArrayList<Document> result = new ArrayList<>();

        int number = Integer.parseInt(enterValue("\nВведите number:"));
        Order order = createOrder(number);

        result.add(order);
        result.add(createPaymentInvoice(number, order.getId()+1));
        result.add(createPayment(number, order.getId()+2));
        result.add(createInvoice(number, order.getId()+3));
        scanner.close();

        return result;
    }
}

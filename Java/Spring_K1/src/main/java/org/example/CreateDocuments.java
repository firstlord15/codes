package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Сделать общий number
public class CreateDocuments {
    private final Scanner scanner;

    public CreateDocuments() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> createDoc(String name, int number) {
        List<String> result = new ArrayList<>();
        result.add(enterValue("Введите id: "));
        result.add(String.valueOf(number));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    public List<String> createDoc(String name, int id, int number) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(id));
        result.add(String.valueOf(number));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    private String enterValue(String prompt) {
        System.out.println(prompt);

        return scanner.next().trim().toLowerCase();
    }

    public PaymentInvoice createPaymentInvoice(int number, int id) {
        List<String> documentData = createDoc("customerName", id, number);
        return new PaymentInvoice(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(2)
        );
    }

    public Payment createPayment(int number, int id){
        List<String> documentData = createDoc("nameSupplier", id, number);
        return new Payment(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(2)
        );
    }

    public Invoice createInvoice(int number, int id){
        List<String> documentData = createDoc("clientName", id, number);
        return new Invoice(
                Integer.parseInt(documentData.get(0)),
                Integer.parseInt(documentData.get(1)),
                LocalDate.now(),
                documentData.get(2)
        );
    }

    public Order createOrder(int number){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        List<Integer> productAmount = new ArrayList<>();

        List<String> documentData = createDoc("buyerName", number);

        while (true) {
            System.out.println("\nВведите в формате [<Название продукта> <Кол-во> <Цена>], или 'exit' для завершения: ");
            String nameAndPrice = scanner.nextLine().trim();

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

        return new Order(
                Integer.parseInt(documentData.get(0)), Integer.parseInt(documentData.get(1)),
                LocalDate.now(), documentData.get(2), productAmount,
                unitPrice, productName
        );
    }


    public ArrayList<Document> doDocs(){
        ArrayList<Document> result = new ArrayList<>();
        System.out.println("\nВведите number:");
        int number = scanner.nextInt();

        Order order = createOrder(number);

        result.add(order);
        result.add(createPaymentInvoice(number, order.getId()+1));
        result.add(createPayment(number, order.getId()+2));
        result.add(createInvoice(number, order.getId()+3));

        return result;
    }
}

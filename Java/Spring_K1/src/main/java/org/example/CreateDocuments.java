package org.example;

import javax.swing.text.View;
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

    public List<String> createDoc(String name) {
        List<String> result = new ArrayList<>();
        result.add(enterValue("Введите id: "));
        result.add(enterValue("Введите " + name + ": "));

        return result;
    }

    private String enterValue(String prompt) {
        System.out.println(prompt);

        return scanner.next().trim().toLowerCase();
    }

    public PaymentInvoice createPaymentInvoice(int number) {
        List<String> documentData = createDoc("customerName");
        return new PaymentInvoice(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(1)
        );
    }

    public Payment createPayment(int number){
        List<String> documentData = createDoc("nameSupplier");
        return new Payment(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(1)
        );
    }

    public Invoice createInvoice(int number){
        List<String> documentData = createDoc("clientName");
        return new Invoice(
                Integer.parseInt(documentData.get(0)),
                number,
                LocalDate.now(),
                documentData.get(1)
        );
    }

    public Order createOrder(int number){
        List<Double> unitPrice = new ArrayList<>();
        List<String> productName = new ArrayList<>();
        List<Integer> productAmount = new ArrayList<>();

        List<String> documentData = createDoc("buyerName");

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
                Integer.parseInt(documentData.get(0)), number,
                LocalDate.now(), documentData.get(1), productAmount,
                unitPrice, productName
        );
    }


    public ArrayList<Document> doDocs(){
        ArrayList<Document> result = new ArrayList<>();
        System.out.println("\nВведите number:");
        int number = scanner.nextInt();

        result.add(createOrder(number));
        result.add(createPaymentInvoice(number));
        result.add(createPayment(number));
        result.add(createInvoice(number));

        return result;
    }
}

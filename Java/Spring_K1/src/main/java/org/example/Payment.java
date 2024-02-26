package org.example;

import java.time.LocalDate;

public class Payment implements Document{
    private int id;
    private double price;
    private LocalDate paymentDate;
    private double amount;
    private String nameSupplier;

    public Payment() {}


    public Payment(int id, double price, LocalDate paymentDate, String nameSupplier) {
        this.id = id;
        this.price = price;
        this.paymentDate = paymentDate;
        this.nameSupplier = nameSupplier;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void displayInfo() {

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

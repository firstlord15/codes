package org.example;

import java.time.LocalDate;

public class Payment implements Document{
    private int id;
    private LocalDate paymentDate;
    private double paymentAmount;
    private String nameSupplier;

    public Payment() {}

    public Payment(int id, double price, LocalDate paymentDate, double paymentAmount, String nameSupplier) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
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

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}

package org.example;

import java.time.LocalDate;

public class PaymentInvoice implements Document {
    private int id;
    private double price;
    private LocalDate invoiceDate;
    private double amount;
    private String providerName;

    public PaymentInvoice(int id, double price, LocalDate invoiceDate, double amount, String providerName) {
        this.id = id;
        this.price = price;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.providerName = providerName;
    }

    public PaymentInvoice() {
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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

}

package org.example;

import java.time.LocalDate;

public class PaymentInvoice implements Document {
    private int id;
    private int paymentInvoiceNumber;
    private LocalDate invoiceDate;
    private double invoiceAmount;
    private String customerName;

    public PaymentInvoice() {}

    public PaymentInvoice(int id, int paymentInvoiceNumber, LocalDate invoiceDate, double invoiceAmount, String customerName) {
        this.id = id;
        this.paymentInvoiceNumber = paymentInvoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.customerName = customerName;
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

    public String getProviderName() {
        return customerName;
    }

    public void setProviderName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return invoiceAmount;
    }

    public void setAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getPaymentInvoiceNumber() {
        return paymentInvoiceNumber;
    }

    public void setPaymentInvoiceNumber(int paymentInvoiceNumber) {
        this.paymentInvoiceNumber = paymentInvoiceNumber;
    }
}

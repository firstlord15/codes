package org.example;

import java.time.LocalDate;

public class PaymentInvoice implements Document {
    private int id;
    private int paymentInvoiceNumber;
    private LocalDate invoiceDate;
    private String customerName;

    public PaymentInvoice() {}

    public PaymentInvoice(int id, int paymentInvoiceNumber, LocalDate invoiceDate, String customerName) {
        this.id = id;
        this.paymentInvoiceNumber = paymentInvoiceNumber;
        this.invoiceDate = invoiceDate;
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
        System.out.println(
                "id: "+ id +"\n" +
                "number: "+ paymentInvoiceNumber +"\n" +
                "date: "+ invoiceDate +"\n" +
                "customerName: "+ customerName +"\n"
        );
    }

    public String getProviderName() {
        return customerName;
    }

    public void setProviderName(String customerName) {
        this.customerName = customerName;
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

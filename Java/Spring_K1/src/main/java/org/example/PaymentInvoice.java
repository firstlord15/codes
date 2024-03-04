package org.example;

import java.time.LocalDate;

public class PaymentInvoice implements Document {
    private int id;
    private int paymentInvoiceNumber;
    private LocalDate paymentInvoiceDate;
    private String customerName;
    private String comments;

    public PaymentInvoice() {}

    public PaymentInvoice(int id, int paymentInvoiceNumber, LocalDate paymentInvoiceDate, String customerName) {
        this.id = id;
        this.paymentInvoiceNumber = paymentInvoiceNumber;
        this.paymentInvoiceDate = paymentInvoiceDate;
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
    public String displayInfo() {
        return  "id: "+ id +"\n" +
                "number: "+ paymentInvoiceNumber +"\n" +
                "date: "+ paymentInvoiceDate +"\n" +
                "customerName: "+ customerName +"\n";
    }

    public String getProviderName() {
        return customerName;
    }

    public void setProviderName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getInvoiceDate() {
        return paymentInvoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.paymentInvoiceDate = invoiceDate;
    }

    public int getPaymentInvoiceNumber() {
        return paymentInvoiceNumber;
    }

    public void setPaymentInvoiceNumber(int paymentInvoiceNumber) {
        this.paymentInvoiceNumber = paymentInvoiceNumber;
    }
}

package org.example;

public class SaveDocuments {
    Order order;
    PaymentInvoice paymentInvoice;
    Payment payment;
    Invoice invoice;

    public SaveDocuments(){};

    public SaveDocuments(Order order, PaymentInvoice paymentInvoice, Payment payment, Invoice invoice) {
        this.order = order;
        this.paymentInvoice = paymentInvoice;
        this.payment = payment;
        this.invoice = invoice;
    }


}

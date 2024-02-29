package org.example;

public class SaveDocuments {
    private Order order;
    private PaymentInvoice paymentInvoice;
    private Payment payment;
    private Invoice invoice;

    public SaveDocuments(){};
    public SaveDocuments(Order order, PaymentInvoice paymentInvoice, Payment payment, Invoice invoice) {
        this.order = order;
        this.paymentInvoice = paymentInvoice;
        this.payment = payment;
        this.invoice = invoice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentInvoice getPaymentInvoice() {
        return paymentInvoice;
    }

    public void setPaymentInvoice(PaymentInvoice paymentInvoice) {
        this.paymentInvoice = paymentInvoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}

package org.example;

import java.time.LocalDate;

public class Invoice implements Document{
    private int id;
    private int invoiceNumber;
    private LocalDate invoiceDate; // дата и время
    private String clientName; // заказчик
    private String address;

    public Invoice() {}

    public Invoice(int id, int invoiceNumber, LocalDate invoiceDate, String clientName) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.clientName = clientName;
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
                "number: "+ invoiceNumber +"\n" +
                "date: "+ invoiceDate +"\n" +
                "customerName: "+ clientName +"\n";
    }

    public LocalDate getWaybillDate() {
        return invoiceDate;
    }

    public void setWaybillDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}

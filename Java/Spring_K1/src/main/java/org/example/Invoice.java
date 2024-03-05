package org.example;

import java.time.LocalDateTime;

public class Invoice implements Document{
    private int id;
    private int invoiceNumber;
    private LocalDateTime invoiceDate; // дата и время
    private String clientName; // заказчик
    private String address;

    public Invoice(int id, int invoiceNumber, LocalDateTime invoiceDate, String clientName, String address) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.clientName = clientName;
        this.address = address;
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
                "clientName: "+ clientName +"\n" +
                "address: "+ address +"\n";
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

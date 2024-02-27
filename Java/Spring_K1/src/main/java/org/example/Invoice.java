package org.example;

import java.time.LocalDate;

public class Invoice implements Document{
    private int id;
    private LocalDate invoiceDate;
    private double invoiceAmount;
    private String clientName;

    public Invoice() {}

    public Invoice(int id, LocalDate invoiceDate, double invoiceAmount, String clientName, String nameProducts) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
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
    public void displayInfo() {
        
    }

    public LocalDate getWaybillDate() {
        return invoiceDate;
    }

    public void setWaybillDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return invoiceAmount;
    }

    public void setAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

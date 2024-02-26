package org.example;

import java.time.LocalDate;

public class Invoice implements Document{
    private int id;
    private LocalDate waybillDate;
    private double amount;
    private String clientName;
    private String nameProducts;

    public Invoice(int id, LocalDate waybillDate, double amount, String clientName, String nameProducts) {
        this.id = id;
        this.waybillDate = waybillDate;
        this.amount = amount;
        this.clientName = clientName;
        this.nameProducts = nameProducts;
    }

    public Invoice() {}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {

    }


    @Override
    public void displayInfo() {

    }

    public LocalDate getWaybillDate() {
        return waybillDate;
    }

    public void setWaybillDate(LocalDate waybillDate) {
        this.waybillDate = waybillDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String nameProducts) {
        this.nameProducts = nameProducts;
    }
}

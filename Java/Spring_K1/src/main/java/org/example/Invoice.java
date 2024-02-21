package org.example;

import java.time.LocalDate;

public class Invoice implements Document{
    private String id;
    private double price;
    private LocalDate date;
    private String nameSupplier;
    private Payment nextDocument;

    public Invoice(String id, double price, LocalDate date, String nameSupplier, Payment nextDocument) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.nameSupplier = nameSupplier;
        this.nextDocument = nextDocument;
    }

    public Invoice() {}


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Document getNextDocument() {
        return nextDocument;
    }

    @Override
    public void setNextDocument(Document nextDocument) {
        if (!(nextDocument instanceof Payment)) {
            try {
                throw new Exception("не подходяший тип документа, нужен Payment!");
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        this.nextDocument = (Payment) nextDocument;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }
}

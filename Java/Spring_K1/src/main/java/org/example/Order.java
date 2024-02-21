package org.example;

import java.time.LocalDate;

public class Order implements  Document {
    private String id;
    private double price;
    private LocalDate date;
    private String nameProduct;
    private String nameBuyer;
    private Invoice nextDocument;

    public Order() {}

    

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
        if (!(nextDocument instanceof Invoice)) {
            try {
                throw new Exception("не подходяший тип документа, нужен Invoice!");
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        this.nextDocument = (Invoice) nextDocument;
    }

    @Override
    public void displayInfo() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameBuyer() {
        return nameBuyer;
    }

    public void setNameBuyer(String nameBuyer) {
        this.nameBuyer = nameBuyer;
    }
}


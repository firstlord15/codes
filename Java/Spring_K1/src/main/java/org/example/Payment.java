package org.example;

import java.util.Date;

public class Payment implements Document{
    private String id;
    private double price;
    private Date date;
    private String nameSupplier;
    private Invoice prevDocument;
    private Waybill nextDocument;

    public Payment() {}

    public Payment(String id, double price, Date date, String nameSupplier, Invoice prevDocument, Waybill nextDocument) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.nameSupplier = nameSupplier;
        this.prevDocument = prevDocument;
        this.nextDocument = nextDocument;
    }

    public Payment(String id, double price, Date date, String nameSupplier, Invoice prevDocument) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.nameSupplier = nameSupplier;
        this.prevDocument = prevDocument;
    }

    public Payment(String id, double price, Date date, String nameSupplier) {
        this.id = id;
        this.price = price;
        this.date = date;
        this.nameSupplier = nameSupplier;
    }

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
        if (!(nextDocument instanceof Waybill)) {
            try {
                throw new Exception("не подходяший тип документа, нужен Invoice!");
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        this.nextDocument = (Waybill) nextDocument;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public Invoice getPrevDocument() {
        return prevDocument;
    }

    public void setPrevDocument(Document prevDocument) {
        if (!(prevDocument instanceof Invoice)) {
            try {
                throw new Exception("не подходяший тип документа, нужен Invoice!");
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        this.prevDocument = (Invoice) prevDocument;
    }
}

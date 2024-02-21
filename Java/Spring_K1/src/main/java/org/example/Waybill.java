package org.example;

import java.util.Date;

public class Waybill implements Document{
    private String id;
    private double price;
    private Date date;
    private String nameClient;
    private String nameProducts;
    private Payment prevDocument;

    public Waybill() {}

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public Document getNextDocument() {
        return null;
    }

    @Override
    public void setNextDocument(Document nextDocument) {

    }

    @Override
    public void displayInfo() {

    }
}

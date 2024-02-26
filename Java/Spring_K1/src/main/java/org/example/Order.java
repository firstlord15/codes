package org.example;

import java.time.LocalDate;
import java.util.List;

public class Order implements Document {
    private int id;
    private int orderNumber;
    private LocalDate orderDate;
    private String buyerName;
    private List<Double> unitPrice;
    private List<String> productName;

    public Order() {}


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int  id) {
        this.id = id;
    }

    @Override
    public void displayInfo() {

    }
}



package org.example;

import java.time.LocalDate;
import java.util.List;

public class Order implements Document {
    private int id;
    private int orderNumber;
    private LocalDate orderDate;
    private String buyerName;
    private List<Integer> productAmount;
    private List<Double> unitPrice;
    private List<String> productName;

    public Order() {}

    public Order(int id, int orderNumber, LocalDate orderDate, String buyerName, List<Integer> productAmount, List<Double> unitPrice, List<String> productName) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.buyerName = buyerName;
        this.productAmount = productAmount;
        this.unitPrice = unitPrice;
        this.productName = productName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int  id) {
        this.id = id;
    }

    @Override
    public String displayInfo() {
        return  "\n" +
                "id: "+ id +"\n" +
                "number: "+ orderNumber +"\n" +
                "date: "+ orderDate +"\n" +
                "customerName: "+ buyerName +"\n" +
                "Products: "+ productName.get(0) +" "+ unitPrice.get(0) +" "+productAmount.get(0) + " (" + (productName.size() - 1) +")" + "\n";
    }

    public void addProduct(String productName, Double unitPrice, Integer amount) {
        this.productName.add(productName);
        this.unitPrice.add(unitPrice);
        this.productAmount.add(amount);


    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public List<Double> getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(List<Double> unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<String> getProductName() {
        return productName;
    }

    public void setProductName(List<String> productName) {
        this.productName = productName;
    }

    public List<Integer> getAmount() {
        return productAmount;
    }

    public void setAmount(List<Integer> productAmount) {
        this.productAmount = productAmount;
    }
}


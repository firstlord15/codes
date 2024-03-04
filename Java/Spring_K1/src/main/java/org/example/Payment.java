package org.example;

import java.time.LocalDate;

public class Payment implements Document{
    private int id;
    private int paymentNumber;
    private LocalDate paymentDate; // дата и время
    private String nameSupplier; // Плательщик // тип оплаты и данные краты если онлайн *********7842

    public Payment() {}

    public Payment(int id, int paymentNumber, LocalDate paymentDate, String nameSupplier) {
        this.id = id;
        this.paymentNumber = paymentNumber;
        this.paymentDate = paymentDate;
        this.nameSupplier = nameSupplier;
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
                "number: "+ paymentNumber +"\n" +
                "date: "+ paymentDate +"\n" +
                "customerName: "+ nameSupplier +"\n";
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }
}

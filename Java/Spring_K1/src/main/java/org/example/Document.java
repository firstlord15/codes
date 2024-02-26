package org.example;

public interface Document {
    // Метод для получения уникального идентификатора документа
    public int getId();

    // Метод для установки уникального идентификатора документа
    public void setId(int id);

    // Метод для вывода информации о документе
    public void displayInfo();
}

package org.example;

public interface Document {
    // Метод для получения уникального идентификатора документа
    int getId();

    // Метод для установки уникального идентификатора документа
    void setId(int id);

    // Метод для вывода информации о документе
    String displayInfo();
}

package org.example;

public interface Document {
    // Метод для получения уникального идентификатора документа
    public String getId();

    // Метод для установки уникального идентификатора документа
    public void setId(String id);

    // Метод для получения следующего документа в цепочке
    public Document getNextDocument();

    // Метод для установки следующего документа в цепочке
    public void setNextDocument(Document nextDocument);

    // Метод для вывода информации о документе
    public void displayInfo();
}

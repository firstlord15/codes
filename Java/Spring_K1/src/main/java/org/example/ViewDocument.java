package org.example;
import java.util.List;

public class ViewDocument {
    // Метод для вывода всех существующих документов
    public void displayAllDocuments(List<Document> documents) {
        for (Document doc : documents) {
            doc.displayInfo();
        }
    }
}
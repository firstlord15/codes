package org.example;
import java.util.List;

public class ViewDocument {
    // Метод для вывода всех существующих документов
    public void displayAllDocuments(List<Document> documents) {
        for (Document doc : documents) {
            doc.displayInfo();
        }
    }

    // Метод для поиска документа по его идентификатору
    public Document findDocumentById(List<Document> documents, String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null; // Документ не найден
    }
}
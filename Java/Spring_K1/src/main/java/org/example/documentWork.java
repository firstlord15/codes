package org.example;
import org.example.models.Document;

import java.util.ArrayList;

public class DocumentWork {
    private ArrayList<Document> documents;

    public DocumentWork(){}

    public DocumentWork(ArrayList<Document> documents) {
        this.documents = documents;
    }

    // Метод для вывода всех существующих документов


    public ArrayList<Document> getDocuments() {
        return documents;
    }
    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
}
package org.example;
import org.example.models.Document;

import java.util.ArrayList;

public class documentWork {
    private ArrayList<Document> documents;

    public documentWork(){}

    public documentWork(ArrayList<Document> documents) {
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
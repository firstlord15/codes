package org.example;
import java.util.ArrayList;
import java.util.List;

public class ViewDocument {
    private ArrayList<Document> documents;

    public ViewDocument(){
        CreateDocuments createDocuments = new CreateDocuments();
        this.documents = createDocuments.doDocs();
    }

    public ViewDocument(ArrayList<Document> documents) {
        this.documents = documents;
    }

    // Метод для вывода всех существующих документов
    public void displayAllDocuments() {
        for (Document doc : documents) {
            doc.displayInfo();
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
}
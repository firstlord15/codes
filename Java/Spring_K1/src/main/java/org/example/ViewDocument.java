package org.example;
import java.util.ArrayList;

public class ViewDocument {
    private ArrayList<Document> documents;

    public ViewDocument(){}
    public ViewDocument(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void CreateDocs(){
        CreateDocuments createDocuments = new CreateDocuments();
        this.documents = createDocuments.doDocs();
    }

    // Метод для вывода всех существующих документов
    public void displayAllDocuments() {
        for (Document doc : documents) {
            System.out.println(doc.displayInfo());
        }
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
}
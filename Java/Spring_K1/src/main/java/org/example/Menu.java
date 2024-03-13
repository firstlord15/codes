package org.example;

import org.example.models.Document;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private ArrayList<ArrayList<Document>> listDocuments;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.listDocuments = new ArrayList<>();
    }

    public void displayAllDocuments(ArrayList<Document> documents) {
        for (Document doc : documents) {
            System.out.println(doc.displayInfo());
        }
    }

    private int chooseDocument(String action) {
        if (listDocuments.isEmpty()) {
            System.out.println("Нет циклов документов для " + action.toLowerCase() + ".");
            return -1;
        }

        System.out.println("[" + action + " цикла документов]");
        for (int i = 0; i < listDocuments.size(); i++) {
            ArrayList<Document> listDocument = listDocuments.get(i);
            System.out.println("[" + i + "]  Doc number: " + listDocument.get(0).getNumber());
        }

        System.out.print("Выберите нужную вам цепочку документов: ");
        int indexDocs = scanner.nextInt();
        scanner.nextLine();

        if (indexDocs < 0 || indexDocs >= listDocuments.size()) {
            System.out.println("Некорректный номер цепочки документов.");
            return -1;
        }

        return indexDocs;
    }

    public void createDocs() {
        CreateDocuments createDocuments = new CreateDocuments();
        listDocuments.add(createDocuments.doDocs());
    }

    public void viewDocs() {
        int indexDocs = chooseDocument("Просмотр");
        if (indexDocs >= 0) {
            displayAllDocuments(listDocuments.get(indexDocs));
        }
    }

    public void editDocs() {
        int indexDocs = chooseDocument("Редактирование");
        if (indexDocs >= 0) {
            DocumentType[] documentTypes = DocumentType.values();

            for (int i = 0; i < documentTypes.length; i++) {
                DocumentType documentType = documentTypes[i];
                System.out.println("["+ i +"] " + documentType);
            }

            int indexDocType = scanner.nextInt();

            Document document = listDocuments.get(indexDocs).get(indexDocType);
            Field[] fields = document.getClass().getFields();

            for (int i = 0; i < fields.length - 1; i++){
                System.out.println("["+ i +"] " + fields[i]);
            }

            int indexField = scanner.nextInt();

        }
    }

    public void deleteDocs() {
        int indexDocs = chooseDocument("Удаление");
        if (indexDocs >= 0) {
            listDocuments.remove(indexDocs);
        }
    }

    public int mainMenu() {
        System.out.println("[Основное меню]");
        System.out.println("[1] Создание цикла документов");
        System.out.println("[2] Просмотр цикла документов");
        System.out.println("[3] Редактирование цикла документов");
        System.out.println("[4] Удаление цикла документов");
        System.out.println("[5] Для выхода\n");

        String answer = scanner.nextLine();

        if (!answer.isEmpty() && answer.matches("\\d+")) {
            return Integer.parseInt(answer);
        } else {
            System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 5.");
            return mainMenu();
        }
    }

    public void menu() {
        while (true) {
            int number = mainMenu();

            switch (number) {
                case 1: createDocs();
                    break;
                case 2: viewDocs();
                    break;
                case 3: editDocs();
                    break;
                case 4: deleteDocs();
                    break;
                case 5: System.exit(0);
                default: System.out.println("Некорректный ввод. Пожалуйста, повторите попытку.");
            }
        }
    }



    public void method(){

    }

    public List<ArrayList<Document>> getListDocuments() {
        return listDocuments;
    }

    public void setListDocuments(ArrayList<ArrayList<Document>> listDocuments) {
        this.listDocuments = listDocuments;
    }
}



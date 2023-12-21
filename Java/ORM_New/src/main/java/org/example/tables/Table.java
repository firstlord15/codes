package org.example.tables;

import java.util.ArrayList;

public class Table {
    private String tableName;
    private ArrayList<Column> columns;


    public Table(String tableName, ArrayList<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public void addColumn(Column column){
        columns.add(column);
    }

    public void removeLast() {
        columns.removeLast();
    }

    public Column getColum(int index){
        return columns.get(index);
    }

    public Column getFirstColum(){
        return columns.getFirst();
    }

    public Column getLastColum(){
        return columns.getLast();
    }
}

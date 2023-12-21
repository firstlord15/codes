package org.example;

import org.example.tables.Column;
import org.example.tables.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcExecutor {
    public static String generateQueryCreateTable(Table table){
        StringBuilder columns = new StringBuilder();

        for (Column column: table.getColumns()){
            columns.append(column.getColumns()).append(", ");
        }

        return "CREATE TABLE " + table.getTableName() + " ( "+ columns.deleteCharAt(columns.length()-2) +")";
    }

    public static String generateInsertDataInTable(Object entity, String tableName, Field[] fields) {
        StringBuilder allValues = new StringBuilder();
        StringBuilder allFields = new StringBuilder();

        try {
            for (Field field: fields){
                field.setAccessible(true);
                Object value = field.get(entity); // Извлекаем значение поля для текущего объекта

                allFields.append(field.getName()).append(", ");
                allValues.append("'").append(value).append("', ");
            }
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }

        allFields.setLength(allFields.length() - 2);
        allValues.setLength(allValues.length() - 2);

        return "INSERT INTO " + tableName + " (" + allFields + ") values (" + allValues + ");";
    }

    public static void test_connection(String DB_URL, String USER, String PASSWORD) {
        System.out.println("Тестирование подключения к PostgresSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgresSQL JDBC Driver не был найден. Скачайте или укажите import библиотеки");
            e.printStackTrace();;
            return;
        }

        System.out.println("PostgresSQL JDBC Driver successfully connected");

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)){
            System.out.println("Вы успешно подключились к database!\n");
        } catch (SQLException e) {
            System.out.println("Подключение провалилось!");
            e.printStackTrace();;
            System.out.println("\n");
        }
    }
}

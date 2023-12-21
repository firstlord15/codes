package org.example;

import org.example.annotations.ColumnAnnotation;
import org.example.annotations.IdAnnotation;
import org.example.annotations.MyEntity;
import org.example.annotations.TableAnnotation;
import org.example.tables.Column;
import org.example.tables.Table;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.JdbcExecutor.*;

public class EntityManager {
    private String DB_URL;
    private String USER;
    private String PASSWORD;
    ArrayList<Column> columns;


    public EntityManager(String DB_URL, String USER, String PASSWORD) {
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.columns = new ArrayList<>();
    }

    public String getTableName(Class<?> clazz) {
        String tableName = clazz.getSimpleName().toLowerCase();
        TableAnnotation tableAnnotation = clazz.getDeclaredAnnotation(TableAnnotation.class);

        if (tableAnnotation != null) {
            if (!tableAnnotation.name().isEmpty())
                tableName = tableAnnotation.name().toLowerCase();
        }

        return tableName;
    }

    public void createTable(Class<?> clazz) {
        MyEntity entityAnnotation = clazz.getDeclaredAnnotation(MyEntity.class);
        String tableName = getTableName(clazz);
        this.columns = new ArrayList<>();

        if (entityAnnotation == null) {
            System.out.println("Entity class must be annotated with @MyEntity!");
            return;
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            ColumnAnnotation columnAnnotation = field.getDeclaredAnnotation(ColumnAnnotation.class);
            IdAnnotation idAnnotation = field.getDeclaredAnnotation(IdAnnotation.class);

            if (idAnnotation != null){
                columns.add(new Column(field.getName()));
            } else if (columnAnnotation != null) {
                String columnName = !columnAnnotation.name().isEmpty() ? columnAnnotation.name() : field.getName();
                columns.add(new Column(columnName, columnAnnotation.type(), columnAnnotation.nullable()));
            }
        }

        Table table = new Table(tableName, columns);
        executeUpdate(generateQueryCreateTable(table));
    }


    public void save(Object entity) {
        Class<?> clazz = entity.getClass();
        TableAnnotation tableAnnotation = clazz.getDeclaredAnnotation(TableAnnotation.class);
        String tableName = clazz.getSimpleName().toLowerCase();

        // Иначе он просто выдет ошибку "возможно null"
        if (tableAnnotation != null){
            if (!tableAnnotation.name().isEmpty()){
                tableName = tableAnnotation.name().toLowerCase();
            }
        }


        Field[] fields = clazz.getDeclaredFields();
        executeUpdate(generateInsertDataInTable(entity, tableName, fields));
    }

    public void drop(Class<?> clazz){
        executeUpdate(generateQueryDropTable(clazz));
    }

    // изменения в бд в отдельном методе, удобнее, чем везде пихать отдельно
    private void executeUpdate(String sql) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении SQL: " + sql);
            e.printStackTrace();
        }
    }


    public String getDB_URL() {
        return DB_URL;
    }

    public void setDB_URL(String DB_URL) {
        this.DB_URL = DB_URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}

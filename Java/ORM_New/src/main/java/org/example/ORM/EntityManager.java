package org.example.ORM;

import org.example.ORM.annotations.ColumnAnnotation;
import org.example.ORM.annotations.IdAnnotation;
import org.example.ORM.annotations.EntityAnnotation;
import org.example.ORM.tables.Column;
import org.example.ORM.tables.Table;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

import static org.example.ORM.JdbcExecutor.*;

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

    public void createTable(Class<?> clazz) {
        EntityAnnotation entityAnnotation = clazz.getDeclaredAnnotation(EntityAnnotation.class);
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

        Table table = new Table(getTableName(clazz), columns);
        executeUpdate(generateQueryCreateTable(table));
    }

    public void select(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "SELECT * FROM " + getTableName(clazz) + ";";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    System.out.println("Table: " + getTableName(clazz));

                    for (Field field: fields) {
                        ColumnAnnotation columnAnnotation = field.getDeclaredAnnotation(ColumnAnnotation.class);
                        IdAnnotation idAnnotation = field.getDeclaredAnnotation(IdAnnotation.class);

                        if (idAnnotation == null | columnAnnotation == null){
                            System.out.println(field.getName() + ": " + resultSet.getString(field.getName()));
                        }
                    }
                }

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Object entity) {
        Class<?> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        executeUpdate(generateInsertDataInTable(entity, getTableName(clazz), fields));
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

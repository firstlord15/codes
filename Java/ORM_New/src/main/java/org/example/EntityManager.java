package org.example;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Objects;

public class EntityManager {
    private String DB_URL;
    private String USER;
    private String PASSWORD;
    private static final HashMap<Class<?>, String> SQL_TYPE_MAP = new HashMap<>();

    static {
        SQL_TYPE_MAP.put(String.class, "VARCHAR(255)");
        SQL_TYPE_MAP.put(int.class, "INT");
        SQL_TYPE_MAP.put(Integer.class, "INT");
        SQL_TYPE_MAP.put(double.class, "DOUBLE");
        SQL_TYPE_MAP.put(Double.class, "DOUBLE");
        SQL_TYPE_MAP.put(float.class, "FLOAT");
        SQL_TYPE_MAP.put(Float.class, "FLOAT");
        SQL_TYPE_MAP.put(long.class, "INT");
        SQL_TYPE_MAP.put(Long.class, "INT");
        SQL_TYPE_MAP.put(boolean.class, "BOOLEAN");
        SQL_TYPE_MAP.put(Boolean.class, "BOOLEAN");
        SQL_TYPE_MAP.put(java.sql.Timestamp.class, "TIMESTAMP");
    }

    public EntityManager(String DB_URL, String USER, String PASSWORD) {
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    public EntityManager() {
        this.DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        this.USER = "postgres";
        this.PASSWORD = "postgres";
    }

    public void createTable(Object entity) {
        Class<?> entityClass = entity.getClass();
        MyEntity entityAnnotation = entityClass.getDeclaredAnnotation(MyEntity.class);
        Table tableAnnotation = entityClass.getDeclaredAnnotation(Table.class);
        String tableName;

        if (entityAnnotation == null) {
            System.out.println("Entity class must be annotated with @MyEntity");
            return;
        }

        if (tableAnnotation != null & !tableAnnotation.name().equals("")) {
            tableName = tableAnnotation.name().toLowerCase();
        } else {
            tableName = entityClass.getSimpleName().toLowerCase();
        }

        Field[] fields = entityClass.getDeclaredFields();

        StringBuilder queryCreateTable = new StringBuilder();
        queryCreateTable.append("CREATE TABLE ").append(tableName).append(" (");

        for (Field field : fields) {
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);

            if ("id".equalsIgnoreCase(field.getName())) {
                queryCreateTable.append(field.getName()).append(" serial PRIMARY KEY,").append("  ");
                continue;
            }
            queryCreateTable.append(field.getName()).append(" ").append(SQL_TYPE_MAP.get(field.getType()));

            if (columnAnnotation != null && !columnAnnotation.nullable()) {
                queryCreateTable.append(" NOT NULL");
            }
            queryCreateTable.append(", ");
        }
        queryCreateTable.setLength(queryCreateTable.length() - 2);
        queryCreateTable.append(");");

        executeUpdate(queryCreateTable.toString());
    }


    public void save(Object entity) {
        Class<?> entityClass = entity.getClass();
        Field[] fields = entityClass.getDeclaredFields();
        Table tableAnnotation = entityClass.getDeclaredAnnotation(Table.class);
        String tableName;


        if (tableAnnotation != null & !tableAnnotation.name().equals("")) {
            tableName = tableAnnotation.name().toLowerCase();
        } else {
            tableName = entityClass.getSimpleName().toLowerCase();
        } // без именни пакета, выдает имя класса

        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder values = new StringBuilder("VALUES (");

        for (Field field : fields) {
            field.setAccessible(true); // Доступ к приватным полям
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (!field.getName().equals("id")){
                query.append(field.getName()).append(", ");
                values.append("'").append(columnAnnotation.value()).append("'").append(", ");
            }
        }

        // Последние два символа, то есть последняя запятая и пробел в строках запроса удаляются:
        query.setLength(query.length() - 2);
        values.setLength(values.length() - 2);
        query.append(") ").append(values).append(");"); // объеденять

        executeUpdate(query.toString());
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

    public void test_connection() {
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

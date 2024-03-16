package org.example;

import java.sql.*;

public class DatabaseManager {
    private final Connection connection;

    public DatabaseManager() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_name", "username", "password");
    }

    public void createDocumentTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS documents (id SERIAL PRIMARY KEY, number TEXT, content TEXT)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void insertDocument(String number, String content) throws SQLException {
        String sql = "INSERT INTO documents (number, content) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, number);
            pstmt.setString(2, content);
            pstmt.executeUpdate();
        }
    }

    // Другие методы для работы с базой данных, например, получение всех документов
}

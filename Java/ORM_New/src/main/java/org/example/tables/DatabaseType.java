package org.example.tables;

import java.security.Timestamp;

public enum DatabaseType {
    ID ("serial PRIMARY KEY", null),
    STRING("VARCHAR(255)", String.class),
    INT("INT", int.class),
    BOOLEAN("BOOLEAN", boolean.class),
    DOUBLE("DOUBLE", double.class),
    TIMESTAMP("TIMESTAMP", Timestamp.class);

    private final String databaseType;
    private final Class<?> type;

    DatabaseType(String databaseType, Class<?> type) {
        this.databaseType = databaseType;
        this.type = type;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public Class<?> getType() {
        return type;
    }
}

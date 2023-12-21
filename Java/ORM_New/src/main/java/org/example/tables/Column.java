package org.example.tables;

public class Column {
    private String columnName;
    private DatabaseType type;
    private boolean nullable;
    private final boolean isId;

    public Column(String columnName, DatabaseType type, boolean nullable) {
        this.columnName = columnName.toLowerCase();
        this.type = type;
        this.nullable = nullable;
        this.isId = false;
    }

    public Column(String columnName) {
        this.columnName = columnName.toLowerCase();
        this.isId = true;
    }

    // окончательный результат поля
    public String getColumns() {
        if (isId){
            return columnName + " " + DatabaseType.ID.getDatabaseType();
        }

        String nullable = this.nullable ? "NULL" : "NOT NULL";
        return columnName + " " + type.getDatabaseType() + " " + nullable;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public DatabaseType getType() {
        return type;
    }

    public void setType(DatabaseType type) {
        this.type = type;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isId() {
        return isId;
    }
}

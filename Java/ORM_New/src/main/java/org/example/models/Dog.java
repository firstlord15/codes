package org.example.models;

import org.example.ORM.annotations.ColumnAnnotation;
import org.example.ORM.annotations.EntityAnnotation;
import org.example.ORM.annotations.IdAnnotation;
import org.example.ORM.tables.DatabaseType;

@EntityAnnotation
public class Dog {
    @IdAnnotation
    private int id;

    @ColumnAnnotation(nullable = false, type = DatabaseType.STRING)
    private String name;

    @ColumnAnnotation(nullable = false, type = DatabaseType.INT)
    private int age;

    public Dog(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

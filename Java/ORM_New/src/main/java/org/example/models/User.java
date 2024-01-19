package org.example.models;

import org.example.ORM.annotations.ColumnAnnotation;
import org.example.ORM.annotations.IdAnnotation;
import org.example.ORM.annotations.EntityAnnotation;
import org.example.ORM.annotations.TableAnnotation;

@EntityAnnotation
@TableAnnotation(name = "Person")
public class User {
    @IdAnnotation
    private final int id;

    @ColumnAnnotation(nullable = false)
    private String username;

    @ColumnAnnotation(nullable = false)
    private String password;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

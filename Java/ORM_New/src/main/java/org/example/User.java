package org.example;

@MyEntity
@Table(name = "Person")
public class User {
    @Id
    private long id;

    @Column(value = "firstlord15", nullable = false)
    private String username;

    @Column(value = "q@erty11", nullable = false)
    private String password;

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

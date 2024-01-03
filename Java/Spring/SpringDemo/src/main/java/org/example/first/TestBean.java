package org.example.first;

public class TestBean {
    private String name;
    private String surname;

    public TestBean(String name) {
        this.name = name;
    }

    public TestBean(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

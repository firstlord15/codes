public class Person {
    private String name;
    private String surname;
    private String phoneNumber;

    Person (String name, String surname, String phoneNumber){
        this.name = name.toLowerCase();;
        this.surname = surname.toLowerCase();;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getSurname() {
        return this.surname.substring(0, 1).toUpperCase() + this.surname.substring(1);
    }

    public void setSurname(String surname) {
        this.surname = surname.toLowerCase();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

import java.util.UUID;

public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String id;

    Person(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.id = generateUniqueId();
    }

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim().toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim().toLowerCase();
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id = '" + id + '\'' +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", phoneNumber = " + phoneNumber +
                '}';
    }
}

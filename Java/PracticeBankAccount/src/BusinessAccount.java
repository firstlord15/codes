import java.time.LocalDateTime;

public class BusinessAccount extends Account{
    private static final String nameTypeAccount = "Bank Account";
    private static final LocalDateTime timeOpenAccount = LocalDateTime.now();
    private final DebitCard debitCard;
    BusinessAccount(String name, String surname, String accountID, double balance, String currency, String phoneNumber) {
        super(name, surname, accountID, phoneNumber);
    }

    @Override
    public void transfer(double amount, BankAccount transferee) {

    }

    @Override
    public void withdraw(double amount) {
        
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public String getFormatHistory(int method, double amount, String actingPerson) {
        return null;
    }

    // getter and setter
}

public class BusinessAccount extends Account{

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

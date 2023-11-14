import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private Person person;
    private String accountId;
    private double balance;
    private TransactionHistory history = new TransactionHistory();

    Account(Person person){
        this.person = person;
        this.balance = 0;
        this.accountId = generateId();
    }

    public ArrayList<Transaction> getHistory() {
        return history.getTransitionHistory();
    }

    public void setHistory(TransactionHistory history) {
        this.history = history;
    }

    public void addTransition(Transaction transition){
        history.addTransaction(transition);
    }

    public String generateId(){
        return UUID.randomUUID().toString();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    private void applyTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT) {
            deposit(transaction.getAmount());
        } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
            withdraw(transaction.getAmount());
        }
        history.addTransaction(transaction);
    }

    public void transferTo(Account recipientAccount, double amount, Currency currency) {
        if (amount > 0 && balance >= amount) {
            createTransaction(-amount, TransactionType.WITHDRAWAL, currency);
            recipientAccount.createTransaction(amount, TransactionType.DEPOSIT, currency);
        } else {
            System.out.println("Недостаточно баланса");
        }
    }

    public void createTransaction(double amount, TransactionType type, Currency currency) {
        Transaction transaction = new Transaction(amount, type, currency);
        applyTransaction(transaction);
    }

    // Проблема с курсом, либо оставить и доработать, либо высечь
}

import java.util.ArrayList;

abstract class Account {
    private final String accountID;
    private double balance;
    private String currency;
    private final String name;
    private final String surname;
    private final ArrayList<String> history;

    Account(String name, String surname, String accountID, double balance, String currency){
        this.accountID = accountID;
        this.balance = balance;
        this.currency = currency;
        this.name = name;
        this.surname = surname;
        this.history = new ArrayList<>();
    }

    public String getHistoryLast() {
        try {
            return history.getLast();
        } catch (Exception e){
            return  "Nothing";
        }
    }

    public void addOperation(String str){history.add(str);}

    public String getAccountID() {return accountID;}

    public double getBalance(){return balance;}
    public void setBalance(double newBalance){balance = newBalance;}

    public String getCurrency(){return currency;}
    public void setCurrency(String newCurrency){currency = newCurrency;}

    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getFullName(){return name + " " + surname;}

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void transfer(double amount, Account transferee);
}

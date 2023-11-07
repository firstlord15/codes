import java.util.ArrayList;

abstract class Account {
    private String accountId;
    private final String name;
    private final String surname;
    private String phoneNumber;
    private final ArrayList<String> history;
    private static int historyCount = 0;
    private String typeAccount;

    Account(String name, String surname, String accountID, String phoneNumber){
        this.accountId = accountID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.history = new ArrayList<>();
    }


    // getter and setter
    public String getHistoryLast() {
        try { return history.getLast(); }
        catch (Exception e){ return  "Nothing"; }
    }

    public String getHistoryAll() {
        try {
            String result = "";
            for (String str: history) { result += str; }
            return result;
        }
        catch (Exception e){ return "Nothing"; }
    }

    public void setHistory(String str){
        history.add(str);
        historyCount++;
    }

    public int getHistoryCount() { return historyCount; }

    public String getTypeAccount() { return typeAccount; }
    public void setTypeAccount(String typeAccount) { this.typeAccount = typeAccount; }

    public String getAccountId() { return accountId; }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getFullName() { return name + " " + surname; }


    // основные операции
    public abstract void transfer(double amount, BankAccount transferee);
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    // остальные методы
    public abstract String getFormatHistory(int method, double amount, String actingPerson);
}

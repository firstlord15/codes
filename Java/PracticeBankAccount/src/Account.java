import java.util.ArrayList;

abstract class Account {
    private final String accountID;
    private final String name;
    private final String surname;
    private String phoneNumber;
    private final ArrayList<String> history;
    private static int historyCount = 0;
    private String typeAccount;

    Account(String name, String surname, String accountID, String phoneNumber){
        this.accountID = accountID;
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
    public String getAccountID() { return accountID; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public double getBalance(BankAccount bankAccount) { return bankAccount.getDebitCard().getBalance(); }
    public double getBalance(BusinessCard card) { return card.getBalance(); }

    public void setBalance(double newBalance, BankAccount bankAccount){ bankAccount.getDebitCard().setBalance(newBalance); }
    public void setBalance(double newBalance, BusinessCard card){ card.setBalance(newBalance); }

    public String getCurrency(BankAccount bankAccount) { return bankAccount.getDebitCard().getCurrency(); }
    public String getCurrency(BusinessCard card) { return card.getCurrency(); }

    public void setCurrency(String currency, BankAccount bankAccount){ bankAccount.getDebitCard().setCurrency(currency); }
    public void setCurrency(String currency, BusinessCard card){ card.setCurrency(currency); }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getFullName() { return name + " " + surname; }


    // основные операции
    public abstract void transfer(double amount, BankAccount transferee);
    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    // остальные методы
    public String getFormatHistory(int method, double amount, String actingPerson){
        if (actingPerson != null){
            method += 2;
        }

        switch (method){
            case 0 -> {return "У вас +" + amount + getCurrency();}
            case 1 -> {return "У вас -" + amount + getCurrency();}
            case 2 -> {return "У вас +" + amount + getCurrency() + ", Отправитель: " + actingPerson;}
            case 3 -> {return "У вас -" + amount + getCurrency() + ", Получатель: " + actingPerson;}
            default -> {return "Ошибка, неверный метод";}
        }
    }
}

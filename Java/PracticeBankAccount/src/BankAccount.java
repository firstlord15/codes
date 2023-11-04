import java.util.ArrayList;

public class BankAccount extends Account{
    private final String numberCard;
    private final ArrayList<String> history;

    BankAccount(String accountID, double balance, String currency, String name, String surname, String numberCard) {
        super(name, surname, accountID, balance, currency);
        this.numberCard = numberCard;
        history = new ArrayList<>();
    }

    public String getNumberCard() {return numberCard;}
    public String getHistoryLast() {
        try {
            return history.getLast();
        } catch (Exception e){
            return  "Nothing";
        }
    }
    private void setHistory(String str){history.add(str);}

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        setHistory(getFormatHistory(0, amount, null));
    }

    // Надо решить проблему с удвоенным добовлением события в истории из-за 39 строки

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        setHistory(getFormatHistory(1, amount, null));
    }

    // Решить проблему с получателем у получателя после трансфера

    @Override
    public void transfer(double amount, Account transferee) {
        transferee.deposit(amount);
        this.withdraw(amount);

        setHistory(getFormatHistory(1, amount, transferee.getFullName()));
    }

    private String getFormatHistory(int method, double amount, String actingPerson){
        if (actingPerson != null){method += 2;}

        switch (method){
            case 0 -> {return "У вас +" + amount + getCurrency();}
            case 1 -> {return "У вас -" + amount + getCurrency();}
            case 2 -> {return "У вас +" + amount + getCurrency() + " Отправитель " + actingPerson;}
            case 3 -> {return "У вас -" + amount + getCurrency() + ", Получатель: " + actingPerson;}
            default -> {return "Ошибка, неверный метод";}
        }
    }

    public String getInfoAccount(){
        return "ID: " + this.getAccountID() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + this.getNumberCard() + "\n" +
                "Баланс: " + this.getBalance() + this.getCurrency() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n";
    }

}

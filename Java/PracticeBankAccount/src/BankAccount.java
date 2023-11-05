import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class BankAccount extends Account{
    private final String numberCard;
    private static final String nameTypeAccount = "Bank Account";
    private static final LocalDateTime timeOpenAccount = LocalDateTime.now();

    BankAccount(String name, String surname, String accountID, double balance, String currency, String phoneNumber, ArrayList<BankAccount> listAccounts) {
        super(name, surname, accountID, balance, currency, phoneNumber);
        this.numberCard = setNumberCard(listAccounts);
        setTypeAccount(nameTypeAccount);
    }


    public static LocalDateTime getTimeOpenAccount(){
        return timeOpenAccount;
    }

    public String getNumberCard() {
        return numberCard;
    }

    private String generateNumberCard() {
        String result = "2806" + this.getAccountID();

        while(result.length() < 16) {
            int randomNum = ThreadLocalRandom.current().nextInt(10);
            result += randomNum;
        }

        return result;
    }


    private String setNumberCard(ArrayList<BankAccount> listAccounts){
        String number;
        int maxAttempts = 100;  // Максимальное количество попыток

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            number = generateNumberCard();
            boolean isUnique = true;

            for (BankAccount account : listAccounts) {
                if (account.getNumberCard().equals(number)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return number;
            }
        }

        throw new IllegalStateException("Не удалось найти уникальный номер карты");
    }


    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть больше 0!");
        }

        setBalance(getBalance() + amount);
        addOperation(getFormatHistory(0, amount, null));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше 0!");
        }

        if (this.getBalance() < amount) {
            throw new IllegalArgumentException("Не хватает средств!");
        }

        setBalance(getBalance() - amount);
        addOperation(getFormatHistory(1, amount, null));
    }

    @Override
    public void transfer(double amount, Account transferee) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше 0!");
        }

        if (this.getBalance() < amount) {
            throw new IllegalArgumentException("Не хватает средств!");
        }

        transferee.setBalance(transferee.getBalance() + amount);
        this.setBalance(getBalance() - amount);

        transferee.addOperation(getFormatHistory(0, amount, this.getFullName()));
        addOperation(getFormatHistory(1, amount, transferee.getFullName()));
    }

    private String getFormatHistory(int method, double amount, String actingPerson){
        if (actingPerson != null){method += 2;}

        switch (method){
            case 0 -> {return "У вас +" + amount + getCurrency();}
            case 1 -> {return "У вас -" + amount + getCurrency();}
            case 2 -> {return "У вас +" + amount + getCurrency() + ", Отправитель: " + actingPerson;}
            case 3 -> {return "У вас -" + amount + getCurrency() + ", Получатель: " + actingPerson;}
            default -> {return "Ошибка, неверный метод";}
        }
    }

    public String getMainAccountDetails(){
        return  "ID: " + this.getAccountID() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + this.getNumberCard() + "\n" +
                "Баланс: " + this.getBalance() + this.getCurrency() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n";
    }

    public String getExtendedAccountDetails(){
        return  "ID: " + this.getAccountID() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + this.getNumberCard() + "\n" +
                "Номер телефона: " + this.getPhoneNumber() + "\n" +
                "Баланс: " + this.getBalance() + this.getCurrency() + "\n" +
                "Тип аккаунта: " + getTypeAccount() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n" +
                "Время создания аккаунта: " + getTimeOpenAccount() + "\n";
    }
}

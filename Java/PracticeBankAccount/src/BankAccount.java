import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class BankAccount extends Account{
    private static final String nameTypeAccount = "Bank Account";
    private static final LocalDateTime timeOpenAccount = LocalDateTime.now();
    private final DebitCard debitCard;

    BankAccount(String name, String surname, String accountID, String phoneNumber, double balance, String currency, ArrayList<BankAccount> listAccounts) throws Exception {
        super(name, surname, accountID, phoneNumber);
        this.debitCard = new DebitCard(addNumberCard(listAccounts), timeOpenAccount.getMonthValue() +"/"+ timeOpenAccount.getDayOfMonth(), balance, currency);
        setTypeAccount(nameTypeAccount);
    }

    // getter and setter
    public static LocalDateTime getTimeOpenAccount(){
        return timeOpenAccount;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public String getNumberCard() {
        return debitCard.getCardNumber();
    }

    private String addNumberCard(ArrayList<BankAccount> listAccounts){
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

    // основные операции
    @Override
    public void deposit(double amount) {
        DebitCard card = getDebitCard();

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть больше 0!");
        }

        card.setBalance(card.getBalance() + amount);
        setHistory(getFormatHistory(0, amount, null));
    }

    @Override
    public void withdraw(double amount) {
        DebitCard card = getDebitCard();

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть больше 0!");
        }

        if (card.getBalance() < amount) {
            throw new IllegalArgumentException("Не хватает средств!");
        }

        card.setBalance(card.getBalance() - amount);
        setHistory(getFormatHistory(1, amount, null));
    }

    @Override
    public void transfer(double amount, BankAccount transferee) {
        DebitCard card = getDebitCard();
        DebitCard transfereeCard = transferee.getDebitCard();

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше 0!");
        }

        if (card.getBalance() < amount) {
            throw new IllegalArgumentException("Не хватает средств!");
        }

        transfereeCard.setBalance(amount + transfereeCard.getBalance());
        card.setBalance(card.getBalance() - amount);

        transferee.setHistory(getFormatHistory(0, amount, this.getFullName()));
        setHistory(getFormatHistory(1, amount, transferee.getFullName()));
    }

    // код для информации
    @Override
    public String getFormatHistory(int method, double amount, String actingPerson){
        DebitCard card = getDebitCard();
        if (actingPerson != null){
            method += 2;
        }

        switch (method){
            case 0 -> { return "У вас +" + amount + card.getCurrency(); }
            case 1 -> { return "У вас -" + amount + card.getCurrency(); }
            case 2 -> { return "У вас +" + amount + card.getCurrency() + ", Отправитель: " + actingPerson; }
            case 3 -> { return "У вас -" + amount + card.getCurrency() + ", Получатель: " + actingPerson; }
            default -> { return "Ошибка, неверный метод"; }
        }
    }

    public String getMainAccountDetails(){
        DebitCard card = getDebitCard();

        return  "Данные пользователя:" + "\n" +
                "ID: " + this.getAccountId() + "\n" +
                "Баланс: " + card.getBalance() + card.getCurrency() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + this.getNumberCard() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n";
    }

    public String getExtendedAccountDetails(){
        DebitCard card = getDebitCard();

        return  "Данные расширенные пользователя:" + "\n" +
                "ID: " + this.getAccountId() + "\n" +
                "Баланс: " + card.getBalance() + card.getCurrency() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + this.getNumberCard() + "\n" +
                "Срок действия: " + card.getExpirationDate() + "\n" +
                "CVV: " + card.getCVV() + "\n" +
                "Номер телефона: " + this.getPhoneNumber() + "\n" +
                "Тип аккаунта: " + getTypeAccount() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n" +
                "Время создания аккаунта: " + getTimeOpenAccount() + "\n";
    }

    // остальные методы
    private String generateNumberCard() {
        String result = "2806";

        while(result.length() < 16) {
            int randomNum = ThreadLocalRandom.current().nextInt(10);
            result += randomNum;
        }

        return result;
    }
}

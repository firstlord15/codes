import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BusinessAccount extends Account implements Serializable {
    private static final String nameTypeAccount = "Bank Account";
    private static final LocalDateTime timeOpenAccount = LocalDateTime.now();
    private final BusinessCard businessCard;

    BusinessAccount(String login, String password, String name, String surname, String accountID, double balance, String currency, String phoneNumber, ArrayList<BusinessAccount> accountArrayList, String cardHolderName, String companyName) throws Exception {
        super(login, password, name, surname, accountID, phoneNumber);
        this.businessCard = new BusinessCard(cardHolderName, addNumberCard(accountArrayList), String.format("%02d/%02d", timeOpenAccount.getMonthValue(),
                                             timeOpenAccount.getDayOfMonth()), balance, currency, companyName);
    }

    public String getNameTypeAccount() {
        return nameTypeAccount;
    }

    @Override
    public void withdraw(double amount) {
        BusinessCard card = getBusinessCard();

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
    public void deposit(double amount) {
        BusinessCard card = getBusinessCard();

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть больше 0!");
        }

        card.setBalance(card.getBalance() + amount);
        setHistory(getFormatHistory(0, amount, null));
    }


    public void transfer(double amount, BusinessAccount transferee) {
        if (!(transferee instanceof BusinessAccount)) {
            throw new IllegalArgumentException("Перевод с бизнес аккаунта возможен только на другой бизнес аккаунт.");
        }


        BusinessCard card = getBusinessCard();
        BusinessCard transfereeCard = transferee.getBusinessCard();

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма перевода должна быть больше 0!");
        }

        if (card.getBalance() < amount) {
            throw new IllegalArgumentException("Не хватает средств!");
        }


        if (this != transferee){
            transfereeCard.setBalance(amount + transfereeCard.getBalance());
            card.setBalance(card.getBalance() - amount);

            transferee.setHistory(getFormatHistory(0, amount, this.getFullName()));
            setHistory(getFormatHistory(1, amount, transferee.getFullName()));
        }
        else {
            transfereeCard.setBalance(amount + transfereeCard.getBalance());
            card.setBalance(card.getBalance() - amount);

            transferee.setHistory(getFormatHistory(0, amount, "Кому ты там переводишь?"));
            setHistory(getFormatHistory(1, amount, "Кому ты там переводишь?"));
        }
    }

    public BusinessCard getBusinessCard() {
        return businessCard;
    }

    // getter and setter
    public LocalDateTime getTimeOpenAccount(){ return timeOpenAccount; }


    // Методы для вывода информации
    public String getMainAccountDetails(){
        BusinessCard card = getBusinessCard();

        return  "Данные пользователя:" + "\n" +
                "ID: " + this.getAccountId() + "\n" +
                "Баланс: " + card.getBalance() + card.getCurrency() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + card.getCardNumber() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n";
    }

    public String getExtendedAccountDetails(){
        BusinessCard card = getBusinessCard();

        return  "Данные расширенные пользователя:" + "\n" +
                "ID: " + this.getAccountId() + "\n" +
                "Баланс: " + card.getBalance() + card.getCurrency() + "\n" +
                "Пользователь: " + this.getFullName() + "\n" +
                "Номер карты: " + card.getCardNumber() + "\n" +
                "Срок действия: " + card.getExpirationDate() + "\n" +
                "CVV: " + card.getCvv() + "\n" +
                "Номер телефона: " + this.getPhoneNumber() + "\n" +
                "Тип аккаунта: " + getNameTypeAccount() + "\n" +
                "Последняя операция: " + getHistoryLast() + "\n" +
                "Время создания аккаунта: " + getTimeOpenAccount() + "\n";
    }


    // Прочие
    private String addNumberCard(ArrayList<BusinessAccount> listAccounts){
        String number;
        int maxAttempts = 100;  // Максимальное количество попыток

        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            number = generateNumberCard();
            boolean isUnique = true;

            for (BusinessAccount account : listAccounts) {
                if (account.getBusinessCard().getCardNumber().equals(number)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                return number;
            }
        }

        throw new IllegalStateException("Не удалось найти уникальный номер для карты");
    }

    private String generateNumberCard() {
        String result = "2806";

        while(result.length() < 16) {
            int randomNum = ThreadLocalRandom.current().nextInt(10);
            result += randomNum;
        }

        return result;
    }

    @Override
    public String getFormatHistory(int method, double amount, String actingPerson){
        BusinessCard card = getBusinessCard();

        if (actingPerson != null) method += 2;

        switch (method){
            case 0 -> { return "У вас +" + amount + card.getCurrency(); }
            case 1 -> { return "У вас -" + amount + card.getCurrency(); }
            case 2 -> { return "У вас +" + amount + card.getCurrency() + ", Отправитель: " + actingPerson; }
            case 3 -> { return "У вас -" + amount + card.getCurrency() + ", Получатель: " + actingPerson; }
            default -> { return "Ошибка, неверный метод"; }
        }
    }
}

import java.time.LocalDateTime;

public class BusinessAccount extends Account{
    private static final String nameTypeAccount = "Bank Account";
    private static final LocalDateTime timeOpenAccount = LocalDateTime.now();
    private final BusinessCard businessCard;
    BusinessAccount(String name, String surname, String accountID, double balance, String currency, String phoneNumber, BusinessCard businessCard) {
        super(name, surname, accountID, phoneNumber);
        this.businessCard = businessCard;
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

    public BusinessCard getBusinessCard() {
        return businessCard;
    }

    // getter and setter
}

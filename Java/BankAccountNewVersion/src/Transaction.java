import java.time.LocalDate;

public class Transaction {
    private final LocalDate date;
    private double amount;
    private TransactionType transitionType;
    private Currency currency;

    Transaction(double amount, TransactionType transitionType, Currency currency){
        this.amount = amount;
        this.transitionType = transitionType;
        this.currency = currency;
        this.date = LocalDate.now();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount < 0){
            try {
                throw new Exception("Значение должно быть положительным числом");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        this.amount = amount;
    }

    public TransactionType getType() {
        return transitionType;
    }

    public void setType(TransactionType transitionType) {
        this.transitionType = transitionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getDetails(){
        return "Amount: " + amount + "\n" +
                "Currency: " + currency + "\n" +
                "Date: " + date.toString() + "\n" +
                "Transition type: " + transitionType;
    }
}

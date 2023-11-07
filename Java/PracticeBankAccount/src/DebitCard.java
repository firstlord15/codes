public class DebitCard extends BankCards {
    private double cashWithdrawalLimit;
    private boolean transferEnabled;

    public DebitCard(String cardHolderName, String cardNumber, String expirationDate, double balance, String currency) throws Exception {
        super(cardHolderName, cardNumber, expirationDate, balance, currency);
        this.cashWithdrawalLimit = 100000;  // Установка начального значения лимита на снятие наличных
        this.transferEnabled = true;  // Начальное значение возможности перевода средств
    }


    // getter and setter
    public double getCashWithdrawalLimit() {
        return cashWithdrawalLimit;
    }

    public void setCashWithdrawalLimit(double limit) {
        this.cashWithdrawalLimit = limit;
    }

    public boolean isTransferEnabled() {
        return transferEnabled;
    }

    public void enableTransfer() {
        transferEnabled = true;
    }

    public void disableTransfer() {
        transferEnabled = false;
    }
}
import java.awt.datatransfer.Transferable;

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
        if (limit > 0){
            this.cashWithdrawalLimit = limit;
        } else {
            this.cashWithdrawalLimit = 0;
        }
    }

    public boolean getTransferEnabled(){
        return transferEnabled;
    }

    public void setTransferEnabled(boolean transferEnabled) {
        this.transferEnabled = transferEnabled;
    }
}
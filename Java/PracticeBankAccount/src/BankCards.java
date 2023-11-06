public interface BankCards {
    String getCardNumber();
    String getExpirationDate();
    String getCVV();

    double getBalance();
    void setBalance(double balance);
}


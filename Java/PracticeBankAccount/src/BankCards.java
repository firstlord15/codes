public interface BankCards { // абстаркт
    String getCardNumber();
    String getExpirationDate();
    String getCVV();

    double getBalance();
    void setBalance(double balance);
}


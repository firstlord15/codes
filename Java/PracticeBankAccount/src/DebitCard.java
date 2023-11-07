public class DebitCard implements BankCards {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private double balance;
    private String currency;


    public DebitCard(String cardNumber, String expirationDate, double balance, String currency) throws Exception {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        setCvv(generateCVV());
        this.balance = balance;
        this.currency = currency;
    }

    // getter and setter
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) throws Exception {
        if (cardNumber.length() != 16){
            throw new Exception("Не больше 16 значений должно быть у номера карты!");
        }

        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVV() {
        return cvv;
    }

    public void setCvv(String cvv) throws Exception {
        if (cvv.length() != 3){
            throw new Exception("сvv не больше 3 значений");
        }

        this.cvv = cvv;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    // Остальные методы

    private String generateCVV(){
        String cardNumber = getCardNumber();
        String expirationDate = getExpirationDate();

        char cvv1 = cardNumber.charAt(cardNumber.length() - 1);
        char cvv2 = expirationDate.charAt(0);
        char cvv3 = cardNumber.charAt(cardNumber.length() - 2);

        return String.valueOf(cvv1 + cvv2 + cvv3);
    }
}
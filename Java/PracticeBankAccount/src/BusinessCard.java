public class BusinessCard implements BankCards {
    private String companyName;
    private final String cardNumber;
    private String currency;
    private double balance;
    private String expirationDate;
    private String cvv;

    BusinessCard(String cardNumber, String companyName, String expirationDate, String cvv, double balance, String currency){
        this.cardNumber = cardNumber;
        this.companyName = companyName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.balance = balance;
        this.currency = currency;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExpirationDate() {
        return expirationDate;
    }


    public double getBalance() {
        return balance;
    }

    public String getCVV() {
        return cvv;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }


    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

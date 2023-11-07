public class BusinessCard extends BankCards {
    private String companyName;
    private String cardNumber;
    private String currency;
    private double balance;
    private String expirationDate;
    private String cvv;

    public BusinessCard(String cardHolderName, String cardNumber, String expirationDate, double balance, String currency, String companyName) throws Exception {
        super(cardHolderName, cardNumber, expirationDate, balance, currency);
        this.companyName = companyName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

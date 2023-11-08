import java.io.Serializable;

public class BusinessCard extends BankCards implements Serializable {
    private String companyName;

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

    public String getMainCardDetails() {
        String cardDetails = super.getMainCardDetails();
        return cardDetails + "\nCompany Name: " + companyName;
    }
}

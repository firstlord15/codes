import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {
    private List<Account> accounts;
    private String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


}

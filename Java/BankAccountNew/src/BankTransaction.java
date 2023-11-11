public class BankTransaction {
    private Account account;
    private Transaction transaction;

    BankTransaction(Account account, Transaction transaction){
        this.account = account;
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "account=" + account +
                ", transaction=" + transaction +
                '}';
    }

}

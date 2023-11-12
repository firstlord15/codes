import java.util.Date;
import java.util.List;
import java.util.Random;

public class Account {
    private String accountNumber;
    private String bankNumber;
    private String login;
    private String password;
    private Person person;
    private double balance;
    private TransactionHistory transactionHistory;

    Account(String accountNumber, Person person, String login, String password){
        this.login = login;
        this.password = password;
        this.accountNumber = accountNumber;
        this.person = person;
        this.balance = 0;
        this.transactionHistory = new TransactionHistory();
        this.bankNumber = generateBankNumber();
    }

    public String generateBankNumber() {
        Random rand = new Random();
        String bankNumberBuilder = "";

        for (int i = 0; i < 16; i++) {
            int num = rand.nextInt(16);
            bankNumberBuilder += num;
        }

        return bankNumberBuilder;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void addTransaction(BankTransaction bankTransaction) {
        transactionHistory.addTransaction(bankTransaction);
    }

    public BankTransaction getLastTransaction() {
        return transactionHistory.getLastTransaction();
    }

    public double getBalanceOnDate(Date date) {
        return transactionHistory.getBalanceOnDate(date);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    private void applyTransaction(Transaction transaction) {
        if (transaction.getType() == TransactionType.DEPOSIT) {
            deposit(transaction.getAmount());
        } else if (transaction.getType() == TransactionType.WITHDRAWAL) {
            withdraw(transaction.getAmount());
        }
        transactionHistory.addTransaction(new BankTransaction(this, transaction));
    }

    public void transferTo(Account recipientAccount, double amount) {
        if (amount > 0 && balance >= amount) {
            createTransaction(-amount, TransactionType.WITHDRAWAL);
            recipientAccount.createTransaction(amount, TransactionType.DEPOSIT);
        } else {
            System.out.println("Недостаточно баланса");
        }
    }

    public double getProjectedBalance() {
        double projectedBalance = balance;
        for (BankTransaction bankTransaction : transactionHistory.getTransactionList()) {
            if (bankTransaction.getTransaction().getDate().after(new Date())) {
                if (bankTransaction.getTransaction().getType() == TransactionType.DEPOSIT) {
                    projectedBalance += bankTransaction.getTransaction().getAmount();
                } else if (bankTransaction.getTransaction().getType() == TransactionType.WITHDRAWAL) {
                    projectedBalance -= bankTransaction.getTransaction().getAmount();
                }
            }
        }
        return projectedBalance;
    }

    public List<BankTransaction> getTransactionHistoryForPeriod(Date startDate, Date endDate) {
        return transactionHistory.getTransactionsForPeriod(startDate, endDate);
    }

    public void createTransaction(double amount, TransactionType type) {
        Transaction transaction = new Transaction(new Date(), amount, type);
        applyTransaction(transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", person=" + person +
                ", balance=" + balance +
                ", transactionHistory=" + transactionHistory +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

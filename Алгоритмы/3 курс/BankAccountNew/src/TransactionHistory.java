import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class TransactionHistory {
    private final List<BankTransaction> transactionList;

    public TransactionHistory() {
        this.transactionList = new ArrayList<>();
    }

    public void addTransaction(BankTransaction bankTransaction) {
        transactionList.add(bankTransaction);
    }

    public BankTransaction getTransactionByIndex(int index) {
        if (index >= 0 && index < transactionList.size()) {
            return transactionList.get(index);
        } else {
            return null;
        }
    }

    public BankTransaction getLastTransaction() {
        if (!transactionList.isEmpty()) {
            return transactionList.getLast();
        } else {
            return null;
        }
    }

    public BankTransaction getFirstTransaction() {
        if (!transactionList.isEmpty()) {
            return transactionList.getFirst();
        } else {
            return null;
        }
    }

    public double getBalanceOnDate(Date date) {
        double balance = 0.0;

        for (BankTransaction bankTransaction : transactionList) {
            Date transactionDate = bankTransaction.getTransaction().getDate();

            if (transactionDate.before(date) || transactionDate.equals(date)) {
                if (bankTransaction.getTransaction().getType() == TransactionType.DEPOSIT) {
                    balance += bankTransaction.getTransaction().getAmount();
                } else if (bankTransaction.getTransaction().getType() == TransactionType.WITHDRAWAL) {
                    balance -= bankTransaction.getTransaction().getAmount();
                }
            }
        }

        return balance;
    }

    public List<BankTransaction> getTransactionList() {
        return new ArrayList<>(transactionList);
    }

    public List<BankTransaction> getTransactionsForPeriod(Date startDate, Date endDate) {
        List<BankTransaction> resultTransactions = new ArrayList<>();

        for (BankTransaction bankTransaction : transactionList) {
            Date transactionDate = bankTransaction.getTransaction().getDate();

            if ((transactionDate.after(startDate) || transactionDate.equals(startDate))
                    && (transactionDate.before(endDate) || transactionDate.equals(endDate))) {
                resultTransactions.add(bankTransaction);
            }
        }

        return resultTransactions;
    }

    public List<BankTransaction> getAllTransactions() {
        return new ArrayList<>(transactionList);
    }

    public double getTotalBalanceForPeriod(Date startDate, Date endDate) {
        double totalBalance = 0;

        for (BankTransaction bankTransaction : transactionList) {
            Date transactionDate = bankTransaction.getTransaction().getDate();

            if ((transactionDate.after(startDate) || transactionDate.equals(startDate))
                    && (transactionDate.before(endDate) || transactionDate.equals(endDate))) {
                if (bankTransaction.getTransaction().getType() == TransactionType.DEPOSIT) {
                    totalBalance += bankTransaction.getTransaction().getAmount();
                } else if (bankTransaction.getTransaction().getType() == TransactionType.WITHDRAWAL) {
                    totalBalance -= bankTransaction.getTransaction().getAmount();
                }
            }
        }

        return totalBalance;
    }
}
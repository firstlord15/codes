import java.util.ArrayList;

public class TransactionHistory {
    private ArrayList<Transaction> transactionHistory;

    TransactionHistory(){
        transactionHistory = new ArrayList<>();
    }

    public void addTransaction(Transaction transition){
        transactionHistory.add(transition);
    }

    public void setTransactionHistory(ArrayList<Transaction> transitionHistory) {
        this.transactionHistory = transitionHistory;
    }

    public ArrayList<Transaction> getTransitionHistory() {
        return transactionHistory;
    }

    public Transaction getLastTransaction(){
        return transactionHistory.getLast();
    }

    public Transaction getFirstTransaction(){
        return transactionHistory.getFirst();
    }
}

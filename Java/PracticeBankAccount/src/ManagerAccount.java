import java.util.ArrayList;

public class ManagerAccount extends Account{
    private final ArrayList<BankAccount> managedAccounts;
    private static int countManagedAccounts = 0;

    ManagerAccount(String login, String password, String name, String surname, String accountID, String phoneNumber) {
        super(login, password, name, surname, accountID, phoneNumber);
        managedAccounts = new ArrayList<>();
    }


    // getter and setter
    public String getManagedAccountDetails(BankAccount account){
        return account.getAccountDetails(false);
    }

    public int getNumberOfManagedAccounts() {
        return countManagedAccounts;
    }

    public double getBalanceForManagedAccount(BankAccount account) throws Exception {
        if (!isManagedAccount(account)){
            throw new Exception("Пользователь "+ account.getName() +" не обслуживается этим менеджером");
        }

        return account.getDebitCard().getBalance();
    }

    public String getHistoryAllForManagedAccount(BankAccount account) throws Exception {
        if (!isManagedAccount(account)){
            throw new Exception("Пользователь "+ account.getName() +" не обслуживается этим менеджером");
        }

        return startReturn(account) + account.getHistoryAll();
    }

    public String getHistoryLastForManagedAccount(BankAccount account) throws Exception {
        if (!isManagedAccount(account)){
            throw new Exception("Пользователь "+ account.getName() +" не обслуживается этим менеджером");
        }

        return startReturn(account) + account.getHistoryLast();
    }

    public String getNameOfManagedAccounts() {
        String listOfNames = "Список управляемых аккаунтов:\n";

        for (BankAccount account: managedAccounts) {
            listOfNames += "["+ account.getAccountId() + "] " + account.getFullName() + "\n";
        }

        return listOfNames;
    }

    public BankAccount getManagedAccountById(String accountId){
        for(BankAccount account: managedAccounts){
            if (account.getAccountId().equals(accountId)){
                return account;
            }
        }

        return null;
    }

    public ArrayList<BankAccount> getManagedAccounts() {
        return managedAccounts;
    }

    public double getTotalBalance() {
        double total = 0;

        for (BankAccount account: managedAccounts){
            total += account.getDebitCard().getBalance();
        }

        return total;
    }

    // методы для работы со списком аккаунтов менеджера
    public void addManagedAccount(BankAccount account) throws Exception {
        if (isManagedAccount(account)) {
            managedAccounts.add(account);
            changeCountManagedAccounts(0);
        } else {
            throw new Exception("Пользователь "+ account.getName() +" не обслуживается этим менеджером");
        }
    }

    public void addManagedAccount(ArrayList<BankAccount> accounts) throws Exception {
        for (BankAccount account: accounts){
            if (isManagedAccount(account)) {
                managedAccounts.add(account);
                changeCountManagedAccounts(0);
            }
        }
    }

    public void removeManagedAccount(BankAccount account) throws Exception {
        if (isManagedAccount(account)){
            throw new Exception("Пользователь "+ account.getName() +" не обслуживается этим менеджером");
        }

        managedAccounts.remove(account);
        changeCountManagedAccounts(1);
    }


    // Остальные методы
    private String startReturn(BankAccount account){
        return this.getName() + " [" + account.getFullName() + "]" + ": ";
    }

    public boolean isManagedAccount(BankAccount account){
        return managedAccounts.contains(account);
    }

    private void changeCountManagedAccounts(int A) throws Exception {
        if (A == 0){
            countManagedAccounts++;
            return;
        }

        if (countManagedAccounts != 0){ throw new Exception("У вас и так нет управляемых аккаунтов!"); }
        countManagedAccounts--;
    }

    public void transfer(double amount, BankAccount transferee) {

    }

    @Override
    public void deposit(double amount) {
        return;
    }

    @Override
    public void withdraw(double amount) {
        return;
    }
    
    public void transfer(double amount, BankAccount sourceAccount, BankAccount targetAccount) {
        if (!isManagedAccount(sourceAccount) || !isManagedAccount(targetAccount)) {
            throw new IllegalArgumentException("Один из аккаунтов не управляется данным менеджером.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма для перевода должна быть положительной.");
        }

        // Выполните перевод средств между аккаунтами.
        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);
    }

    @Override
    public String getFormatHistory(int method, double amount, String actingPerson){
        return null;
    }
}

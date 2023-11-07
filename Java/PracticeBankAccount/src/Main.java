import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        ArrayList<BusinessAccount> businessAccounts = new ArrayList<>();

        BankAccount my = new BankAccount("firstlord15", "123141", "Ратмир", "Ашимов", String.valueOf(1), "79096895085", 0, "$", bankAccounts, "Shone");
        bankAccounts.add(my);

        BankAccount myF = new BankAccount("firstlord4", "123141", "Салим", "Алиев", String.valueOf(bankAccounts.size() + 1), "79096895085", 0, "$", bankAccounts, "Sahalim");
        bankAccounts.add(myF);

        BankAccount myF2 = new BankAccount("firstlord3", "123141", "Огабек", "Амиров", String.valueOf(bankAccounts.size() + 1), "79096895085", 0, "$", bankAccounts, "Cap_ogi");
        bankAccounts.add(myF2);

        ManagerAccount manager = new ManagerAccount("firstlord2", "123141","Иван", "Иванков", String.valueOf(bankAccounts.size() + 1), "79096895085");
        manager.addManagedAccount(bankAccounts);


        my.deposit(1000);
        myF.deposit(300);
        myF2.deposit(100);
        my.transfer(30, myF);
        my.transfer(45, myF2);

        System.out.println(my.getAccountDetails(false));
        System.out.println(myF.getAccountDetails(false));
        System.out.println(myF2.getAccountDetails(true));
        System.out.println(manager.getTotalBalance());

        BusinessAccount test = new BusinessAccount("firstlord", "123141", "Ратмир", "Ашимов", "1", 0, "$", "79096895085", businessAccounts, "Shone", "Kahoot!");
        BusinessAccount test2 = new BusinessAccount("firstlord1", "123141", "Салим", "Алиев", "2", 0, "$", "79096895085", businessAccounts, "Sahalim", "Kahoot!");


        test.deposit(100);
        test.transfer(50, test2);
        System.out.println(test.getMainAccountDetails());;
    }
}
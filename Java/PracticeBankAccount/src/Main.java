import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BankAccount> accountArrayList = new ArrayList<>();

        BankAccount my = new BankAccount("Ратмир", "Ашимов", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList, "Shone");
        accountArrayList.add(my);

        BankAccount myF = new BankAccount("Салим", "Алиев", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList, "Sahalim");
        accountArrayList.add(myF);

        BankAccount myF2 = new BankAccount("Огабек", "Амиров", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList, "Cap_ogi");
        accountArrayList.add(myF2);

        ManagerAccount manager = new ManagerAccount("Иван", "Иванков", String.valueOf(accountArrayList.size() + 1), 0, "$", "79096895085");
        manager.addManagedAccount(accountArrayList);


        my.deposit(1000);
        myF.deposit(300);
        myF2.deposit(100);
        my.transfer(30, myF);
        my.transfer(45, myF2);

        System.out.println(my.getMainAccountDetails());
        System.out.println(myF.getMainAccountDetails());
        System.out.println(myF2.getExtendedAccountDetails());
        System.out.println(manager.getTotalBalance());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
        // переменые с мал
    }
}
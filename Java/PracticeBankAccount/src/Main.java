import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BankAccount> accountArrayList = new ArrayList<>();

        BankAccount My = new BankAccount("Ратмир", "Ашимов", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList);
        accountArrayList.add(My);

        BankAccount MyF = new BankAccount("Салим", "Алиев", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList);
        accountArrayList.add(MyF);

        BankAccount MyF2 = new BankAccount("Огабек", "Амиров", String.valueOf(accountArrayList.size() + 1), "79096895085", 0, "$", accountArrayList);
        accountArrayList.add(MyF2);

        ManagerAccount Manager = new ManagerAccount("Иван", "Иванков", String.valueOf(accountArrayList.size() + 1), 0, "$", "79096895085");
        Manager.addManagedAccount(accountArrayList);


        My.deposit(1000);
        MyF.deposit(300);
        MyF2.deposit(100);
        My.transfer(30, MyF);
        My.transfer(45, MyF2);

        System.out.println(My.getMainAccountDetails());
        System.out.println(MyF.getMainAccountDetails());
        System.out.println(MyF2.getExtendedAccountDetails());
        System.out.println(Manager.getTotalBalance());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
        // переменые с мал
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<BankAccount> accountArrayList = new ArrayList<>();

        BankAccount My = new BankAccount("Ратмир", "Ашимов", "1", 0, "$", "79096895085", accountArrayList);
        accountArrayList.add(My);

        BankAccount MyF = new BankAccount("Салим", "Алиев", "2", 0, "$", "79096895085", accountArrayList);
        accountArrayList.add(MyF);

        BankAccount MyF2 = new BankAccount("Огабек", "Амиров", "3", 0, "$", "79096895085", accountArrayList);
        accountArrayList.add(MyF2);

        ManagerAccount Manager = new ManagerAccount("Иван", "Иванков", "1", 0, "$", "79096895085");
        Manager.addManagedAccount(accountArrayList);


        My.deposit(100);
        MyF.deposit(300);
        MyF2.deposit(1000);
        My.transfer(30, MyF);
        My.transfer(45, MyF2);

        System.out.println(My.getMainAccountDetails());
        System.out.println(MyF.getMainAccountDetails());
        System.out.println(MyF2.getExtendedAccountDetails());
        System.out.println(Manager.getTotalBalance());

        DebitCard d = new DebitCard("5536910028035121", "12/12", "088");
        System.out.println(d.getBalance());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
    }
}
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accountArrayList = new ArrayList<>();

        BankAccount My = new BankAccount("Ратмир", "Ашимов", "1", 0, "$", "79096895085", accountArrayList);
        BankAccount MyF = new BankAccount("Салим", "Алиев", "2", 0, "$", "79096895085", accountArrayList);
        BankAccount MyF2 = new BankAccount("Огабек", "Амиров", "3", 0, "$", "79096895085", accountArrayList);



        My.deposit(100);
        My.transfer(30, MyF);
        My.transfer(30, MyF2);

        System.out.println(My.getMainAccountDetails());
        System.out.println(MyF.getMainAccountDetails());
        System.out.println(MyF2.getMainAccountDetails());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
    }
}
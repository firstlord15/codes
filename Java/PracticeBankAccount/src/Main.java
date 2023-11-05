import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accountArrayList = new ArrayList<>();

        BankAccount My = new BankAccount("Ратмир", "Ашимов", "1", accountArrayList, 0, "$");
        BankAccount MyF = new BankAccount("Салим", "Алиев", "2", accountArrayList, 0, "$");
        BankAccount MyF2 = new BankAccount("Огабек", "Амиров", "3", accountArrayList, 0, "$");



        My.deposit(100);
        My.transfer(30, MyF);

        System.out.println(My.getInfoAccount());
        System.out.println(MyF.getInfoAccount());
        System.out.println(MyF2.getInfoAccount());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
    }
}
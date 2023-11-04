public class Main {
    public static void main(String[] args) {
        BankAccount My = new BankAccount("1", 0, "$", "Ратмир", "Ашимов", "231231");
        BankAccount MyF = new BankAccount("2", 0, "$", "Алиев", "Салим", "145211");


        My.deposit(100);
        My.transfer(30, MyF);

        System.out.println(My.getInfoAccount());
        System.out.println(MyF.getInfoAccount());

        // Надо решить проблему с генирацией NumberCard и AccountID
        // Подготовить ManagerAccount
        // Доработать логику кода
    }
}
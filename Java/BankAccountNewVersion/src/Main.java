public class Main {
    public static void main(String[] args) {
        Account account = new Account(new Person("", "", "79096895085"));
        System.out.println(account.getAccountId());
    }
}
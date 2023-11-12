import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {
    private static final Login login = new Login();
    private static final Registration registration = new Registration();
    private static final Scanner scanner = new Scanner(System.in);
    private static Account authenticatedAccount;
    private static int authenticatedAccountIndex = 0;

    public static int getAuthenticatedAccountIndex() {
        return authenticatedAccountIndex;
    }

    public void start() {
        System.out.println("Welcome to the Banking App!");

        while (true) {
            System.out.println("\n1. Login\n2. Registration\n3. Exit");
            System.out.print("Choose an option: ");
            String string = scanner.nextLine();
            scanner.nextLine();

            if (string.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application. Goodbye!");
                System.exit(0);
            }

            int choice = Integer.parseInt(string);
            switch (choice) {
                case 1 -> login();
                case 2 -> registration();
                case 3 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        authenticatedAccount = login.authenticate(username, password);
        authenticatedAccountIndex = login.findIndexAccount(authenticatedAccount.getLogin());

        if (authenticatedAccount != null) {
            System.out.println("Login successful. Welcome, " + username + "!");
            manageAccount();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    public void registration() {
        registration.loadAccountsFromFile();

        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Account newAccount = new Account(new Person(firstName, lastName, phoneNumber), login, password);
        registration.getAccounts().add(newAccount);
        registration.saveAccountsToFile();

        System.out.println("Account created successfully:\n" + newAccount);
    }

    public void manageAccount() {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Get details account\n5. Logout");
            System.out.print("Введите свой выбор: ");
            String string = scanner.nextLine();
            scanner.nextLine();

            if (string.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application. Goodbye!");
                System.exit(0);
            }

            int choice = Integer.parseInt(string.trim());
            switch (choice) {
                case 1 -> deposit();
                case 2 -> withdraw();
                case 3 -> transfer();
                case 4 -> System.out.println(authenticatedAccount.getDetailsAccount());
                case 5 -> {
                    authenticatedAccount = null;
                    System.out.println("Logout successful. Returning to the main menu.");
                    return;
                }
                default -> System.out.println("Invalid option. Please choose a valid option.");
            }

            scanner.nextLine();
        }
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        authenticatedAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + authenticatedAccount.getBalance());

        Date currentDate = Calendar.getInstance().getTime();
        authenticatedAccount.addTransaction(new BankTransaction(authenticatedAccount, new Transaction(currentDate, amount, TransactionType.DEPOSIT)));

        registration.setAccountByIndex(authenticatedAccountIndex, authenticatedAccount);
        registration.saveAccountsToFile(); // Обновляем файл после операции
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (authenticatedAccount.getBalance() >= amount) {
            authenticatedAccount.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + authenticatedAccount.getBalance());


            Date currentDate = Calendar.getInstance().getTime();
            authenticatedAccount.addTransaction(new BankTransaction(authenticatedAccount, new Transaction(currentDate, amount, TransactionType.DEPOSIT)));
            registration.setAccountByIndex(authenticatedAccountIndex, authenticatedAccount);
            registration.saveAccountsToFile(); // Обновляем файл после операции
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void transfer() {
        System.out.print("Enter the recipient's login: ");
        String login = scanner.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        Account recipientAccount = findAccountByUsername(login);

        if (recipientAccount != null) {
            authenticatedAccount.transferTo(recipientAccount, amount);
            System.out.println("Transfer successful. New balance: " + authenticatedAccount.getBalance());


            Date currentDate = Calendar.getInstance().getTime();
            authenticatedAccount.addTransaction(new BankTransaction(authenticatedAccount, new Transaction(currentDate, amount, TransactionType.WITHDRAWAL)));
            recipientAccount.addTransaction(new BankTransaction(recipientAccount, new Transaction(currentDate, amount, TransactionType.DEPOSIT)));

            registration.setAccountByIndex(authenticatedAccountIndex, authenticatedAccount);
            registration.saveAccountsToFile(); // Обновляем файл после операции
        } else {
            System.out.println("Recipient account not found. Transfer failed.");
        }
    }

    private Account findAccountByUsername(String login) {
        for (Account account : registration.getAccounts()) {
            if (account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }
}

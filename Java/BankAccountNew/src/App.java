import java.util.Scanner;

public class App {
    private static final Login login = new Login();
    private static final Registration registration = new Registration();
    private static final Scanner scanner = new Scanner(System.in);
    private static Account authenticatedAccount;

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
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Account newAccount = new Account(accountNumber, new Person(firstName, lastName, phoneNumber), login, password);
        registration.getAccounts().add(newAccount);
        registration.saveAccountsToFile();

        System.out.println("Account created successfully:\n" + newAccount);
    }

    public void manageAccount() {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Transfer\n4. Logout");
            System.out.print("Choose an option: ");
            String string = scanner.nextLine();
            scanner.nextLine();

            if (string.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting the application. Goodbye!");
                System.exit(0);
            }

            int choice = Integer.parseInt(string);
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    authenticatedAccount = null;
                    System.out.println("Logout successful. Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        authenticatedAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + authenticatedAccount.getBalance());
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (authenticatedAccount.getBalance() >= amount) {
            authenticatedAccount.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + authenticatedAccount.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void transfer() {
        System.out.print("Enter the recipient's account number: ");
        String recipientAccountNumber = scanner.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        Account recipientAccount = findAccountByNumber(recipientAccountNumber);

        if (recipientAccount != null) {
            authenticatedAccount.transferTo(recipientAccount, amount);
            System.out.println("Transfer successful. New balance: " + authenticatedAccount.getBalance());
        } else {
            System.out.println("Recipient account not found. Transfer failed.");
        }
    }

    private Account findAccountByNumber(String accountNumber) {
        for (Account account : registration.getAccounts()) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

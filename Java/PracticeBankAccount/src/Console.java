import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private static final LogReg logReg = new LogReg();
    private static final Scanner scanner = new Scanner(System.in);
    private Account currentAccount;

    public boolean login_run(String login, String accountId, String fullName) {
        return logReg.login(fullName, accountId, login);
    }

    public boolean login_vis() {
        while (true) {
            System.out.println("Введите login: ");
            String login = scanner.nextLine();

            System.out.println("Введите AccountId: ");
            String accountId = scanner.nextLine();

            System.out.println("Введите полное имя: ");
            String fullName = scanner.nextLine();

            if (login_run(fullName, accountId, login)) {
                currentAccount = logReg.findAccount(fullName, accountId, login);
                return true;
            } else {
                System.out.println("Пользователь не найден");
            }
        }
    }

    public void registration_run(Account account, boolean isBusiness) throws IOException {
        if (isBusiness) {
            logReg.registerBusinessAccount((BusinessAccount) account);
        } else {
            logReg.registerBankAccount((BankAccount) account);
        }

        currentAccount = account;
    }

    public void registrationBankAccount_vis() throws Exception {
        System.out.println("Введите login: ");
        String login = scanner.nextLine();

        System.out.println("Введите password: ");
        String password = scanner.nextLine();

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();

        String accountId = String.valueOf(logReg.getBankAccounts().size() + 1);

        System.out.println("Введите номер телефона(7XXXXXXXXXX): ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Введите имя, который будет на карте: ");
        String cardHolderName = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(login, password, name, surname, accountId, phoneNumber, 0, "$", logReg.getBankAccounts(), cardHolderName);

        boolean isAccount = logReg.isAccountExists(bankAccount.getFullName(), bankAccount.getAccountId(), bankAccount.getLogin());

        if (isAccount) {
            System.out.println("Такой пользователь уже есть");
        } else {
            registration_run(bankAccount, false);
        }
    }

    public void registrationBusinessAccount_vis() throws Exception {
        System.out.println("Введите название компании: ");
        String companyName = scanner.nextLine();

        System.out.println("Введите login: ");
        String login = scanner.nextLine();

        System.out.println("Введите password: ");
        String password = scanner.nextLine();

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();

        String accountId = String.valueOf(logReg.getBusinessAccounts().size() + 1);

        System.out.println("Введите номер телефона(7XXXXXXXXXX): ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Введите имя, который будет на карте: ");
        String cardHolderName = scanner.nextLine();

        BusinessAccount businessAccount = new BusinessAccount(login, password, name, surname, accountId, 0, "$", phoneNumber, logReg.getBusinessAccounts(), cardHolderName, companyName);

        boolean isAccount = logReg.isAccountExists(businessAccount.getFullName(), businessAccount.getAccountId(), businessAccount.getLogin());

        if (isAccount) {
            System.out.println("Такой пользователь уже есть");
        } else {
            registration_run(businessAccount, true);
        }
    }

    public void start() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("[1] Зайти в имеющийся аккаунт");
            System.out.println("[2] Создать аккаунт");
            System.out.println("[3] Выйти");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистить буфер после ввода числа

            switch (choice) {
                case 1:
                    if (login_vis()) {
                        mainFunction();
                    }
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    System.out.println("До свидания!");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    public void mainFunction() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Выберите действие:");
            System.out.println("[1] Просмотреть баланс");
            System.out.println("[2] Внести депозит");
            System.out.println("[3] Снять средства");
            System.out.println("[4] Перевести средства");
            System.out.println("[5] Выйти");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистить буфер после ввода числа

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    makeDeposit();
                    break;
                case 3:
                    makeWithdrawal();
                    break;
                case 4:
                    makeTransfer();
                    break;
                case 5:
                    System.out.println("Выход из аккаунта...");
                    currentAccount = null;
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private boolean isBusiness(){
        return getCurrentAccount() instanceof BusinessAccount;
    }

    private void createAccount() {
        // Добавьте здесь логику для создания аккаунта (банковского или бизнес-аккаунта)
        // Вызовите registrationBankAccount_vis() или registrationBusinessAccount_vis()
    }

    private void viewBalance() {
        if (currentAccount != null) {
            if  (isBusiness()){
                BusinessAccount account = (BusinessAccount) getCurrentAccount();
                System.out.println("Баланс вашего аккаунта: " + account.getBusinessCard().getBalance() + " " + account.getBusinessCard().getCurrency());
            }
            else{
                BankAccount account = (BankAccount) getCurrentAccount();
                System.out.println("Баланс вашего аккаунта: " + account.getDebitCard().getBalance() + " " + account.getDebitCard().getCurrency());
            }
        }
    }

    private void makeDeposit() {
        System.out.println("Укажите размер депозита: ");
        double num = scanner.nextDouble();

        getCurrentAccount().deposit(num);
        System.out.println(getCurrentAccount().getHistoryLast());
    }

    private void makeWithdrawal() {
        System.out.println("Укажите, сколько хотите снять: ");
        double num = scanner.nextDouble();

        getCurrentAccount().withdraw(num);
        System.out.println(getCurrentAccount().getHistoryLast());
    }


    // Дописать
    private void makeTransfer() {
        System.out.println("Укажите, сколько хотите перевести: ");
        double num = scanner.nextDouble();

        if (isBusiness()){
            System.out.println("Укажите, сколько хотите перевести:\n");
            System.out.println(logReg.getNamesBusinessAccounts());
        }
        else{
            System.out.println("Укажите, сколько хотите перевести:\n");
            System.out.println(logReg.getNamesBankAccounts());
        }

    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
}
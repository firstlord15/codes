import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LogReg {
    private static final String ACCOUNTS_DATA_DIR = "AccountsData";
    private List<Account> accounts = new ArrayList<>();

    public void registerBankAccount(BankAccount account) {
        createAccountDirectory(account);
        accounts.add(account);
        saveAccounts();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void registerBusinessAccount(BusinessAccount account) throws IOException {
        createAccountDirectory(account);
        accounts.add((Account) account);
        saveAccounts();
    }

    public Account login(String login, String password) {
        if (isAccountExists(login)){
            Account account = findLoginAccount(login);

            if (Objects.equals(account.getPassword(), password)){
                return account;
            }
        }

        return null;
    }

    private void createAccountDirectory(Account account) {
        String accountDirName = ACCOUNTS_DATA_DIR + File.separator + account.getFullName() + "_" + account.getAccountId() + "_" + account.getLogin();
        File accountDirectory = new File(accountDirName);
        if (!accountDirectory.exists()) {
            if (accountDirectory.mkdirs()) {
                saveAccountData(account);
            } else {
                throw new RuntimeException("Не удалось создать директорию аккаунта или уже существует");
            }
        }
    }

    public void saveAccounts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNTS_DATA_DIR + File.separator + "accounts.ser"))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<BankAccount> getBankAccounts() {
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof BankAccount) {
                bankAccounts.add((BankAccount) account);
            }
        }
        return bankAccounts;
    }

    public String getNamesBankAccounts() {
        String businessAccounts = "";
        for (Account account : accounts) {
            if (account instanceof BankAccount) {
                businessAccounts += account.getFullName() + "(" + account.getLogin() + ")" + "\n";
            }
        }

        return businessAccounts;
    }

    public ArrayList<BusinessAccount> getBusinessAccounts() {
        ArrayList<BusinessAccount> businessAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof BusinessAccount) {
                businessAccounts.add((BusinessAccount) account);
            }
        }
        return businessAccounts;
    }

    public String getNamesBusinessAccounts() {
        String businessAccounts = "";
        for (Account account : accounts) {
            if (account instanceof BusinessAccount) {
                businessAccounts += account.getFullName() + "(" + account.getLogin() + ")" + "\n";
            }
        }

        return businessAccounts;
    }

    public void saveAccountData(Account account) {
        String fileName = ACCOUNTS_DATA_DIR + File.separator + account.getFullName() + "_" + account.getAccountId() + "_" + account.getLogin() + File.separator + "account.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("AccountId: " + account.getAccountId());
            writer.println("Login: " + account.getLogin());
            writer.println("Password: " + account.getPassword());
            writer.println("Full name: " + account.getFullName());
            writer.println("Phone Number: " + account.getPhoneNumber());

            if (account instanceof BankAccount) {
                saveBankAccountData((BankAccount) account, writer);
            } else if (account instanceof BusinessAccount) {
                saveBusinessAccountData((BusinessAccount) account, writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveBankAccountData(BankAccount bankAccount, PrintWriter writer) {
        writer.println("Bank Account Data:");
        writer.println("AccountId: " + bankAccount.getAccountId());
        writer.println("Login: " + bankAccount.getLogin());
        writer.println("Password: " + bankAccount.getPassword());
        writer.println("Full name: " + bankAccount.getFullName());
        writer.println("Phone Number: " + bankAccount.getPhoneNumber());
        writer.println("\nDebit Card Data:");
        writer.println("CardHolderName: " + bankAccount.getDebitCard().getCardHolderName());
        writer.println("Card Number: " + bankAccount.getDebitCard().getCardNumber());
        writer.println("Expiration Date: " + bankAccount.getDebitCard().getExpirationDate());
        writer.println("Balance: " + bankAccount.getDebitCard().getBalance());
        writer.println("Currency: " + bankAccount.getDebitCard().getCurrency());

        if (bankAccount.hasCredit()) {
            writer.println("Credit Data:");
            writer.println("Credit Balance: " + bankAccount.getCreditBalance());
            writer.println("Credit Interest Rate: " + bankAccount.getCreditInterestRate());
            writer.println("Credit Term (Months): " + bankAccount.getCreditTermInMonths());
        }
    }

    // Метод для сохранения данных бизнес-аккаунта в файл
    private void saveBusinessAccountData(BusinessAccount businessAccount, PrintWriter writer) {
        writer.println("Business Account Data:");
        writer.println("AccountId: " + businessAccount.getAccountId());
        writer.println("Login: " + businessAccount.getLogin());
        writer.println("Password: " + businessAccount.getPassword());
        writer.println("Full name: " + businessAccount.getFullName());
        writer.println("Phone Number: " + businessAccount.getPhoneNumber());
        writer.println("\nBusiness Card Data:");
        writer.println("CardHolderName: " + businessAccount.getBusinessCard().getCardHolderName());
        writer.println("Card Number: " + businessAccount.getBusinessCard().getCardNumber());
        writer.println("Expiration Date: " + businessAccount.getBusinessCard().getExpirationDate());
        writer.println("Balance: " + businessAccount.getBusinessCard().getBalance());
        writer.println("Currency: " + businessAccount.getBusinessCard().getCurrency());

        if (businessAccount.hasCredit()) {
            writer.println("Credit Data:");
            writer.println("Credit Balance: " + businessAccount.getCreditBalance());
            writer.println("Credit Interest Rate: " + businessAccount.getCreditInterestRate());
            writer.println("Credit Term (Months): " + businessAccount.getCreditTermInMonths());
        }
    }

    // Метод для создания и записи данных в файл card.txt
    private void createCardFile(Account account) throws IOException {
        if (account instanceof BankAccount bankAccount) {
            String fileName = ACCOUNTS_DATA_DIR + File.separator + account.getFullName() + "_" + account.getAccountId() + "_" + account.getLogin() + File.separator + "card.txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.println("CardHolderName: " + bankAccount.getDebitCard().getCardHolderName());
                writer.println("Card Number: " + bankAccount.getDebitCard().getCardNumber());
                writer.println("Expiration Date: " + bankAccount.getDebitCard().getExpirationDate());
                writer.println("Balance: " + bankAccount.getDebitCard().getBalance());
                writer.println("Currency: " + bankAccount.getDebitCard().getCurrency());
                // Данные DebitCard
            }
        } else if (account instanceof BusinessAccount businessAccount) {
            String fileName = ACCOUNTS_DATA_DIR + File.separator + account.getFullName() + "_" + account.getAccountId() + "_" + account.getLogin() + File.separator + "card.txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.println("CardHolderName: " + businessAccount.getBusinessCard().getCardHolderName());
                writer.println("Card Number: " + businessAccount.getBusinessCard().getCardNumber());
                writer.println("Expiration Date: " + businessAccount.getBusinessCard().getExpirationDate());
                writer.println("Balance: " + businessAccount.getBusinessCard().getBalance());
                writer.println("Currency: " + businessAccount.getBusinessCard().getCurrency());
                // Данные BusinessCard
            }
        }
    }

    // Метод для создания и записи данных в файл credit.txt
    private void createCreditFile(Account account) throws IOException {
        if (account.hasCredit()) {
            String fileName = ACCOUNTS_DATA_DIR + File.separator + account.getFullName() + "_" + account.getAccountId() + "_" + account.getLogin() + File.separator + "credit.txt";
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.println("Credit Balance: " + account.getCreditBalance());
                writer.println("Credit Interest Rate: " + account.getCreditInterestRate());
                writer.println("Credit Term (Months): " + account.getCreditTermInMonths());
            }
        }
    }

    public boolean isAccountExists(String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountExists(String fullName, String accountId, String login) {
        for (Account account : accounts) {
            if (account.getFullName().equals(fullName) && account.getAccountId().equals(accountId) && account.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public Account findAccount(String fullName, String accountId, String login) {
        for (Account account : accounts) {
            if (account.getFullName().equals(fullName) && account.getAccountId().equals(accountId) && account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }

    public Account findLoginAccount(String login) {
        for (Account account : accounts) {
            if (account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Registration {
    private static final String FILE_PATH = "bank_accounts.csv";
    private List<Account> accounts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public void loadAccountsFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(",");
                String bankNumber = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                String phoneNumber = parts[3];
                String login = parts[4];
                String password = parts[5];
                double balance = Double.parseDouble(parts[6]);

                Person person = new Person(firstName, lastName, phoneNumber);
                Account account = new Account(person, login, password);
                account.setBankNumber(bankNumber);

                account.deposit(balance);
                accounts.add(account);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println("Не удалось загрузить счета из файла. Начинаем с пустого списка.");
            accounts = new ArrayList<>();
        }
    }


    public void saveAccountsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Account account : accounts) {
                writer.println(
                        account.getBankNumber() + "," +
                                account.getPerson().getFirstName() + "," +
                                account.getPerson().getLastName() + "," +
                                account.getPerson().getPhoneNumber() + "," +
                                account.getLogin().toLowerCase() + "," +
                                account.getPassword() + "," +
                                account.getBalance()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAccountByIndex(int index, Account account){
        loadAccountsFromFile();
        accounts.set(index, account);
    }


    public List<Account> getAccounts() {
        return accounts;
    }
}
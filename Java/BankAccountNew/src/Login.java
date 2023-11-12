import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static final List<Account> accounts = new ArrayList<>();
    private static final Registration registration = new Registration();

    public Account authenticate(String username, String password) {
        Account account = findAccountByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            return account;
        }

        return null;
    }

    public Account findAccountByUsername(String login) {
        loadAccountsFromFile();
        for (Account acc : accounts) {
            if (acc.getLogin().equals(login)) {
                return acc;
            }
        }
        return null;
    }

    public void loadAccountsFromFile() {
        registration.loadAccountsFromFile();
    }
}

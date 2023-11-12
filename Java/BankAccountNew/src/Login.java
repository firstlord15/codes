import java.util.List;


public class Login {
    private static final Registration registration = new Registration();

    public Account authenticate(String username, String password) {
        Account account = findAccountByUsername(username);

        if (account != null && account.getPassword().equals(password)) {
            return account;
        }

        return null;
    }

    public Account findAccountByIndex(int index) {
        loadAccountsFromFile();
        return registration.getAccounts().get(index);
    }

    public Integer findIndexAccount(String login) {
        loadAccountsFromFile();
        List<Account> list = registration.getAccounts();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login)) {
                return i;
            }
        }
        return null;
    }

    public Account findAccountByUsername(String login) {
        loadAccountsFromFile();
        for (Account account : registration.getAccounts()) {
            System.out.println(account.getLogin());
            if (account.getLogin().equals(login)) {
                return account;
            }
        }
        return null;
    }

    public void loadAccountsFromFile() {
        registration.loadAccountsFromFile();
    }
}

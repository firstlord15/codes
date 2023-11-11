import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private Map<String, String> userCredentials;

    public LoginService() {
        // Здесь вы можете инициализировать базу данных пользователей или другое хранилище учетных данных
        userCredentials = new HashMap<>();
        userCredentials.put("demoUser", hashPassword("demoPassword"));
    }

    public boolean authenticateUser(String username, String password) {
        if (userCredentials.containsKey(username)) {
            String storedHashedPassword = userCredentials.get(username);
            String enteredHashedPassword = hashPassword(password);
            return storedHashedPassword.equals(enteredHashedPassword);
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

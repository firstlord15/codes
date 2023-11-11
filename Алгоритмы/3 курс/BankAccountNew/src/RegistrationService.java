import java.util.HashMap;
import java.util.Map;

public class RegistrationService {
    private final Map<String, String> userCredentials;

    public RegistrationService() {
        // Инициализация базы данных пользователей
        userCredentials = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            String hashedPassword = hashPassword(password);
            userCredentials.put(username, hashedPassword);
            return true;
        }
        return false;
    }

    private String hashPassword(String password) {
        // Простое хэширование пароля
        return Integer.toHexString(password.getBytes().hashCode());
    }
}

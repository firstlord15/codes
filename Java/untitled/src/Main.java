import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();
        User[] users = {
                new User(1, "Ratmir", "Ashimov", "Timurovich", 19),
                new User(2, "John", "Doe", "Smith", 25),
                new User(3, "Alice", "Johnson", "Jones", 22), // Если вы думаете, почему в 12 задание нет этого эелмента, то строка 46
                new User(4, "Bob", "Smith", "Miller", 30),
                new User(5, "Eva", "Williams", "Brown", 28),
                new User(6, "Michael", "Jones", "Taylor", 35),
                new User(7, "Sophia", "Davis", "White", 19),
                new User(8, "Daniel", "Taylor", "Hill", 33),
                new User(9, "Olivia", "Martin", "Moore", 23),
                new User(10, "James", "Thomas", "Clark", 40),
                new User(11, "Emma", "Miller", "Anderson", 23),
        };

        for (User user: users) {
            userList.add(user);
        }

        System.out.print("1 задание: ");
        printAllUser(userList);
        System.out.println();

        System.out.print("2 задание: ");
        System.out.println(getUserById(userList, users[0].getId()).getName());
        System.out.println();

        System.out.print("3 задание: ");
        System.out.println(addUser(userList, new User(12, "NewEmma", "Miller", "Anderson", 23)));
        System.out.println();

        System.out.println("4 задание: ");
        System.out.println(changeUserById(userList, 1));
        System.out.println();

        System.out.print("5 задание: ");
        System.out.println(removeUser(userList, 3)); // удалил оказывается
        System.out.println();

        System.out.print("6 задание: ");
        printNameAgeUsers(userList);
        System.out.println();

        System.out.print("7 задание: ");
        printNameUsersByLen(userList, 6);
        System.out.println();

        System.out.print("8 задание: ");
        System.out.println(getMultiAgeUsers(userList));
        System.out.println();

        System.out.print("9 задание: ");
        System.out.println(getMinAge(userList));
        System.out.println();

        System.out.print("10 задание: ");
        System.out.println(getMaxAge(userList));
        System.out.println();

        System.out.print("11 задание: ");
        System.out.println(isUserByLetter(userList, "R"));
        System.out.println();

        System.out.print("12 задание: ");
        System.out.println(lastFunction(userList).toString());
        System.out.println();

        System.out.println(userList.get(3).getAge() + " " + userList.get(3).getId());
    }

    public static void printAllUser(ArrayList<User> list) {
        list.stream().forEach(x -> System.out.print(x.getId()+": "+x.getName() + ", "));
    }

    public static User getUserById(ArrayList<User> list, int id){
        return list.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static boolean addUser(ArrayList<User> list, User user){
        if (getUserById(list, user.getId()) != null) {
            System.out.println("Такой пользователь уже есть");
            return false;
        }

        list.add(user);
        return true;
    }


    public static boolean changeUserById(ArrayList<User> list, int id){
        if (getUserById(list, id) == null){
            System.out.println("Такого пользователя нет");
            return false;
        }

        User currentUser = getUserById(list, id);
        Scanner scanner = new Scanner(System.in);
        String question = "Укажите новое %s: ";

        while (true) {
            System.out.println("Что вы хотите сменить?:\n" +
                    "[1] Имя ("+ currentUser.getName() + ")\n" +
                    "[2] Фамилия ("+ currentUser.getSurname() + ")\n" +
                    "[3] Отчество ("+ currentUser.getLastname() + ")\n");

            String answer = scanner.next();

            switch (answer.trim().toLowerCase()){
                case "1" -> {
                    System.out.printf(question, "имя (" + currentUser.getName() + "): ");
                    currentUser.setName(scanner.next().trim());
                }

                case "2" -> {
                    System.out.printf(question, "фамилию (" + currentUser.getSurname() +"): ");
                    currentUser.setSurname(scanner.next().trim());
                }

                case "3" -> {
                    System.out.printf(question, "отчество (" + currentUser.getLastname() +"): ");
                    currentUser.setLastname(scanner.next().trim());
                }

                case "4", "выход", "пока", "exit" -> {return true;}
                default -> throw new IllegalStateException("Unexpected value: " + answer.trim().toLowerCase());
            }
        }
    }


    public static boolean removeUser(ArrayList<User> list, int id){
        if (getUserById(list, id) == null){
            System.out.println("Такого пользователя нет");
            return false;
        }

        list.remove(getUserById(list, id));
        return true;
    }

    public static void printNameAgeUsers(ArrayList<User> list){
        list.stream()
                .forEach(x-> System.out.print("Имя: " + x.getName() + " возраст: " + x.getAge() + ", "));
    }

    public static void printNameUsersByLen(ArrayList<User> list, int len){
        list.stream().filter(x -> x.getName().length() == len).forEach(x -> System.out.print(x.getName() +"("+ len +")" + ", "));
    }

    public static long getMultiAgeUsers(ArrayList<User> list){
        return list.stream()
                .filter(x -> x.getAge() > 20)
                .mapToLong(User::getAge)
                .reduce(1, (a, b) -> a * b);
    }// не уверен на это заданиеп

    public static int getMinAge(ArrayList<User> list){
        return list.stream()
                .mapToInt(User::getAge)
                .min()
                .orElse(-1);
    }

    public static int getMaxAge(ArrayList<User> list){
        return list.stream()
                .mapToInt(User::getAge)
                .max()
                .orElse(-1);
    }

    public static boolean isUserByLetter(ArrayList<User> list, String letter){
        return list.stream().anyMatch(x -> x.getName().startsWith(letter));
    }

    public static LinkedHashMap<Integer, String> lastFunction(ArrayList<User> list){
        LinkedHashMap<Integer, String> result = new LinkedHashMap<>();

        list.stream()
                .filter(x -> x.getAge() > 18 && x.getAge() < 25 && x.getId() % 3 == 0)
                .forEach(x -> result.put(x.getId(), x.getName()));

        return result;
    }
}
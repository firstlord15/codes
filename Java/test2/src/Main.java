import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    File file = new File("results.txt");
    ArrayList<String> results_list = new ArrayList<>();

    double Factorial(double n) {
        double result;
        if (n==1) return 1;
        result = Factorial(n-1)*n;
        return result;
    }

    void WriteResult(double result){
        FileWriter f;
        String out;
        try {
            f = new FileWriter(file, true);
            for (String element : results_list) {
                out = String.valueOf(element);
                f.write(out + ", ");
            }
            f.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void ReadResult(boolean status) {
        if (status) {
            ArrayList<String> list = getResults_list();
            if (!list.isEmpty()) {
                for (String item : list) {
                    System.out.println("Ответы: " + item);
                }
            }
            else{
                System.out.println("Пустой массив\n");
            }
        }
        else {
            System.out.println("Пока пока");
        }
    }

    void ReadResult() {
        Scanner scanner = null;
        try {
            if (file.length() != 0){
                scanner = new Scanner(file);
                String line = scanner.nextLine();
                System.out.println("Ответы: " + line + "\n");
            }
            else {
                System.out.println("Нет ответов\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (scanner != null) {
            scanner.close();
        }
    }
    double Calculator(String operation, double first, double second){
        double result = 0;
        switch (operation) {
            case "+" -> result = first + second;
            case "-" -> result = first - second;
            case "*" -> result = first * second;
            case "/" -> result = first / second;
            case "!" -> result = Factorial(first);
        }

        results_list.add(String.valueOf(result));
        WriteResult(result);
        return result;
    }

    public ArrayList<String> getResults_list() {
        return results_list;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        double first, second;
        String operation;

        if (!m.file.exists()) {
            try {
                m.file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Здравствуйте пользователь, добро пожаловать в Calc v1\n");
            while (true) {
                System.out.println("Что вы хотите сделать?");
                System.out.println("""
                        [1] Решить математическое решение
                        [2] Вывести список ответов
                        [3] Вывести весь список ответов
                        [4] Найти факториал\s
                        [5] Выйти из программы""");
                int answer = scanner.nextInt();

                if (answer == 1) {
                    System.out.println("Введите первого число: ");
                    first = scanner.nextDouble();

                    System.out.println("Введите второе число: ");
                    second = scanner.nextDouble();

                    System.out.println("Введите операцию (+, -, *, /): ");
                    operation = scanner.next().trim();

                    System.out.println(m.Calculator(operation, first, second) + "\n");

                } else if (answer == 2) {
                    m.ReadResult(true);
                } else if (answer == 3) {
                    m.ReadResult();
                } else if (answer == 4) {
                    System.out.println("Введите число: ");
                    first = scanner.nextDouble();

                    double result = m.Calculator("!", first, 0.0);
                    System.out.println("Ответ factorial: " + result + "\n");
                } else if (answer == 5) {
                    System.out.println("До свиданиe!");
                    break;
                }
            }
    }
}
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    double Factorial(double n) {
        if (n == 1) return 1;
        return Factorial(n - 1) * n;
    }

    int Factorial(int n) {
        if (n == 1) return 1;
        return Factorial(n - 1) * n;
    }

    double add(double first, double second){return first + second;}
    int add(int first, int second){return first + second;}
    double subtract(double first, double second){return first - second;}
    int subtract(int first, int second){return first - second;}

    int multiply(int first, int second){return first * second;}
    double multiply(double first, double second){return first * second;}
    int divide(int first, int second){return first / second;}

    double divide(double first, double second){
        if (second == 0){
            System.out.println("Ошибка: деление на ноль.");
            return Double.NaN;
        }
        return first / second;
    }

    double Calculator (String op, double first, double second) {
        double result = 0;
        switch (op) {
            case "+" -> result = add(first, second);
            case "-" -> result = subtract(first, second);
            case "*" -> result = multiply(first, second);
            case "/" -> result = divide(first, second);
            case "!" -> result = Factorial(first);
        }
        return result;
    }

    int Calculator (String op, int first, int second) {
        int result = 0;
        switch (op) {
            case "+" -> result = add(first, second);
            case "-" -> result = subtract(first, second);
            case "*" -> result = multiply(first, second);
            case "/" -> result = divide(first, second);
            case "!!!" -> result = Factorial(first);
        }
        return result;
    }


    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> results = new ArrayList<String>();
        System.out.println("Здравствуйте! Добро пожаловать в калькулятор");


        while (true) {
            String answer;

            System.out.println("Что вы хотите сделать?: ");
            System.out.println(
                    """
                            [1] Решить математическую задачу
                            [2] Найти факториал числа
                            [3] Вывести ответы
                            Напишите 'exit' для выхода из программы\n"""
            );
            answer = scanner.next();

            if (answer.trim().equals("1")){
                System.out.println("\n[1] int or [2] double?");
                String type = scanner.next();

                System.out.println("\nВыберите операцию: +, -, *, /");
                String op = scanner.next();

                System.out.println("\nВведите первое число");
                String first = scanner.next();

                System.out.println("\nВведите второе число");
                String second = scanner.next();


                if (type.trim().equals("1")){
                    int result = m.Calculator(op, Integer.parseInt(first), Integer.parseInt(second));
                    System.out.println("Ответ: "+result + "\n");
                    results.add(String.valueOf(result));
                }
                else if (type.trim().equals("2")){
                    double result = m.Calculator(op, Double.parseDouble(first), Double.parseDouble(second));
                    System.out.println("Ответ: "+result + "\n");
                    results.add(String.valueOf(result));
                }
            }
            else if (answer.trim().equals("2")) {
                System.out.println("\nВведите число: ");
                String num = scanner.next();

                System.out.println("\n[1] int or [2] double?");
                String type = scanner.next();

                if (type.trim().equals("1")){
                    int result = m.Factorial(Integer.parseInt(num));
                    System.out.println("Ответ: "+result + "\n");
                    results.add(String.valueOf(result));
                } else if (type.trim().equals("2")) {
                    double result = m.Factorial(Double.parseDouble(num));
                    System.out.println("Ответ: "+result + "\n");
                    results.add(String.valueOf(result));
                }

            }
            else if (answer.trim().equals("3")) {
                System.out.println("Ответ: " + "\n");

                if (results.isEmpty()){
                    System.out.println("\nМассив пуст");
                }
                else if (results.size() == 1) {
                    for (String item : results) {
                        System.out.print(item);
                    }
                }
                else {
                    for (String item : results) {
                        System.out.print(item + ", ");
                    }
                }
                System.out.println("\n");
            }
            else if (answer.trim().toLowerCase(Locale.ROOT).equals("exit")) {
                System.out.println("\nSystem: [Отключение программы...]");
                break;
            }
        }
    }
}
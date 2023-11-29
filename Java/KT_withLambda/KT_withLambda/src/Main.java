import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Calculate calculate = (x, y, method) -> {
            int result = 0;

            switch (method.trim()) {
                case "+" -> result = x + y;
                case "-" -> result = x - y;
                case "*" -> result = x * y;
                case "/" -> result = x / y;
                default -> throw new IllegalStateException("Unexpected value: " + method);
            }

            return result;
        };

        Filter filter = (String[] list, String start) -> {
            ArrayList<String> result = new ArrayList<>();

            for (String string : list) {
                if (string.startsWith(start)){
                    result.add(string);
                }
            }

            return result.toArray(new String[0]);
        };

        Reverse reverse = (String string) -> {
            StringBuilder stringBuilder = new StringBuilder(string);
            return stringBuilder.reverse().toString();
        };

        Unpaired unpaired = (int[] ints) -> {
            LinkedHashSet<Integer> result = new LinkedHashSet<>();
            for (int num: ints){
                result.add(num);
            }

            int[] arrayResult = new int[result.size()];
            int index = 0;

            for (int num : result) {
                arrayResult[index++] = num;
            }

            return arrayResult;
        };

        IsSimple isSimple = (int number) -> {
            if(number < 2) return false;

            for(int i = 2; i < number / 2; i++) {
                if(number % i == 0) {
                    return false;
                }
            }
            return true;
        };


        String[] strings = {"Test", "Turkey", "Moscow", "Ratmir", "Tak","Red", "Man", "Men", "Children", "Chicken", "Folder", "Format", "Vlog", "View"};
        int[] nums = {1, 1, 3, 4, 6, 7, 2, 9, 7, 3, 9, 3, 2, 5};
        String starts = "T";


        System.out.println("Задание 1:" + Arrays.toString(filter.apply(strings, starts)));
        System.out.println("Задание 2:" + calculate.operation(10, 10, "*"));
        System.out.println("Задание 3:" + reverse.apply("Hello, world!"));
        System.out.println("Задание 4:" + Arrays.toString(unpaired.apply(nums)));
        System.out.println("Задание 5:" + isSimple.apply(17));
    }
}
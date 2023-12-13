import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void function(int a, int b, int c, int d, int e, int f) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();

        for (int i = 0; i <= c - 1; i++) {
            first.add(a * i % c);
            second.add(d * i % f);
        }

        boolean hasCommonElement = false;

        for (int num : first) {
            if (second.contains(num)) {
                hasCommonElement = true;
                break;
            }
        }

        if (hasCommonElement) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        function(3, 1, 2, 5, 0, 10);
    }
}

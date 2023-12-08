import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static boolean bruteForce(int[] ArrayInteger){
        for (int i = 0; i < ArrayInteger.length; i++) {
            for (int j = i+1; j < ArrayInteger.length; j++) {
                if (ArrayInteger[i] == ArrayInteger[j]){
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean quickCheck(int[] ArrayInteger){
        Arrays.sort(ArrayInteger); // O(n log n)

        for (int i = 0; i < ArrayInteger.length - 1; i++) {
            if (ArrayInteger[i] == ArrayInteger[i+1]){
                return true;
            }
        }
        // O(n) * O(1) * O(1) = O(n)
        // O(n log n) + O(n) = n * log n + n = n(1 + 1 * log n)
        // O ~ n log n

        return false;
    }

    public static boolean midCheck(int[] ArrayInteger){
        Set<Integer> set = new HashSet<>();

        for (int num : ArrayInteger) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        // O(n) * O(1) = O(n)
        return false;
    }

    public static boolean kCheck(int[] ArrayInteger){
        int k = Arrays.stream(ArrayInteger).max().getAsInt();
        int[] arr = new int[k + 1];

        for (int num: ArrayInteger) {
            if (arr[num] > 0){
                return true;
            } else {
                arr[num] += 1;
            }
        }

        return false;
    }

}

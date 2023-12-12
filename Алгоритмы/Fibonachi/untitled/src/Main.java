public class Main {
    public static int[] Fibonacci(int n) {
        int[] result = new int[n+1];

        result[0] = 0;
        result[1] = 1;

        for (int i = 0; i <= n; i++) result[i] = result[i - 1] + result[i - 2];

        return result;
    }

    public static void main(String[] args) {

    }
}
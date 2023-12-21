import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        int[] coinValues = {10, 60, 100};
        int amount = 120;
        HashMap<Integer, Integer> knownResults = new HashMap<>();
        int result = function(coinValues, amount, knownResults);
        System.out.println("Минимальное количество монет для размена: " + result);
    }

    public static int function(int[] coinValueList, int amount, HashMap<Integer, Integer> knownResults) {
        int minCoins = amount;

        if (amount == 0) {
            return 0;
        } else if (knownResults.containsKey(amount)) {
            return knownResults.get(amount);
        } else {
            for (int coin : coinValueList) {
                if (coin <= amount) {
                    int numCoins = 1 + function(coinValueList, amount - coin, knownResults);
                    if (numCoins < minCoins) {
                        minCoins = numCoins;
                        knownResults.put(amount, minCoins);
                    }
                }
            }
        }
        return minCoins;
    }
}

import java.util.Arrays;

public class Main {
    private static int[] HashTableOps(int[] ListOfInts){
        int[] HashTable = new int[9];
        int count = 0;

        for (int num: ListOfInts){
            int index = Hash(num);
            System.out.println("key: " + num + ", key_bf_mod: "+ (11 * num + 4) + ", index: " + index);
            while(HashTable[index] != 0){
                index = (index + 1) % HashTable.length;
            }
            HashTable[index] = num;
            count++;

            if (count == HashTable.length) {
                System.out.println("Хеш-таблица заполнена. Нельзя добавить больше элементов.");
                break;
            }
        }
        return HashTable;
    };
    private static int Hash(int key){
        return (11 * key + 4) % 9;
    }


    public static void main(String[] args) {
        int[] list = {67, 13, 49, 24, 40, 33, 58};

        System.out.println(Arrays.toString(HashTableOps(list)));
    }
}
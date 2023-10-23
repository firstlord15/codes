import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        int[] RandomArrayInteger = generateRandomInteger(30, 0, 100);
        BST bst = new BST();
        AVLTree avlTree = new AVLTree();
        BinaryHeap binaryHeap = new BinaryHeap();
        ArrayList<Integer> sorted_ar = new ArrayList<>();
        System.out.print("Random array of numbers: ");

        for (int num : RandomArrayInteger) {
            System.out.print(num + " ");
            bst.insert(num);
            avlTree.insert(num);
            binaryHeap.Insert(num);
        }

        System.out.println("\n\nBINARY SEARCH TREE from random\n");
        bst.visualize();
        System.out.println("\n\nAVL BALANCED TREE from random\n");
        avlTree.visualize();
        System.out.println("\n\nBINARY_HEAP from random\n");
        binaryHeap.Print();

        for(int i = 0; i < RandomArrayInteger.length; ++i) {
            sorted_ar.add(binaryHeap.getElement(0));
            binaryHeap.Delete();
        }

        System.out.println("\nHEAP SORTED LIST from random:");
        System.out.println(sorted_ar);
    }

    public static int[] generateRandomInteger(int count, int min, int max) throws IllegalAccessException {
        if ((max - min + 1) < count) {
            throw new IllegalAccessException("Range is smaller than the count");
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = min; i < max; ++i) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        int[] result = new int[count];
        for(int i = 0; i < count; ++i) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}

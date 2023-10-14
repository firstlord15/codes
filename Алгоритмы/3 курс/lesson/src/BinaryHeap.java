import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryHeap {

    int[] heap;
    int size;

    public BinaryHeap() {
        heap = new int[120];
        size = 0;
    }

    public void Insert(int item) {
        if (size == heap.length) {
            ResizeHeap();
        }

        heap[size] = item;
        size++;
        ShiftUp(size - 1);
    }

    public int Delete() throws Exception {
        if (size == 0) {
            throw new Exception("Heap is empty");
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        ShiftDown(0);

        return root;
    }

    private void ShiftUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && heap[parentIndex] < heap[index]) {
            Swap(parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void ShiftDown(int index) {
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;

            if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
                largest = rightChildIndex;
            }

            if (largest != index) {
                Swap(largest, index);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void Swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void ResizeHeap() {
        int[] newHeap = new int[heap.length * 2];
        newHeap = Arrays.copyOf(heap, heap.length);
        heap = newHeap;
    }

    public void Print() {
        if (size == 0) {
            System.out.println("PriorityQueue is empty.");
            return;
        }

        PrintNode(0, "");
    }

    private void PrintNode(int index, String indent) {
        if (index < size) {
            System.out.println(indent + heap[index]);

            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex < size) {
                System.out.println(indent + "├── " + "Left Child:");
                PrintNode(leftChildIndex, indent + "│   ");
            }

            if (rightChildIndex < size) {
                System.out.println(indent + "└── " + "Right Child:");
                PrintNode(rightChildIndex, indent + "    ");
            }
        }

    }
}
import java.util.Arrays;

public class BinaryHeap {
    int[] heap = new int[120];
    int size = 0;

    public BinaryHeap() {
    }

    public void Insert(int item) {
        if (this.size == this.heap.length) {
            this.ResizeHeap();
        }

        this.heap[this.size] = item;
        ++this.size;
        this.ShiftUp(this.size - 1);
    }

    public int Delete() throws Exception {
        if (this.size == 0) {
            throw new Exception("Heap is empty");
        } else {
            int root = this.heap[0];
            this.heap[0] = this.heap[this.size - 1];
            --this.size;
            this.ShiftDown(0);
            return root;
        }
    }

    private void ShiftUp(int index) {
        for(int parentIndex = (index - 1) / 2; parentIndex >= 0 && this.heap[parentIndex] < this.heap[index]; parentIndex = (parentIndex - 1) / 2) {
            this.Swap(parentIndex, index);
            index = parentIndex;
        }

    }

    private void ShiftDown(int index) {
        while(true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int largest = index;
            if (leftChildIndex < this.size && this.heap[leftChildIndex] > this.heap[index]) {
                largest = leftChildIndex;
            }

            if (rightChildIndex < this.size && this.heap[rightChildIndex] > this.heap[largest]) {
                largest = rightChildIndex;
            }

            if (largest == index) {
                return;
            }

            this.Swap(largest, index);
            index = largest;
        }
    }

    private void Swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    private void ResizeHeap() {
        int[] newHeap = new int[this.heap.length * 2];
        newHeap = Arrays.copyOf(this.heap, this.heap.length);
        this.heap = newHeap;
    }

    public int getElement(int index) {
        return this.heap[index];
    }

    public void Print() {
        if (this.size == 0) {
            System.out.println("PriorityQueue is empty.");
        } else {
            this.PrintNode(0, "");
        }
    }

    private void PrintNode(int index, String indent) {
        if (index < this.size) {
            System.out.println(indent + this.heap[index]);
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex < this.size) {
                System.out.println(indent + "├── Left Child:");
                this.PrintNode(leftChildIndex, indent + "│   ");
            }

            if (rightChildIndex < this.size) {
                System.out.println(indent + "└── Right Child:");
                this.PrintNode(rightChildIndex, indent + "    ");
            }
        }

    }
}
import java.util.*;

public class MyStack<T> {
    private final List<T> list;

    public MyStack() {
        this.list = new ArrayList<>();
    }

    public void push(T element) {
        list.add(element);
    }

    public T pop(){
        return list.getLast();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void forEach() {
        for (T element: list){
            System.out.println(element);
        }
    }
}

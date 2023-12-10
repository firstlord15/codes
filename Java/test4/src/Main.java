public class Main {
    public static void main(String[] args) {
        MyStack<Object> stack = new MyStack<>();
        stack.push(10);
        stack.push("test");
        stack.push(true);
        stack.push(15.232);
        System.out.println(stack.pop());
        stack.forEach();
    }
}
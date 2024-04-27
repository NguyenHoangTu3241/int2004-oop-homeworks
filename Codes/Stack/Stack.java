import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack<Item> {
    private List<Item> list;
    public Stack() {
        list = new LinkedList<>();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public void push(Item i) {
        list.addFirst(i);
    }
    public void pop() {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        list.removeFirst();
    }
    public Item top() {
        if (list.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return list.getFirst();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.println(stack.top());
            System.out.println(stack.size());
            stack.pop();
        }
        System.out.println(stack.isEmpty());
    }
}
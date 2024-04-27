import java.util.*;
public class StringStack {
    private class Node {
        String data;
        Node prev;
        Node(String data) {
            this.data = data;
        }
    }
    private Node top;
    private int size;
    StringStack() {
        top = null;
        size = 0;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int Size() {
        return size;
    }
    public String Top() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return top.data;
    }
    public void push(String data) {
        Node newNode = new Node(data);
        newNode.prev = top;
        top = newNode;
        size++;
    }
    public void pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException("Stack is empty");
        top = top.prev;
        size--;
    }
    public static void main(String[] args) {
        StringStack stack = new StringStack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");

        System.out.println(stack.isEmpty());
        while (!stack.isEmpty()) {
            System.out.println(stack.Top());
            System.out.println(stack.Size());
            stack.pop();
        }
        System.out.println(stack.isEmpty());
    }

}


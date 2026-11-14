// push, pop, peek, isEmpty: all O(1). Unlike an array stack it never becomes full.
public class PlateStack {
    static class Node { String data; Node next; Node(String d) { data = d; } }
    static Node top = null; static int size = 0;
    static void push(String p) {
        Node n = new Node(p); n.next = top; top = n; size++;
        System.out.println("push " + p + " -> top " + top.data + ", size " + size);
    }
    static void pop() {
        if (isEmpty()) { System.out.println("pop -> stack is empty"); return; }
        String d = top.data; top = top.next; size--;
        System.out.println("pop -> " + d + ", size " + size);
    }
    static void peek() { System.out.println(isEmpty() ? "peek -> stack is empty" : "peek -> " + top.data); }
    static boolean isEmpty() { return top == null; }
    public static void main(String[] args) {
        push("P1"); push("P2"); peek(); pop(); push("P3"); pop(); pop(); pop();
        System.out.println("isEmpty -> " + isEmpty());
    }
}
// addFirst: O(1). addLast: O(n) (must walk to the end).
public class LateComersLine {
    static class Node { String data; Node next; Node(String d) { data = d; } }
    static Node addFirst(Node head, String name) { Node n = new Node(name); n.next = head; return n; }
    static Node addLast(Node head, String name) {
        Node n = new Node(name);
        if (head == null) return n;
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
        return head;
    }
    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node c = head; c != null; c = c.next) sb.append(c.data).append(" -> ");
        System.out.println(sb + "null");
    }
    public static void main(String[] args) {
        Node line = addLast(addLast(null, "Asha"), "Ravi");
        line = addFirst(line, "Neha"); line = addLast(line, "Kiran"); line = addFirst(line, "Mohan");
        print(line);
        Node line2 = null;
        line2 = addLast(line2, "Pooja"); line2 = addFirst(line2, "Arun");
        print(line2);
    }
}
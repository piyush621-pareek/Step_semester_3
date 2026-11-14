// At the head: O(1). At the end: O(n).
public class CancelBooking {
    static class Node { String data; Node next; Node(String d) { data = d; } }
    static Node build(String... v) {
        Node head = null, tail = null;
        for (String s : v) { Node n = new Node(s); if (head == null) head = tail = n; else { tail.next = n; tail = n; } }
        return head;
    }
    static Node removeFirst(Node head, String booking) {
        if (head == null) { System.out.println(booking + " not found"); return null; }
        if (head.data.equals(booking)) return head.next;
        Node cur = head;
        while (cur.next != null && !cur.next.data.equals(booking)) cur = cur.next;
        if (cur.next == null) System.out.println(booking + " not found");
        else cur.next = cur.next.next;
        return head;
    }
    static void print(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node c = head; c != null; c = c.next) sb.append(c.data).append(" -> ");
        System.out.println(sb + "null");
    }
    public static void main(String[] args) {
        print(removeFirst(build("104", "101", "107", "101"), "101"));
        print(removeFirst(build("104", "101", "107"), "104"));
        print(removeFirst(build("104", "101"), "200"));
    }
}
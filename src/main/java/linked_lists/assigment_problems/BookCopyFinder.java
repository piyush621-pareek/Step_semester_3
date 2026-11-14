// Time O(n). A chain has no index: reaching the middle means walking every node before it.
public class BookCopyFinder {
    static class Node { String data; Node next; Node(String d) { data = d; } }
    static Node build(String... ids) {
        Node head = null, tail = null;
        for (String s : ids) { Node n = new Node(s); if (head == null) head = tail = n; else { tail.next = n; tail = n; } }
        return head;
    }
    static String find(Node head, String id) {
        int pos = 0, copies = 0, first = -1;
        for (Node c = head; c != null; c = c.next) {
            pos++;
            if (c.data.equals(id)) { copies++; if (first == -1) first = pos; }
        }
        return copies == 0 ? id + " not found" : id + " first at position " + first + ", copies: " + copies;
    }
    public static void main(String[] args) {
        Node t = build("B12", "B07", "B30", "B07", "B45", "B07");
        System.out.println(find(t, "B07"));
        System.out.println(find(t, "B99"));
    }
}
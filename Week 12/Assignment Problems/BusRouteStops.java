// build: O(n), printRoute: O(n).
public class BusRouteStops {
    static class Node { String data; Node next; Node(String d) { data = d; } }
    static Node build(String[] stops) {
        Node head = null, tail = null;
        for (String s : stops) {
            Node n = new Node(s);
            if (head == null) head = tail = n; else { tail.next = n; tail = n; }
        }
        return head;
    }
    static void printRoute(Node head) {
        StringBuilder sb = new StringBuilder();
        int count = 0; String last = null;
        for (Node cur = head; cur != null; cur = cur.next) { sb.append(cur.data).append(" -> "); count++; last = cur.data; }
        System.out.println(sb + "null");
        System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last);
    }
    public static void main(String[] args) {
        printRoute(build(new String[]{"Tambaram", "Guindy", "TNagar", "Central"}));
        printRoute(build(new String[]{"Potheri"}));
    }
}
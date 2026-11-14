import java.util.Scanner;
// Every stack and queue operation is O(1).
public class LibraryReturnDesk {
    static String[] pile = new String[3]; static int top = -1;
    static String[] line = new String[3]; static int front = 0, rear = -1, size = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) all.append(sc.nextLine()).append(",");
        for (String raw : all.toString().split(",")) {
            String cmd = raw.trim();
            if (cmd.isEmpty()) continue;
            String[] p = cmd.split("\\s+");
            switch (p[0]) {
                case "RETURN":
                    if (top == pile.length - 1) System.out.println(p[1] + " rejected: pile is full");
                    else { pile[++top] = p[1]; System.out.println(p[1] + " placed on pile"); }
                    break;
                case "SHELVE":
                    if (top == -1) System.out.println("pile is empty");
                    else System.out.println("shelved " + pile[top--]);
                    break;
                case "WAIT":
                    if (size == line.length) System.out.println(p[1] + " rejected: line is full");
                    else { rear = (rear + 1) % line.length; line[rear] = p[1]; size++; System.out.println(p[1] + " joined the line"); }
                    break;
                case "SERVE":
                    if (size == 0) System.out.println("no one waiting");
                    else { System.out.println("served " + line[front]); front = (front + 1) % line.length; size--; }
                    break;
            }
        }
    }
}
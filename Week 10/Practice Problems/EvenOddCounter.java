import java.util.Scanner;
public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) all.append(sc.nextLine()).append(" ");
        int even = 0, odd = 0;
        for (String tok : all.toString().trim().split("[^-0-9]+")) {
            if (tok.isEmpty()) continue;
            int n = Integer.parseInt(tok);
            if (n % 2 == 0) even++; else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
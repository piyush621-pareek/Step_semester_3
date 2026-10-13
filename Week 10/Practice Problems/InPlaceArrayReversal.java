import java.util.Scanner;
public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) all.append(sc.nextLine()).append(" ");
        String[] parts = all.toString().trim().split("[^-0-9]+");
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (String p : parts) if (!p.isEmpty()) list.add(Integer.parseInt(p));
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) a[i] = list.get(i);
        // reverse in place with two pointers
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
        System.out.println(java.util.Arrays.toString(a));
    }
}
import java.util.HashSet;
public class TransactionDuplicateCheck {
    // HashSet: Time O(n) average, Space O(n) -> fastest, uses extra memory.
    // Alternative: sort then compare neighbours -> O(n log n) time, O(1) extra space (less memory, slower).
    static boolean hasDuplicate(String[] ids) {
        HashSet<String> seen = new HashSet<>();
        for (String id : ids)
            if (!seen.add(id)) return true;   // add() returns false if already present
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hasDuplicate(new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
        System.out.println(hasDuplicate(new String[]{"TXN2001", "TXN2002", "TXN2003"}));
    }
}
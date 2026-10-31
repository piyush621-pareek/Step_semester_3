import java.util.HashMap;
public class EmployeeIdLookup {
    // buildLookup: O(n) once. getDepartment: O(1) average. Space O(n) for the map.
    // Queries far outnumber updates, so a one-time O(n) build makes every lookup near-constant.
    static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> map = new HashMap<>();
        for (String[] r : records) map.put(r[0], r[1]);
        return map;
    }
    static String getDepartment(HashMap<String, String> lookup, String id) {
        return lookup.getOrDefault(id, "Unknown");
    }
    public static void main(String[] args) {
        String[][] records = {{"E245", "Finance"}, {"E110", "Engineering"}, {"E390", "Marketing"}, {"E101", "Engineering"}};
        HashMap<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
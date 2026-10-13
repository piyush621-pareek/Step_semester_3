public class ClassAttendanceTracker {
    // Time: O(n), Space: O(1). Both answers found in a single pass.
    static void attendanceSummary(int[] days) {
        int present = 0, run = 0, longest = 0;
        for (int d : days) {
            if (d == 1) { present++; run++; longest = Math.max(longest, run); }
            else run = 0;                         // streak breaks on a 0
        }
        System.out.println("Present: " + present + ", Longest streak: " + longest);
    }
    public static void main(String[] args) {
        attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        attendanceSummary(new int[]{0, 0, 0});
    }
}
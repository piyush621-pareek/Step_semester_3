
public class AttendanceSheet {

    private final String[] present;
    private int count;

    public AttendanceSheet(int maxClassSize) {
        this.present = new String[maxClassSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (count >= present.length) {
            return;
        }
        if (isPresent(name)) {
            return;
        }
        present[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count = " + sheet.getPresentCount());
        System.out.println("isPresent(Ben)  = " + sheet.isPresent("Ben"));
        System.out.println("isPresent(Chen) = " + sheet.isPresent("Chen"));
    }
}

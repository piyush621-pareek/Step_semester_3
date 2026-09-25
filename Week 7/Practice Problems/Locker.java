
public class Locker {

    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.code.equals(currentCode)) {
            this.code = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        System.out.println("Change 1234 -> 5678: " + l.changeCode("1234", "5678"));
        System.out.println("Change 0000 -> 9999: " + l.changeCode("0000", "9999"));

        System.out.println("Confirm code is 5678: " + l.changeCode("5678", "5678"));
    }
}

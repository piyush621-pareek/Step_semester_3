
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("\"abcd\" (4 chars)       -> " + pc.getStrength());  // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("\"abcdefgh\" (8 chars)   -> " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println("\"abcdefghijkl\" (12)    -> " + pc3.getStrength()); // Strong
    }
}

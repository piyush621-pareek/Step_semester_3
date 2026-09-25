
public class NameTag {

    private final String firstName;
    private final String lastInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastInitial = parts[1].substring(0, 1);
    }

    public String getNickname() {
        return firstName + " " + lastInitial + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());

        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println("Same nickname: " + tag.getNickname().equals(tag2.getNickname()));
        System.out.println("Separate objects: " + (tag != tag2));
    }
}

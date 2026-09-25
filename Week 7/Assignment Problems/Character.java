
public class Character {

    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        int newHealth = health - amount;
        health = Math.max(0, newHealth);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        int newHealth = health + amount;
        health = Math.min(maxHealth, newHealth);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("Start health = " + c.getHealth());

        c.takeDamage(30);
        System.out.println("After takeDamage(30)  -> " + c.getHealth());

        c.heal(50);
        System.out.println("After heal(50)        -> " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After takeDamage(150) -> " + c.getHealth());
    }
}

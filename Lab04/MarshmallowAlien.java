package Lab04;

public class MarshmallowAlien extends Alien{
    private static final int damage = 1;

    public MarshmallowAlien(int health, String name) {
        super(health, name);
    }

    public int getDamage() { return damage; }
}

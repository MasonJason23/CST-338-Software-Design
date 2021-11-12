package Lab04;

public class SnakeAlien extends Alien {
    private static final int damage = 10;

    public SnakeAlien(int health, String name) {
        super(health, name);
    }

    public int getDamage() { return damage; }
}

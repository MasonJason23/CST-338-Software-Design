package Lab04;

public class OgreAlien extends Alien{
    private static final int damage = 6;

    public OgreAlien(int health, String name) {
        super(health, name);
    }

    public int getDamage() { return damage; }
}

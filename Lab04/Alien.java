package Lab04;

public abstract class Alien {
    private int health; // 0=dead, 100=full strength
    private String name;

    public Alien() {
        setHealth(0);
        setName(null);
    }
    public Alien(int health, String name) {
        setHealth(health);
        setName(name);
    }

    public abstract int getDamage();

    public int getHealth() { return health; }
    public int setHealth(int health) {  return this.health; }

    public String getName() { return name; }
    public String setName(String name) { return this.name; }

}

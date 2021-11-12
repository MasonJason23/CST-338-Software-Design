package Lab04;

import java.util.ArrayList;

public class AlienPack {
    private ArrayList<Alien> aliens = new ArrayList<>();

    public void addAlien(Alien alien) {
        aliens.add(alien);
    }

    public int calculateDamage() {
        int damage = 0;

        for(Alien curAlien : aliens) {
            damage += curAlien.getDamage();
        }

        return damage;
    }
}

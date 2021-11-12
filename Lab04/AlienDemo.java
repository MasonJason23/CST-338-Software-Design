package Lab04;

public class AlienDemo {
    public static void main(String[] args) {
        OgreAlien brutus = new OgreAlien(100,"brutus");
        SnakeAlien slimy = new SnakeAlien(100,"slimy");
        MarshmallowAlien puffy = new MarshmallowAlien(100,"puffy");

        AlienPack pack = new AlienPack(); // 3 aliens in the pack
        pack.addAlien(brutus);
        pack.addAlien(slimy);
        pack.addAlien(puffy);

        System.out.printf("Total pack damage = %d",
                pack.calculateDamage());
    }
}

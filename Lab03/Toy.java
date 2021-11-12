package Lab03;

import java.util.ArrayList;

public class Toy {
    private int number;
    private String name;

    public Toy(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // checks if the passed object is of type Toy
        if (obj instanceof Toy) {
            // (casts the passed in object as Toy)
            Toy other = (Toy) obj;
            // compares the two Toy objects
            return ((this.number == other.number) && (this.name.equals(other.name)));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ArrayList<Toy> list = new ArrayList<Toy>();

        Toy tom100 = new Toy(100, "Tom");
        Toy tom200 = new Toy(200, "Tom");

        list.add(tom100);
        list.add(tom200);

        Toy tom100_2 = new Toy(100, "Tom");

            if (list.contains(tom100_2)) {
                System.out.println("Found");
            } else {
                System.out.println("Not found");
            }
    }
}
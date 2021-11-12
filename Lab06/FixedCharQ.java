package Lab06;

public class FixedCharQ implements InterCharQ{
    private char q[];

    private int putLoc;
    private int getLoc;

    public FixedCharQ(int size) {
        q = new char[size]; // allocate memory for queue
        putLoc = getLoc = 0;
    }

    public void put(char ch) {
        if (putLoc == q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putLoc++] = ch;
    }

    public char get() {
        if (getLoc == putLoc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return q[getLoc++];
    }
}

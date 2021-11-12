package Lab02;

import java.util.Scanner;

public class DrawDiagram {
    public static void main(String[] args) {

        System.out.print("Enter a length: ");
        Scanner keyboard = new Scanner(System.in);
        int length = keyboard.nextInt();
        String junk = keyboard.nextLine();

        String space = "  ";
        String starSpace = "* ";
        String star = "*";
        int sub = 1;


        for (int line = 0; line < length; line++) {
            for (int i = length-sub; i > 0; i--) {
                System.out.print(space);
            }

            for (int x = 0; x < length; x++) {
                if (x == length - 1) {
                    System.out.println(star);
                } else {
                    System.out.print(starSpace);
                }
            }
            sub++;
        }

        System.out.println();

        int x = length - 1;
        for(int l = 0; l < length; l++) {
            for(int column = x; column < length; column++) {
                if (column == length - 1) {
                    System.out.println(star);
                } else {
                    System.out.print(starSpace);
                }
            }
            x--;
        }
        return;
    }
}

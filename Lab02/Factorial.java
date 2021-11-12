package Lab02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        String loop = "Y";
        while (loop.equals("Y")) {
            System.out.print("Enter a number: ");
            Scanner keyboard = new Scanner(System.in);

            int n = keyboard.nextInt();
            String junk = keyboard.nextLine();
            System.out.print(n + "! --> " + n + " * ");

            int n1 = n;
            while (n > 1) {
                n--;
                n1 *= n;

                if (n > 1) {
                    System.out.print(n + " * ");
                } else {
                    System.out.print(n);
                }
            }

            System.out.println(" --> " + n1);
            System.out.print("Try again? (Y/N) ");

            boolean again = true;
            while (again) {
                String user = keyboard.next();
                if (user.equals("N")) {
                    again = false;
                    loop = user;
                    break;
                } else if (user.equals(loop)) {
                    again = false;
                    break;
                } else {
                    System.out.println("Invalid input.");
                    System.out.print("Try again? (Y/N) ");
                }
            }
        }
        System.out.println("Bye.");
    }
}
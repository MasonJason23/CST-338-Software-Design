/*
Title: SquareRoot.java
Abstract: This program approximates the positive square root of a whole number provided by the user.
Author: Jason Casareno
Date: 9/5/2021
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println("This program estimates square roots.");
        System.out.println("Please enter a whole number:");

        Scanner k = new Scanner(System.in);
        boolean loop = false;
        int wholeNumber = 0;
        while (!loop) {
            try {
                wholeNumber = k.nextInt();
                k.nextLine();
                loop = true;
            } catch (InputMismatchException e) {
                k.nextLine();
                System.out.println();
                System.out.println("Please enter a whole number (no words, just numbers):");
            }
        }

        double stopGuess = 0.01;
        double x = wholeNumber;
        x /= 2;
        System.out.printf("Initial guess: %.2f\n", x);

        int guess = 2;
        loop = false;
        while (!loop) {
            System.out.print("Guess " + guess + ": ");
            double nextX = (x + (wholeNumber / x)) / 2;
            System.out.printf("%.6f\n", nextX);
            if (((x - nextX)/x) < stopGuess) {
                loop = true;
            }
            guess++;
            x = nextX;
        }

        System.out.println();
        System.out.printf("The estimated square root of " + wholeNumber + " is %.2f\n", x);
    }
}

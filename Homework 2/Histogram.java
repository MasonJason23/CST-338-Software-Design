/*
Title: Histogram.java
Abstract: This program displays a list of distinct numbers in the input and the occurrence of each distinct value.
    In addition, the program draws a vertical bar for the number occurrences using an asterisk for each value (0-9).
Author: Jason Casareno
Date: 9/2/2021
*/

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many input values [occurrence: 30]?");
        int num = input.nextInt();
        String junk = input.nextLine();
        System.out.println();

        System.out.println("Enter " + num + " numbers.");
        int x = 0; int max = 10;
        int[] array = new int[max];
        while (x < num) {
            int temp = input.nextInt();
            array[temp]++;
            junk = input.nextLine();
            x++;
        }

        System.out.println();
        System.out.println("Number      Occurrence");
        x = 0;
        while (x < num) {
            if (array[x] > 0) {
                System.out.println(x + "           " + array[x]);
                x++;
            } else {
                x++;
                continue;
            }
        }

        System.out.println();
        System.out.println("========= Vertical Bar ========");
        x = 0;
        int occurrence = 0;
        while (x < 10) {
            if (array[x] > occurrence) {
                occurrence = array[x];
            }
            x++;
        }

        x = 0;
        while (x < occurrence) {
            System.out.print("| " + occurrence + " |");
            System.out.print("  ");

            int a = 0;
            while (a < max) {
                if (array[a] == occurrence) {
                    System.out.print("* ");
                    array[a]--;
                } else {
                    System.out.print("  ");
                }
                a++;
            }

            occurrence--;
            System.out.println();
        }

        System.out.println("===============================");
        System.out.println("| No | 0 1 2 3 4 5 6 7 8 9");
        System.out.println("===============================");
    }
}

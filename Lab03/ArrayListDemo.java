package Lab03;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {

        // Create an ArrayList class with a String BaseType
        ArrayList<String> toDoList = new ArrayList<String>(20);

        System.out.println("Enter list entries, when prompted.");
        boolean done = false;
        String next = null;
        String answer;
        Scanner keyboard = new Scanner(System.in);
        while (! done) {
            System.out.println("Input an entry:");
            next = keyboard.nextLine();
            toDoList.add(next); // add() method for ArrayList class
            System.out.print("More items for the list? (y/n)");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                done = true;
            }
        }
        System.out.println("The list contains:");
        // for-each loop (enhanced for-loop)
        for (String entry : toDoList) {
            System.out.println(entry);
        }
    }
}
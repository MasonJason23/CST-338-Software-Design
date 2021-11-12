package Lab03;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {

    public static class Employee {
        private int ID;
        private String name;

        public Employee(int ID, String name) {
            this.ID = ID;
            this.name = name;
        }

        public int getID() { return this.ID; }

        public String getName() { return this.name; }
    }

//    @Override
//    public boolean equals(Object obj) {
//        // checks if the passed object is of type Toy
//        if (obj instanceof Employee) {
//            // (casts the passed in object as Toy)
//            Employee other = (Employee) obj;
//            // compares the two Toy objects
//            return ((this.ID == other.ID) && (this.name.equals(other.name)));
//        } else {
//            return false;
//        }
//    }

    public static void main(String[] args) {

        ArrayList<Employee> employeeList = new ArrayList<Employee> ();

        System.out.println("Enter list entries, when prompted.");
        boolean addEmployee = false;
        String junk;

        Scanner keyboard = new Scanner(System.in);
        while (! addEmployee) {
            String nextName = null;
            int nextID = 0;
            String answer;

            System.out.print("Input an ID number: ");
            nextID = keyboard.nextInt();
            junk = keyboard.nextLine();

            System.out.print("Input a name: ");
            nextName = keyboard.nextLine();

            Employee worker = new Employee(nextID, nextName);
            employeeList.add(worker);

            System.out.print("More items for the list? (y/n) ");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                addEmployee = true;
            }
        }
        System.out.println("The list contains:");
        for (Employee placement : employeeList) {
            System.out.println(placement.getID() + " " + placement.getName());
        }
        System.out.println();

        System.out.println("Type the employee ID number and name to search");
        boolean search = false;
        while (! search) {
            int employeeID = 0;
            String employeeName = null;
            String answer;

            System.out.print("ID number: ");
            employeeID = keyboard.nextInt();
            junk = keyboard.nextLine();
            System.out.print("Name: ");
            employeeName = keyboard.nextLine();

            Employee worker = new Employee(employeeID, employeeName);

            boolean isEmployee = false;
            Employee checkWorker = new Employee(0, null);

            // Checks user input with employeeList (UNFINISHED!)
//            for (Employee placement : employeeList) {
//                if (placement.equals(worker)) {
//                    checkWorker = placement;
//                    isEmployee = true;
//                }
//            }
//            if (isEmployee) {
//                System.out.println(checkWorker.getID() + " " + checkWorker.getName() + " is an employee");
//            } else {
//                System.out.println(worker.getID() + " " + worker.getName() + " is not an employee");
//            }

            System.out.print("Another search? (y/n) ");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("y"))) {
                search = true;
            }
        }
    }
}

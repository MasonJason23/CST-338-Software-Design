/*
    Owner: Jason Jock Nava Casareno
    Title: VendingMachine.java
    Abstract: This program is a class that simulates an imaginary vending machine at CSUMB.
        A user can buy a bottle of water ($1.50), a coffee ($2.00),
        a bag of chips ($1.00), or a chocolate bar ($2.50) from the machine.
        Multiple items can be bought from the vending machine and user must
        only pay in cash. An administrator of the machine can reset/refill the machine.
    Date: 10-1-2021
 */

//import java.
import java.util.Scanner;

public class VendingMachine {
    private int serialNum; // aka. name
    private String location = "UNKNOWN"; // Location of vending machine in CSUMB.

    // Prices of each item.
    private double waterPrice = 1.50;
    private double coffeePrice = 2.00;
    private double chipsPrice = 1.00;
    private double chocolatePrice = 2.50;

    // Amount of each item in vending machine.
    private int water = 0;
    private int coffee = 0;
    private int chips = 0;
    private int chocolate = 0;

    // Used to queue items to buy.
    public int[] queueBuy = new int[4];

    // Counts items sold.
    private int waterSold = 0;
    private int coffeeSold = 0;
    private int chipsSold = 0;
    private int chocolateSold = 0;

    // Counts money returned (when making final payment) and total earnings (vending machine status).
    private double moneyReturned;
    private double totalEarning = 0.00;

    // Scanner to read user inputs and remove junk return inputs by user.
    Scanner keyboard = new Scanner(System.in);
    String junk;

    @Override
    public String toString() {
        return "Serial Number: " + serialNum +
                "\nLocation: " + location +
                "\nContents: " +
                "\n   Water: " + water +
                "\n   Coffee: " + coffee +
                "\n   Chips: " + chips +
                "\n   Chocolate: " + chocolate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendingMachine)) return false;
        VendingMachine that = (VendingMachine) o;
        return water == that.water && coffee == that.coffee && chips == that.chips && chocolate == that.chocolate;
    }

    // Constructors.
    public VendingMachine(int serialNum) {
        this.serialNum = serialNum;
    }
    public VendingMachine(int serialNum, String location) {
        this.serialNum = serialNum;
        this.location = location;
    }

    // Setters.
    public void setLocation(String location) { this.location = location; }
    public void setName(int name) { this.serialNum = name; }

    // Reset the machine with specified amount of item in vending machine.
    public void reset(int itemA, int itemB, int itemC, int itemD) {
        water = itemA;
        coffee = itemB;
        chips = itemC;
        chocolate = itemD;
    }

    // Adds more items (refill) to the vending machine
    public void addItems(int itemA, int itemB, int itemC, int itemD) {
        water += itemA;
        coffee += itemB;
        chips += itemC;
        chocolate += itemD;
    }

    // Displays vending machine menu.
    public void displayMenu() {
        System.out.println(
                        """
                        ===== Vending Machine Menu =====
                         1. Water............$1.50
                         2. Coffee...........$2.00
                         3. Chips............$1.00
                         4. Chocolate........$2.50
                        """
        );
    }

    // Asks user what item they would like to purchase and amount.
    // If valid, item and amount will be queued for purchase.
    public void buyItem() {
        boolean buy = true;
        System.out.print("Select an item number: ");
        int itemNum = keyboard.nextInt();
        System.out.print("How many do you want to buy? ");
        int itemAmount = keyboard.nextInt();

        if (itemNum == 1 && itemAmount > water) {
            System.out.println("Selection Failed. We don't have enough water.");
            buy = false;
        }
        else if (itemNum == 2 && itemAmount > coffee) {
            System.out.println("Selection Failed. We don't have enough coffee.");
            buy = false;
        }
        else if (itemNum == 3 && itemAmount > chips) {
            System.out.println("Selection Failed. We don't have enough chips.");
            buy = false;
        }
        else if (itemNum == 4 && itemAmount > chocolate) {
            System.out.println("Selection Failed. We don't have enough chocolate.");
            buy = false;
        }

        if (buy) {
            incQueueBuy(itemNum, itemAmount);
        }
    }

    // Same function as buyItem() but the user has made a predetermined decision
    // on what he/she wants to buy from the vending machine.
    public boolean buyItem(int itemNum, int amount) {
        boolean buy = true;

        System.out.println("Select an item number: " + itemNum +
                "\nHow many do you want to buy? " + amount);

        if (itemNum == 1 && amount > water) {
            System.out.println("Selection Failed. We don't have enough water.");
            buy = false;
        }
        else if (itemNum == 2 && amount > coffee) {
            System.out.println("Selection Failed. We don't have enough coffee.");
            buy = false;
        }
        else if (itemNum == 3 && amount > chips) {
            System.out.println("Selection Failed. We don't have enough chips.");
            buy = false;
        }
        else if (itemNum == 4 && amount > chocolate) {
            System.out.println("Selection Failed. We don't have enough chocolate.");
            buy = false;
        }

        if (buy) {
            incQueueBuy(itemNum, amount);
        }

        return buy;
    }

    // Prints out item name
    public String chooseString(int itemNum) {
        if (itemNum == 1) {
            return "Water";
        }
        else if (itemNum == 2) {
            return "Coffee";
        }
        else if (itemNum == 3) {
            return "Chips";
        }
        else if (itemNum == 4) {
            return "Chocolate";
        }

        return null;
    }

    // Returns an unwanted item before purchase and displays returned item
    public void returned(int itemNum, int amount) {
        decQueueBuy(itemNum, amount);
        System.out.println("You selected " + chooseString(itemNum) +
                ". Quantity: " + amount);
    }

    // Increases queue (of the item) amount if item is selected.
    // Removes amount (of the item) selected from vending machine.
    // Keeps track of amount (of the item) sold.
    public void incQueueBuy(int itemNum, int amount) {
        for (int x = 1; x < queueBuy.length+1; x++) {
            if (x == itemNum && x == 1) {
                queueBuy[x-1] += amount;
                water -= amount;
                waterSold += amount;
            }
            else if (x == itemNum && x == 2) {
                queueBuy[x-1] += amount;
                coffee -= amount;
                coffeeSold += amount;
            }
            else if (x == itemNum && x == 3) {
                queueBuy[x-1] += amount;
                chips -= amount;
                chipsSold += amount;
            }
            else if (x == itemNum && x == 4) {
                queueBuy[x-1] += amount;
                chocolate -= amount;
                chocolateSold += amount;
            }
        }
    }

    // Opposite function compared to incQueueBuy(...).
    // However, decQueueBuy(...) still keeps track of amount (of the item) sold.
    public void decQueueBuy(int itemNum, int amount) {
        for (int x = 1; x < queueBuy.length+1; x++) {
            if (x == itemNum && x == 1) {
                queueBuy[x-1] -= amount;
                water += amount;
                waterSold -= amount;
            }
            else if (x == itemNum && x == 2) {
                queueBuy[x-1] -= amount;
                coffee += amount;
                coffeeSold -= amount;
            }
            else if (x == itemNum && x == 3) {
                queueBuy[x-1] -= amount;
                chips += amount;
                chipsSold -= amount;
            }
            else if (x == itemNum && x == 4) {
                queueBuy[x-1] -= amount;
                chocolate += amount;
                chocolateSold -= amount;
            }
        }
    }

    // Reads amount user is paying to vending machine.
    public boolean payment() {
        System.out.print("Enter money amount: $");
        double cash = keyboard.nextDouble();
        boolean payment = calcPayment(cash);

        if (payment) {
            System.out.printf("Sufficient money. $%.2f returned", moneyReturned);
        } else {
            System.out.printf("Insufficient money. $%.2f returned\n", cash);
        }

        return payment;
    }

    // Returns money returns and evaluates totalEarning.
    public boolean calcPayment(double amount) {
        double total = curTotal();

        if (amount >= total) {
            moneyReturned = amount - (total + (total * 0.10));
            totalEarning += (total + (total * 0.10));
            return true;
        } else { return false; }
    }

    // Calculates items in queue and price to determine cost for purchasing.
    public double curTotal() {
        double total = 0.00;
        int tempI = 0;

        for (int x = 0; x < queueBuy.length; x++) {
            if (x == 0 && x == tempI) {
                total += waterPrice * queueBuy[x];
            }
            if (x == 1 && x == tempI) {
                total += coffeePrice * queueBuy[x];
            }
            if (x == 2 && x == tempI) {
                total += chipsPrice * queueBuy[x];
            }
            if (x == 3 && x == tempI) {
                total += chocolatePrice * queueBuy[x];
            }
            tempI++;
        }

//        total += (total * 0.10);
        return total;
    }

    // Displays receipt.
    public void displayReceipt() {
        double currentTotal = curTotal();
        int tempI = 0;


        for (int x = 0; x < queueBuy.length; x++) {
            if (queueBuy[x] > 0 && x == 0) {
                System.out.printf("\nWater: $%.2f X " + queueBuy[x] +
                        " = %.2f\n", waterPrice, (waterPrice * queueBuy[x]) );
            }
            if (queueBuy[x] > 0 && x == 1) {
                System.out.printf("\nCoffee: $%.2f X " + queueBuy[x] +
                        " = %.2f\n", coffeePrice, (coffeePrice * queueBuy[x]) );
            }
            if (queueBuy[x] > 0 && x == 2) {
                System.out.printf("\nChips: $%.2f X " + queueBuy[x] +
                        " = %.2f\n", chipsPrice, (chipsPrice * queueBuy[x]) );
            }
            if (queueBuy[x] > 0 && x == 3) {
                System.out.printf("Chocolate: $%.2f X " + queueBuy[x] +
                        " = %.2f\n", chocolatePrice, (chocolatePrice * queueBuy[x]) );
            }
            tempI++;
        }

        System.out.printf("Tax (10.0%%): %.2f\n", (currentTotal * 0.10));
        System.out.printf("Total: $%.2f\n",currentTotal);
    }

    // Displays status of vending machine.
    public void status() {
        System.out.printf(
                "Serial Number: " + serialNum +
                "\nLocation: " + location +
                "\nSold Items: " +
                "\n   Water: " + waterSold +
                "\n   Coffee: " + coffeeSold +
                "\n   Chips: " + chipsSold +
                "\n   Chocolate: " + chocolateSold +
                "\nCurrent Contents: " +
                "\n   Water: " + water +
                "\n   Coffee: " + coffee +
                "\n   Chips: " + chips +
                "\n   Chocolate: " + chocolate +
                "\nTotal Earnings: $%.2f\n", totalEarning
                );
    }
}

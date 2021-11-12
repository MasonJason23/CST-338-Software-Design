/*
    Title - Bank.java
    Abstract -  The bank class allows users to create and run their own imaginary bank.
                The class contains the name, total customers, total accounts, and bank balance.
                In addition, the bank class contains 3 array lists of 3 other classes which are
                Customer.java, Account.java, and Transaction.java.
    Date - October 14, 2021
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String name;
    private double totalBal;
    private int numCustomers;
    private int numAccounts;
    private ArrayList<Account> accounts = new ArrayList<Account>(30);
    private ArrayList<Customer> customers = new ArrayList<Customer>(30);
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>(100);

    Scanner inputStream = null;

    // PRIVATE METHODS
    // used to connect an account with a customer
    private boolean checkSSN(String SSN) {
        boolean flag = false;
        for (Customer cur : customers) {
            if (cur.getCustomerSSN().equals(SSN)) {
                flag = cur.setNumAccounts();
            }
        }
        return flag;
    }

    // returns account object based on given account number
    private Account getAcc(int accNum) {
        for (Account cur : accounts) {
            if (cur.getAccNum() == accNum) {
                return cur;
            }
        }
        return null;
    }

    // returns customer object based on given SSN
    private Customer getCus(String SSN) {
        for (Customer cur : customers) {
            if (cur.getCustomerSSN().equals(SSN)) {
                return cur;
            }
        }
        return null;
    }

    // PUBLIC METHODS
    // bank name
    public Bank(String name) { this.name = name; }

    // getters
    public String getName() { return this.name; }
    public int getNumCustomer() { return numCustomers; }
    public int getNumAccounts() { return numAccounts; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setNumCustomer(int numCustomer) { this.numCustomers = numCustomer; }
    public void setNumAccounts(int numAccounts) { this.numAccounts = numAccounts; }

    public void readData(String txtFile) {

        try {
            inputStream = new Scanner(new FileInputStream(txtFile));
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
            System.exit(0);
        }

        // number of Customers
        numCustomers = inputStream.nextInt();
        // swallow newline character
        inputStream.nextLine();
        for (int x = 0; x < numCustomers; x++) {
            // splits each line of text from a file into an array of strings
            // this allows easy initialization of variable the customer object
            String[] inputLine = inputStream.nextLine().split(",");
            Customer tempC = new Customer(); // temporary customer object

            tempC.setCustomerName(inputLine[0]);
            tempC.setCustomerAddress(inputLine[1]);

            int tempZip = Integer.parseInt(inputLine[2]); // str to int conversion
            tempC.setCustomerZip(tempZip);

            tempC.setCustomerSSN(inputLine[3]);

            customers.add(tempC); // temporary object added to array list
        }

        numAccounts = inputStream.nextInt();
        inputStream.nextLine();
        for (int x = 0; x < numAccounts; x++) {
            // same process done with the customers but now with accounts
            String[] inputLine = inputStream.nextLine().split(",");
            Account tempA = new Account(); // Temporary account object

            // checks SSN with customers because a customer must have an account
            if(!checkSSN(inputLine[0])) {
                break;
            }
            tempA.setAccountSSN(inputLine[0]);

            int tempNum = Integer.parseInt(inputLine[1]); // str to int conversion
            tempA.setAccNum(tempNum);

            int tempType = Integer.parseInt(inputLine[2]); // ^Ditto
            tempA.setAccType(tempType);

            float tempBal = Float.parseFloat(inputLine[3]); // str to float conversion
            tempA.setAccBal(tempBal);
            this.totalBal+= tempBal; // account balance added to bank's balance

            accounts.add(tempA); // temporary object added to array list
        }
    }

    // prints bank information
    public void bankInfo() {
        System.out.println("Bank Name: " + getName());
        System.out.println("Number of Customers: " + getNumCustomer());
        for (Customer cur : customers) {
            System.out.printf("     %s: %s\n", cur.getCustomerName(), cur.getCustomerSSN());
        }

        System.out.println("Number of Accounts: " + getNumAccounts());
        for (Account cur : accounts) {
            System.out.printf("     %d: $%.2f\n", cur.getAccNum(), cur.getAccBal());
        }
        System.out.printf("Total Balance: $%.2f\n", totalBal);
    }

    // prints account information based on given account number
    public void accountInfo(int accNum) {
        Account curAcc = getAcc(accNum);
        if(curAcc == null) {
            System.out.printf("Account (%d) does not exist.\n", accNum);
            return;
        }

        Customer curCus = getCus(curAcc.getAccountSSN());

        System.out.printf(" - Number: %d\n", curAcc.getAccNum());
        System.out.printf(" - %s\n", curAcc.getAccTypeName());
        System.out.printf(" - Balance: $%.2f\n", curAcc.getAccBal());
        System.out.printf(" - Customer: %s\n", curCus.getCustomerName());
    }

    // prints current time when this method is executed
    public String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

    // allows user to deposit money to an account based on given account number
    public void deposit(int accNum, double money) {
        Account curAcc = getAcc(accNum);

        curAcc.incrementBal(money);
        this.totalBal += money;

        String transactionStr =
                " - Account Number: " + accNum +
                ", Deposit ($" + money + ")," +
                currentTime();
        Transaction tempT = new Transaction();
        tempT.setProof(transactionStr);
        tempT.setAccNum(accNum);
        transactions.add(tempT);
    }

    // allows user to withdraw money from an account based on given account number
    public void withdraw(int accNum, double money) {
        Account curAcc = getAcc(accNum);

        curAcc.reduceBal(money);
        this.totalBal -= money;

        String transactionStr =
                " - Account Number: " + accNum +
                        ", Withdraw ($" + money + ")," +
                        currentTime();
        Transaction tempT = new Transaction();
        tempT.setProof(transactionStr);
        tempT.setAccNum(accNum);
        transactions.add(tempT);
    }

    // allows user to create a new account given SSN, account number, account type, and account balance
    public void newAccount(String SSN, int accNum, int accType, double accBal) {
        Customer tempCus = getCus(SSN);
        if (tempCus == null) {
            System.out.println("Account creation failed - Account must be associated with an existing customer");
            return;
        }

        for (Account cur : accounts) {
            if (cur.getAccType() == accType && cur.getAccountSSN().equals(SSN)) {
                System.out.printf("Account creation failed - %s (%s) already has a %s account\n",
                        tempCus.getCustomerName(), tempCus.getCustomerSSN(), cur.getAccTypeName());
                return;
            }
            if (cur.getAccNum() == accNum) {
                System.out.printf("Account creation failed - Account %d already exists\n", accNum);
                return;
            }
        }

        Account tempAcc = new Account();
        tempAcc.setAccountSSN(SSN);
        tempAcc.setAccNum(accNum);
        tempAcc.setAccType(accType);
        tempAcc.setAccBal(accBal);
        accounts.add(tempAcc);
        this.totalBal += accBal;
        this.numAccounts++;

        System.out.printf("Account creation - Number: %d, Customer: %s\n", accNum, tempCus.getCustomerName());
    }

    // allows user to close an account based on given account number
    public boolean closeAccount(int accNum) {
        Account curAcc = getAcc(accNum);

        if (curAcc == null) { return false; }
        this.totalBal -= curAcc.getAccBal();
        this.numAccounts--;
        accounts.remove(curAcc);

        String transactionStr =
                " - Account Number: " + accNum +
                        ", Account closed, " +
                        currentTime();
        Transaction tempT = new Transaction();
        tempT.setProof(transactionStr);
        tempT.setAccNum(accNum);
        transactions.add(tempT);

        return true;
    }

    // allows user to create a new customer given a name, address, zip code, and SSN
    public void newCustomer(String name, String address, int zip, String SSN) {
        for (Customer cur : customers) {
            if (cur.getCustomerSSN().equals(SSN)) {
                System.out.printf("%s is NOT added - Duplicated SSN.\n", name);
                return;
            }
            if (cur.getCustomerName().equals(name)) {
                System.out.printf("%s is NOT added - Duplicated name.\n", name);
                return;
            }
        }

        Customer tempCus = new Customer();
        tempCus.setCustomerName(name);
        tempCus.setCustomerAddress(address);
        tempCus.setCustomerZip(zip);
        tempCus.setCustomerSSN(SSN);
        customers.add(tempCus);
        this.numCustomers++;

        System.out.printf("%s is added.\n", name);
    }

    // prints customer information based on given last four digits of an existing SSN
    public void customerInfoWithSSN(int fourSSN) {
        for (Customer cur : customers) {
            String[] sectionsSSN = cur.getCustomerSSN().split("-");
            if (sectionsSSN[2].equals(String.valueOf(fourSSN))) {
                String refSSN = cur.getCustomerSSN();

                Customer tempCus = getCus(refSSN);

                System.out.println("Name:   " + tempCus.getCustomerName());
                System.out.println(tempCus.getCustomerAddress() + ", " + tempCus.getCustomerZip());
                System.out.println("SSN: " + tempCus.getCustomerSSN());
                boolean hasAcc = false;
                for (Account curr : accounts) {
                    if (curr.getAccountSSN().equals(tempCus.getCustomerSSN())) {
                        System.out.printf("%s (%d), $%.2f\n", curr.getAccTypeName(), curr.getAccNum(), curr.getAccBal());
                        hasAcc = true;
                    }
                }
                if (!hasAcc) {
                    System.out.printf("No account\n");
                }
            }
        }
    }

    // allows user to remove a customer based on given SSN
    public void removeCustomer(String SSN) {
        boolean flag = false;
        Customer removeCus = new Customer();
        Account[] removeAcc = new Account[2];
        int counted = 0;

        for (Customer cur : customers) {
            if (cur.getCustomerSSN().equals(SSN)) {
                for (Account curr : accounts) {
                    if (curr.getAccountSSN().equals(SSN)) {
                        removeAcc[counted] = curr;
                        if (counted < 1) {
                            counted++;
                        }
                    }
                }
                removeCus = cur;
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println("Customer remove failed. SSN does not exist.");
            return;
        } else {
            System.out.printf("Customer removed - SSN: %s, Customer: %s\n", SSN, removeCus.getCustomerName());
            for (int x = 0; x <= counted; x++) {
                if (removeAcc[x] == null) { continue; } // NEEDS WORK!!!!
                System.out.printf(" Account closed - Number: %d, Balance: $%.2f\n",
                        removeAcc[x].getAccNum(), removeAcc[x].getAccBal());
                this.numAccounts--;
                this.totalBal -= removeAcc[x].getAccBal();
                accounts.remove(removeAcc[x]);
            }
            customers.remove(removeCus);
            this.numCustomers--;
        }
    }

    // stores all transactions made with the bank
    public void transaction(int accNum) {
        boolean flag = false;
        for (Transaction cur : transactions) {
            if (cur.getAccNum() == accNum) {
                System.out.println(cur.getProof());
                flag = true;
            }
        }

        if (flag == false) {
            System.out.printf(" - No transaction for account %d\n", accNum);
            return;
        }
    }
}

/*
    Owner: Jason Jock Nava Casareno
    Title: Bank.java
    Abstract: This program consists of three classes: Bank.java, Account.java, and Customer.java
        A user can create and manage an imaginary banking system using this program.
        The user can also create accounts with their own designated name, social security number,
        and account number. However, only 4 accounts can be present in one bank.
        Users will be able to update accounts if any changes occur.
        Finally, users can read bank information and account information.
    Date: 10-1-2021
 */

public class Bank {
    private String name;
    private Account[] accounts = new Account[4];

    private static int track = 0;
    private static double balance;

    public Bank() {
        name = "UNKNOWN";
    }

    public Bank(String bankName) {
        name = bankName;
    }

    public String getBankName() { return name; }

    public int amountAcc() { return track; }

    public double getBalance() { return balance; }

    public boolean openAccount(String name, String address, int SSN, int accNum, int accType, double balance) {
        if (track > 4) {
            return false;
        }

        for (int x = 0; x < accounts.length; x++) {
            if (accounts[x] == null) {
                continue;
            }
            if (accounts[x].getAccNum() == accNum) {
                return false;
            }
            if (accounts[x].getCustomerSSN() == SSN) {
                return false;
            }
        }

        int tempI = 0;
        while(tempI < 4) {
            if (accounts[tempI] == null) {
                Account current = new Account();

                current.setAccNum(accNum);
                current.setAccType(accType);
                current.setCustomerName(name);
                current.setCustomerSSN(SSN);
                current.setCustomerAddress(address);
                current.setBalance(balance);

                accounts[tempI] = current;

                Bank.balance += current.getBalance();
                break;
            }
            tempI++;
        }

        track++;
        return true;
    }

    public boolean closeAccount(int accNum) {
        for (int x = 0; x < accounts.length; x++) {
            if (accounts[x] != null && accounts[x].getAccNum() == accNum) {
                Bank.balance -= accounts[x].getBalance();
                accounts[x] = null;
                track--;
                return true;
            }
        }

        return false;
    }

    public boolean accountInfo(int accNum) {
        for(int x = 0; x < accounts.length; x++) {
            if (accounts[x] != null && accounts[x].getAccNum() == accNum) {
                Account current = accounts[x];
                System.out.println("Account Info:   Account Number: " + accNum);

                if (current.getType() == 1) {
                    System.out.println("Checking Account");
                }
                else if (current.getType() == 2) {
                    System.out.println("Savings Account");
                } else {
                    System.out.println("Error Account");
                    return false;
                }

                System.out.printf("Balance: %.2f" + "\n", current.getBalance());
                System.out.println("\nCustomer:     " + current.getCustomerName() +
                        "\n" + current.getCustomerAddress() +
                        "\nSSN: " + current.getCustomerSSN());
                return true;
            }
        }

        return false;
    }

    public boolean updateBalance(int accNum, double balance) {
        for (int x = 0; x < accounts.length; x++) {
            if (accounts[x].getAccNum() == accNum) {
                Bank.balance -= accounts[x].getBalance();
                accounts[x].setBalance(balance);
                Bank.balance += accounts[x].getBalance();
                return true;
            }
        }

        return false;
    }

    public boolean updateAddress(int accNum, String address) {
        for (int x = 0; x < accounts.length; x++) {
            if (accounts[x] != null && accounts[x].getAccNum() == accNum) {
                accounts[x].setCustomerAddress(address);
                return true;
            }
        }

        return false;
    }

    public void bankInfo() {
        System.out.println("Bank Name: " + getBankName());
        System.out.println("Number of Accounts: " + amountAcc());
        for(int x = 0; x < accounts.length; x++) {
            if (accounts[x] != null) {
                Account current = accounts[x];
                System.out.printf("    " + current.getAccNum() +
                        ": $%.2f" + " - " + current.getCustomerName() +
                        ": " + current.getCustomerSSN() + "\n",
                        current.getBalance() );
            }
        }
        System.out.printf("Bank Total Balance: $%.2f\n", balance);
    }
}

/*
    Title - Account.java
    Abstract -  The account class contains information of an account associated with the bank.
                This class contains the account's number, type, balance, and SSN.
    Date - October 14, 2021
*/

public class Account {
    private int accNum;
    private int accType;
    private double accBal;
    private String accountSSN;

    // getters
    public int getAccNum() { return accNum; }
    public int getAccType() { return this.accType; }
    public double getAccBal() { return accBal; }
    public String getAccountSSN() { return accountSSN; }

    // setters
    public void setAccNum(int accNum) { this.accNum = accNum; }
    public void setAccType(int accType) { this.accType = accType; }
    public void setAccBal(double accBal) { this.accBal = accBal; }
    public void setAccountSSN(String accountSSN) { this.accountSSN = accountSSN; }

    // allows account deposits and withdraws
    public void reduceBal(double money) {
        this.accBal -= money;
    }
    public void incrementBal(double money) {
        this.accBal += money;
    }

    // returns a string based on account type
    public String getAccTypeName() {
        if(accType == 1) {
            return "Checking";
        } else if(accType == 2) {
            return "Savings";
        }
        else {
            return "Not Available";
        }
    }
}

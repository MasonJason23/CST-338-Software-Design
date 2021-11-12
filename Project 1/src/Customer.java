/*
    Title - Customer.java
    Abstract -  The customer class contains information of a customer associated with the bank.
                This class contains the customer's name, address, zip code, and SSN.
                In addition, it contains the number of accounts associated with the customer.
    Date - October 14, 2021
*/

public class Customer {
    private String customerName;
    private String customerAddress;
    private int customerZip;
    private String customerSSN;
    private int numAccounts = 0;

    // getters
    public String getCustomerName() { return customerName; }
    public String getCustomerAddress() { return customerAddress; }
    public int getCustomerZip() { return customerZip; }
    public String getCustomerSSN() { return customerSSN; }

    // setters
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }
    public void setCustomerZip(int customerZip) { this.customerZip = customerZip; }
    public void setCustomerSSN(String customerSSN) { this.customerSSN = customerSSN; }

    // checks to make sure a customer does not have more than 2 accounts
    public boolean setNumAccounts() {
        if (this.numAccounts < 2) {
            this.numAccounts++;
            return true;
        }
        return false;
    }
}

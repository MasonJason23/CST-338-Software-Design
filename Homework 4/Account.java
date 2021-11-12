public class Account {
    private int accNum;
    private int accType;
    private double balance;
    private Customer accountHolder = new Customer();

    public int getAccNum() { return accNum; }
    public double getBalance() { return balance; }
    public int getType() { return accType; }

    public void setAccNum(int accNum) { this.accNum = accNum; }
    public void setAccType(int accType) { this.accType = accType; }
    public void setBalance(double balance) { this.balance = balance; }

    public int getCustomerSSN() { return accountHolder.getSSN(); }
    public String getCustomerName() { return accountHolder.getName(); }
    public String getCustomerAddress() { return  accountHolder.getAddress(); }

    public void setCustomerName(String name) { accountHolder.setName(name);}
    public void setCustomerSSN(int SSN) { accountHolder.setSSN(SSN);}
    public void setCustomerAddress(String address) { accountHolder.setAddress(address);}
}

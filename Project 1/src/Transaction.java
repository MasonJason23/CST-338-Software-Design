/*
    Title - Transaction.java
    Abstract -  The transaction class contains information of all transactions
                associated with the bank.
                This class contains a String-type record of each transaction made within the bank.
                In addition, the transaction class contains an account number to associate a
                transaction with an account.
    Date - October 14, 2021
*/

public class Transaction {
    private int accNum;
    private String proof;

    // getters
    public int getAccNum() { return accNum; }
    public String getProof() { return proof; }

    // setters
    public void setProof(String proof) { this.proof = proof; }
    public void setAccNum(int accNum) { this.accNum = accNum; }
}

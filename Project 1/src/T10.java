// T10: Test withdraw(), deposit() and transaction().
public class T10 
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.newCustomer("BBB BBBB", "222 BBB Center", 22222, "222-22-2222");
    csumbBank.newAccount("222-22-2222", 2222, 2, 222.22);
    csumbBank.withdraw(2222, 222.22);
    csumbBank.deposit(2222, 200.0);
    
    System.out.println("\n\n===== ANSWER: 2 transactions (one withdraw and one deposit with time stamps) =====\n");
    csumbBank.transaction(2222);
    
    System.out.println("\n\n===== ANSWER: 2222, Saving, $200.00, BBB BBB =====\n");
    csumbBank.accountInfo(2222);
    System.out.println("");
  }
}

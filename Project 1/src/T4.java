// T4: Test newCustomer() and newAccount() without readData().
public class T4 
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.newCustomer("BBB BBBB", "222 BBB Center", 22222, "222-22-2222");
    csumbBank.newCustomer("AAA AAAA", "111 AAA Center", 11111, "111-11-1111");
    
    System.out.println("\n\n=============== ANSWER: Four new accounts, but four fails ===============\n");
    csumbBank.newAccount("111-11-1111", 1112, 1, 100.00);
    csumbBank.newAccount("111-11-1111", 1111, 2, 100.00);
    csumbBank.newAccount("111-11-1111", 7070, 1, 100.00);  // fail
    csumbBank.newAccount("222-22-2222", 1111, 1, 100.00);  // fail
    csumbBank.newAccount("222-22-2222", 2221, 1, 100.00);
    csumbBank.newAccount("222-22-2222", 2222, 2, 100.00); 
    csumbBank.newAccount("333-33-3333", 3331, 1, 100.00);  // fail
    csumbBank.newAccount("333-33-3333", 3332, 2, 100.00);  // fail
    
    System.out.println("\n\n===== ANSWER: 2 Customers, 4 Accounts, Total Balance ($400.00) =====\n");
    csumbBank.bankInfo();
    System.out.println("");
  }
}
// T3: Test newCustomer().
public class T3
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t3.txt");

    System.out.println("\n\n=============== ANSWER: Two Additions, Four Fails ===============\n");
    csumbBank.newCustomer("CCC CCCC", "333 CCC Center", 33333, "333-33-3333");
    csumbBank.newCustomer("CCC CCCC", "333 CCC Center", 33333, "333-33-3333");
    csumbBank.newCustomer("AAA AAAA", "111 AAA Center", 11111, "111-11-1111");
    csumbBank.newCustomer("CCC CCCC", "333 CCC Center", 33333, "333-33-3333");
    csumbBank.newCustomer("DDD DDDD", "444 DDD Center", 44444, "444-44-4444");
    csumbBank.newCustomer("EEE EEEE", "555 EEE Center", 55555, "222-22-2222");

    System.out.println("\n\n===== ANSWER: 4 Customers, Balance ($100.00) =====\n");
    csumbBank.bankInfo();
    System.out.println("");
  }
}

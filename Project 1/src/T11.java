// T11: Test with 29 accounts and 29 customers.
public class T11
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t11.txt");

    csumbBank.deposit (1000, 1.0);
    csumbBank.deposit (1002, 1.0);
    csumbBank.deposit (1004, 1.0);
    csumbBank.deposit (1006, 1.0);
    csumbBank.deposit (1008, 1.0);
    csumbBank.deposit (1010, 1.0);
    csumbBank.deposit (1012, 1.0);
    csumbBank.withdraw (1012, 1.0);
    csumbBank.withdraw (1010, 1.0);
    csumbBank.withdraw (1008, 1.0);
    csumbBank.withdraw (1006, 1.0);
    csumbBank.withdraw (1004, 1.0);
    csumbBank.withdraw (1002, 1.0);
    csumbBank.withdraw (1000, 1.0);

    System.out.println("\n\n===== ANSWER: 29 Accounts, 29 Customers, Total Balance ($29.00) =====\n");
    csumbBank.bankInfo();
    System.out.println("");
  }
}

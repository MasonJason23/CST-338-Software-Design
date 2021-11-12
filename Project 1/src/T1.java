// T1: Test with one account and one customer.
public class T1
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t1.txt");

    System.out.println("\n\n===== ANSWER: One Account, One Customer, Balance ($1111.11) =====\n");
    csumbBank.bankInfo();
    System.out.println("");
  }
}

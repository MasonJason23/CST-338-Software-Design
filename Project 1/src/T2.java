// T2: Test if transaction operation works.
public class T2
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t2.txt");

    System.out.println("\n\n===== ANSWER: No transaction for account 2000 =====\n");
    csumbBank.transaction(2000);

    csumbBank.closeAccount(2000);
    System.out.println("\n\n===== ANSWER: Account number 2000 closed, <<< Current Time should be displayed >>> =====\n");
    csumbBank.transaction(2000);

    System.out.println("");
  }
}

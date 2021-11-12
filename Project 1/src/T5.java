// T5: Test accountInfo().
public class T5
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t5.txt");
    csumbBank.newAccount("222-22-2222", 3000, 1, 100.00);
    csumbBank.newAccount("222-22-2222", 4000, 2, 100.00);

    System.out.println("\n\n=============== ANSWER: Two Successes (1000,4000), Two Fails (5000,7000) ===============\n");
    csumbBank.accountInfo(1000);
    csumbBank.accountInfo(5000);
    csumbBank.accountInfo(7000);
    csumbBank.accountInfo(4000);
  }
}

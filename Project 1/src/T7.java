// T7: Test closeAccount().
public class T7
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t7.txt");    

    System.out.println("\n\n=============== ANSWER: Should display \"Pass\" ===============\n");
    if(!csumbBank.closeAccount(7070))
    {
        System.out.println(" *** Pass ***\n");
    }
    else
    {
        System.out.println(" *** Error: Fail ***\n");
    }

    csumbBank.closeAccount(1000);
    csumbBank.closeAccount(2000);
    csumbBank.closeAccount(3000);

    System.out.println("\n===== ANSWER: 0 Accounts, 2 Customers, Balance ($0.00) =====\n");
    csumbBank.bankInfo();
  }
}

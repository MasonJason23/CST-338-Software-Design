// T8: Test removeCustomer().
public class T8
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t8.txt");    

    System.out.println("\n\n=============== ANSWER: Fail To Remove Customer (333-33-3333) ===============\n");
    csumbBank.removeCustomer("333-33-3333");


    System.out.println("\n\n\n=============== ANSWER: Remove Customer (111-11-1111) ===============\n");
    csumbBank.removeCustomer("111-11-1111");

    System.out.println("\n\n\n===== ANSWER: 1 Account, 1 Customer, Balance ($100.00) =====\n");
    csumbBank.bankInfo();
  }
}

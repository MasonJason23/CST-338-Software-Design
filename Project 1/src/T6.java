// T6: Test customerInfoWithSSN().
public class T6
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.readData("resources/t6.txt");    

    System.out.println("\n\n=============== ANSWER: One Customer ===============\n");
    csumbBank.customerInfoWithSSN(1111);

    System.out.println("\n\n\n=============== ANSWER: No Customer ===============\n");
    csumbBank.customerInfoWithSSN(3333);

    System.out.println("\n\n\n=============== ANSWER: Three Customers ===============\n");
    csumbBank.customerInfoWithSSN(2222);
  }
}

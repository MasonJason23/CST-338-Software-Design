// T9: Test several methods and transaction().
public class T9 
{
  public static void main(String[] args)
  {
    Bank csumbBank = new Bank("CSUMB");

    csumbBank.newCustomer("AAA AAAA", "111 AAA Center", 11111, "111-11-1111");
    csumbBank.newCustomer("CCC CCCC", "333 CCC Center", 33333, "333-33-3333");
    csumbBank.newCustomer("EEE EEEE", "555 EEE Center", 55555, "555-55-5555");
    
    csumbBank.newAccount("111-11-1111", 1111, 2, 100.00);
    csumbBank.newAccount("333-33-3333", 3333, 2, 100.00);  
    csumbBank.newAccount("555-55-5555", 5555, 2, 100.00); 
    
    System.out.println("\n\n\n=============== ANSWER: Remove Customer (111-11-1111) ===============\n");
    csumbBank.removeCustomer("111-11-1111");

    System.out.println("\n\n\n===== ANSWER: Account close transaction for 1111 =====\n");
    csumbBank.transaction(1111);
    
    System.out.println("\n\n\n=============== ANSWER: Remove Customers (333-33-3333, 555-55-5555) ===============\n");
    csumbBank.removeCustomer("333-33-3333");
    csumbBank.removeCustomer("555-55-5555");
    
    System.out.println("\n\n\n===== ANSWER: 0 Account, 0 Customer, Balance ($0.00) =====\n");
    csumbBank.bankInfo();
    
  }
}
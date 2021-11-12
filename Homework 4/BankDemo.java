public class BankDemo {
    public static void main(String[] args) {
        Bank csumbBank = new Bank("CSUMB");
        System.out.println("\n========== Three New Accounts ==========");
        csumbBank.openAccount("Tom Smith", "123 University Center 93955",
                77777, 1000, 1, 10.0);
        csumbBank.openAccount("Alice Smith", "123 University Center 93955",
                88888, 2000, 1, 50.25);
        csumbBank.openAccount("Joe Otter", "2440 Ocean Avenue 93900",
                99999, 3000, 2, 100.25);
        System.out.println("\n========== Bank Info ==========");
        csumbBank.bankInfo();
        System.out.println("\n========== Close Account ==========");
        System.out.println(csumbBank.closeAccount(1000));
        System.out.println(csumbBank.closeAccount(7000));
        System.out.println("========== Account Info ==========");
        csumbBank.accountInfo(2000);
        System.out.println(csumbBank.accountInfo(7000));
    }
}

public class WitterDemo {
    public static void main(String[] args) {

        Weet shakeWeet = new Weet("(7:^]", "William Shakespeare", "shakespeare", true);
        Weet fakeShakeWeet = new Weet("o_O", "Wilhelm Shakespeare", "fakeShake", false);
        Weet jadenWeet = new Weet(":-|", "Jaden Smith", "officialJaden", true);
        System.out.println("\n===== Welcome to Witter! =====\n");

        shakeWeet.setDate(new WitterDate("November", 1, 1611, 3, 37, true));

        String shakeText = "Our revels now are ended. These our actors,\n"
                + "As I foretold you, were all spirits and\n"
                + "Are melted into air, into thin air:\n"
                + "And, like the baseless fabric of this vision,\n"
                + "The cloud-capp'd towers, the gorgeous palaces,\n"
                + "The solemn temples, the great globe itself,\n"
                + "Ye, all which it inherit, shall dissolve...";


        shakeWeet.setWeet(shakeText);


        fakeShakeWeet.setDate(new WitterDate("November", 1, 1611, 6, 42, false));
        fakeShakeWeet.setWeet(shakeText);

        jadenWeet.setDate(new WitterDate("May", 1, 2013, 6, 23, false));
        jadenWeet.setWeet("How Can Mirrors Be Real If Our Eyes Aren't Real");

        fakeShakeWeet.plagiarismCheck(shakeWeet);
        jadenWeet.plagiarismCheck(shakeWeet);

        System.out.println(shakeWeet);
        System.out.println(fakeShakeWeet);
        System.out.println(jadenWeet);

        System.out.println("===== End of Witter feed =====\n");
        System.out.printf("Witter has shipped a total of %d weet(s)"
                + " and detected %d fake weet(s).%n", Weet.getNumWeets(), Weet.getNumFakeWeets());
    }
}

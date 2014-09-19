/**
 * Created by IntelliJ IDEA.
 * User: satish
 */

// TODO: convert to unit framework
public class SupermarketTest  {
    public static void main(String[] args) {
        Supermarket sm = new SupermarketImpl();

        // test case 1 -- should be converted to junit/testng test case
        if (sm.checkout("ABBACBBAB") != 240) {
            throw new RuntimeException("checkout amout is wrong");
        } else {
            System.out.println("Thanks for spending $240 at nike!");
        }

        // test case 1 -- should be converted to junit/testng test case
        if (sm.checkout("CBA") != 100) {
            throw new RuntimeException("checkout amout is wrong");
        } else {
            System.out.println("Thanks for shopping at nike!");
        }

    }
}

import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        CafeUtil appTest = new CafeUtil();
    /* 
        You will need add 1 line to this file to create an instance 
        of the CafeUtil class. 
        Hint: it will need to correspond with the variable name used below..
    */

        /* ============ App Test Cases ============= */
    
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(11));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        System.out.println("----- Display Menu Test-----");
        
        ArrayList<String> menu = new ArrayList<String>();
        ArrayList<Double> prices = new ArrayList<Double>();
        menu.add("drip coffee");
        prices.add(1.50);
        menu.add("cappuccino");
        prices.add(4.00);
        menu.add("latte");
        prices.add(4.50);
        menu.add("mocha");
        prices.add(3.50);
        appTest.displayMenu(menu,prices);
    
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }


        System.out.println("\n----- Price Chart Test-----");
        appTest.printPriceChart("Colombian Coffee Grounds", 15.0, 4);




    }


}

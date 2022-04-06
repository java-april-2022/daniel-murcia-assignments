import java.text.DecimalFormat;
import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int numWeeks){
        int sum = 0; 
        for (int i=1; i<=numWeeks; i++){
            sum += i; 
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems){
        double sum = 0;
        for (int i=0; i<4; i++){
            sum += lineItems[i];
        }
        return sum;
    }

    // public void displayMenu(ArrayList<String> menu){
    //     String coffee = menu.get(0);
    //     String cappuccino = menu.get(1);
    //     String latte = menu.get(2);
    //     String mocha = menu.get(3);
    //     System.out.println(coffee);
    //     System.out.println(cappuccino);
    //     System.out.println(latte);
    //     System.out.println(mocha);
    // }

    public void displayMenu(ArrayList<String> menu){
        for (int i=0; i<menu.size(); i++){
            System.out.printf("%s %s \n", i, menu.get(i));
        }
    }

    public boolean displayMenu(ArrayList<String> menu, ArrayList<Double> prices){
        DecimalFormat d = new DecimalFormat("'$'0.00");
        if (menu.size() != prices.size()){
            return false;
        }
        for (int i=0; i<menu.size(); i++){
            System.out.printf("%s %s -- %s \n", i, menu.get(i), d.format(prices.get(i)));
        }
        return true;
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s!\n", userName);
        System.out.printf("There are %d people in front of you.\n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }


    public void printPriceChart(String product, double price, int maxQuantity){
        DecimalFormat d = new DecimalFormat("'$'0.00");
        System.out.println(product);
        for (int i=1; i<=maxQuantity; i++){
            System.out.printf("%s - %s \n", i, (d.format((price * i) - (0.50*(i-1)))));
        }
    }
}


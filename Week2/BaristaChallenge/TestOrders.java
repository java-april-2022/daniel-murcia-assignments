import java.util.ArrayList;

public class TestOrders {
    public static void main(String [] args) {
        Order order1 = new Order();

        System.out.printf("\nPrinting order1 name: %s", order1.getName());

        Order order2 = new Order();

        System.out.printf("\nPrinting order2 name: %s", order2.getName());


        Order order3 = new Order("Danny");
        Order order4 = new Order("Natasha");
        Order order5 = new Order("Lianna");

        System.out.printf("\nPrinting order3 name: %s", order3.getName());
        System.out.printf("\nPrinting order4 name: %s", order4.getName());
        System.out.printf("\nPrinting order5 name: %s", order5.getName());


        Item item1 = new Item("drip coffee", 2.0); 
        Item item2 = new Item("latte", 4.0); 

        System.out.printf("\nPrinting item1: %s Price: %.2f\n", item1.getName(), item1.getPrice());


        System.out.printf("\nPrinting item2: %s Price: %.2f\n", item2.getName(), item2.getPrice());

        //Adding item: 
        order3.addItem(item1);
        order3.addItem(item2);


        System.out.println("\nDisplay Order:\n");
        order3.display();

        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.printf("Printing Order 3 total: %s \n", order3.getOrderTotal());

        System.out.println("Displaying Order 3:\n");
        order3.display();














        // // Instantiating 4 "Item" objects 
        // // & Assigning member variables. 

        // Item item1 = new Item();
        // item1.name = "mocha";
        // item1.price = 3.50;
        
        // Item item2 = new Item();
        // item2.name = "latte";
        // item2.price = 4.50;
        
        // Item item3 = new Item();
        // item3.name = "drip coffee";
        // item3.price = 3.00;

        // Item item4 = new Item();
        // item4.name = "cappuccino";
        // item4.price = 5.00;

        // // Instantiating 4 "Order" objects   
        // // & Assigning member variables. 

        // Order order1 = new Order();
        // order1.name = "Cindhuri";
        // order1.items.add(item4);
        // order1.total = item4.price;
        // order1.ready = true;

        // Order order2 = new Order();
        // order2.name = "Jimmy";
        // order2.items.add(item1);
        // order2.total = item1.price;
        // order2.ready = true;

        // Order order3 = new Order();
        // order3.name = "Noah";
        // order3.items.add(item4);
        // order3.total = item4.price;
    

        // Order order4 = new Order();
        // order4.name = "Sam";
        // order4.items.add(item2);
        // order4.items.add(item2);
        // order4.items.add(item2);
        // order4.total = item2.price;
        // order4.total += item2.price;
        // order4.total += item2.price;

        // System.out.println("Printing order total:");
        // order4.getOrderTotal(); 


        // //Printing out Order 1:
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);


        // //Printing out Order 2:
        // System.out.printf("Name: %s\n", order2.name);
        // System.out.printf("Total: %s\n", order2.total);
        // System.out.printf("Ready: %s\n", order2.ready);


        // //Printing out Order 3:
        // System.out.printf("Name: %s\n", order3.name);
        // System.out.printf("Total: %s\n", order3.total);
        // System.out.printf("Ready: %s\n", order3.ready);


        // //Printing out Order 4:
        // System.out.printf("Name: %s\n", order4.name);
        // System.out.printf("Total: %s\n", order4.total);
        // System.out.printf("Ready: %s\n", order4.ready);
    }
    
}
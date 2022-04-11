import java.util.ArrayList;
import java.text.DecimalFormat;

import javax.swing.text.html.FormView;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;


    public Order(){
        this.name = "Guest";
        ArrayList<Item> items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }


    public String getName() {
        return name;
    }
    public boolean getReady(){
        return ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    //Methods 
    public void addItem(Item Item){
        this.items.add(Item);
    }


    public String getStatusMessage(){
        if(this.ready == true){
            return "Your order is ready.\n";
        }
        else{
            return "Thank you for waiting. Your order will be ready soon.\n";
        }
    }

    public String getOrderTotal(){
        DecimalFormat d = new DecimalFormat("'$'0.00");
        int sum = 0; 
        // System.out.println("\nPrinting Total:");
        for (int i = 0; i < this.items.size(); i++) {
            // System.out.println(this.items.get(i).getPrice());
            sum += this.items.get(i).getPrice();
        }
        return d.format(sum);
    }

  
    public void display(){ 
        DecimalFormat d = new DecimalFormat("'$'0.00");
        System.out.printf("Customer Name: %s\n", this.getName());
        for (int i = 0; i < this.items.size(); i++) {
            System.out.printf("%s - %s\n", this.items.get(i).getName(), d.format(this.items.get(i).getPrice()));
        }
        System.out.printf("Total: %s\n", this.getOrderTotal());
    }

}

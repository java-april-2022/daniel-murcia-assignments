import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean ready;
    //When instantiating an ArrayList, use the "new" keyword to initialize + create an empty array:
    public ArrayList<Item> items = new ArrayList<Item>();
}

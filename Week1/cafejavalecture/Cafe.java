import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Cafe {
    
    public void chaiLatte() {
        System.out.println("welcome, here is your chailatte");
    }
    public void americano(String name) {
        System.out.printf("welcome, %s , here is your chailatte", name);
    }
    //Array

    public void buildMenu () {
        String [] menu={ "chai", "hot chocolate", "frappuccino"};
        System.out.println(menu[0]);
        System.out.println(menu);
        System.out.println(Arrays.toString(menu));
        int[] numbers=new int[5];
        numbers[0]=10;
        numbers[1]=20;
        //Exception Handling: 
        // you can try risky code without it breaking: 
        try{
        numbers[6]=90;
        }
        //If the following exception happens, you can make it print a message of your choice: 
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Hey, you need more work on arrays!");
        }
        System.out.println(Arrays.toString(numbers));
    
    }
    public void customerList(){
        ArrayList<String> customers = new ArrayList<>();
        //push 
        customers.add("Sarah");
        customers.add("Diana");
        customers.add("Jamal");
        customers.add("Reena");
        //pop
        customers.remove("Reena");
        System.out.println(customers);
        System.out.println(customers.get(2));
        System.out.println(customers.size());

    }
    
    public void customerFavorites(){
        HashMap<String, String> favorites=new HashMap<String,String>();
        favorites.put("Reena", "Green Tea");
        favorites.put("Josh", "Oolong Tea");
        favorites.put("Alex", "Espresso");
        favorites.put("Herlan", "Passion Fruit");
        favorites.put("Diana", "Lemonade");

        //Use the key to get its corresponding value. 
        System.out.println(favorites.get("Josh"));
        System.out.println("Number of favorite drinks in cafe: " + favorites.size());
        //Will print out key value pairs, but notice Hashmaps are stored *unordered*. So you cannot call an item by its index#. You must call it by getting its key. 
        System.out.println(favorites);


        for(String key : favorites.keySet()) {
            System.out.printf("%s's favorite drink in Cafe is %s\n", key, favorites.get(key));
        }

    }


}

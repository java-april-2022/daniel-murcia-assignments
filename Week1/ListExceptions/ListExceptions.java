import java.util.ArrayList;

public class ListExceptions {
    
    public void listExceptions(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for (int i = 0; i < myList.size(); i++) {
            System.out.printf("Index Number: %s\n", i);
            System.out.printf("Object Value: %s\n", myList.get(i));
            try{
                Integer castedValue = (Integer) myList.get(i);
            }
            catch(Exception e){
                System.out.println("Error: Cannot Cast String to Integer!\n");
            }
        }
    }
}

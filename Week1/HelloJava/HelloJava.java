public class HelloJava {
    


    public static void main(String[] args) {
        System.out.println("Hello Team Java!");
        
        //Primitive Types 
        byte myAge=80;
        int myInt=527253725;
        long myLong= 67674676767l; //often used as primary key in db, needs l at the end. 
        float myFloat = 160.89f; //floats need f at the end to distinguish from a double 
        Double myDouble=180.7348738473;

        //Non-Primitive Types - Objects 
        String student="Richard";
        System.out.println("Hello Welcome to Java, " + student.toUpperCase());  //this is an object with lots of functionality tied to it. typing a dot next to it pulls up all the functionalities as suggestions. 
        System.out.println(student.length());
        greet();
        greet("Danny");
        greet("Josh", "Data Science");
        System.out.println(evenOdd(130));
        System.out.println(evenOdd(131));
        oneTo255();
    }

    public static void greet() {
        System.out.println("Hello, welcome to Coding Dojo!");
    }

    public static void greet(String studentName) {
        System.out.println("Welcome to Coding Dojo " + studentName );
    }

    public static void greet(String studentName, String stack) {
        System.out.printf("Welcome to Coding Dojo %s To %s, this is gonna be fun!", studentName, stack );
    }

    public static String evenOdd(int number) {
        if (number%2 == 0){
            return String.format("\n%d is even", number); //%d for numbers, %s for strings. \n creates a new line. 

        }
        else {
            return String.format("%d is odd", number);
        }
    }

    //LOOPS
    public static void oneTo255() {
        for (int i=1; i<=255; i++){
            System.out.println(evenOdd(i)); // Using a previous method here allows us to be more DRY. as opposed to writing if statements to find odd and even numbers within this method. 
        }
    }
}

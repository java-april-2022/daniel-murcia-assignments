import java.util.ArrayList;

public class Employee {
    //Access modifiers - Abstraction
    // Class Attributes 
    
    private String email; 
    private float pay;
    private ArrayList<String> skillSet = new ArrayList<>();

    //Constructors 
    public Employee (){
        //noOfEmps increments automatically in both constructors. 
        noOfEmployees++;
    }

    public Employee(String email, float pay){
        this.email=email;
        this.pay=pay;
        noOfEmployees++;
    }

    //Class Method -- only belongs to class, not to individual objects. 
    public void employeeDetails(){
        System.out.println("*****************************");
        System.out.printf("Emp email: %s\n", this.email);
        System.out.printf("Emp pay: %.2f\n", this.pay);
        try{
            for (String skill : this.skillSet) {
                System.out.println(skill);
            }
        }
        catch(Exception e) {
            // Handle exception 
        }
        
    }

    public void addSkill(String newSkill) {
        this.skillSet.add(newSkill);
    }

     // Static Method -- belongs to the class 
    private static int noOfEmployees;


    public static int getNoOfEmployees(){
        return noOfEmployees;
    }

    //Accessors/Getter/Setters
    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }


    public void setPay(float pay) {
        this.pay = pay;
    }


    public float getPay() {
        return pay;
    }


    public void setSkillSet(ArrayList<String> skillSet) {
        this.skillSet = skillSet;
    }

    public ArrayList<String> getSkillSet() {
        return skillSet;
    }

    //Polymorphism - method overloading: 

    // Let's create a bonus method that increments someone's pay. 
    public void bonus(){
        this.pay+= 200;
    }

    //Now we can specify bonus ~amount~ with parameter: 
    public void bonus(float amt){
        this.pay+= amt; 
    }


}

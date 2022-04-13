import java.util.ArrayList;

public class TestEmployee {
    public static void main(String[] args) {
        Employee paige = new Employee();
        //Using parametrized constructor: 
        Employee sam = new Employee("sam@myCafe.com", 210000);
        // paige.email = "paige.myCafe.com";
        // paige.pay= 200000;

        Employee taro = new Employee("taro@myCafe.com", 300000);


        paige.setEmail("paige.myCafe.com");
        paige.setPay(200000);
        System.out.println(paige.getEmail());

        paige.employeeDetails();
        sam.employeeDetails();

        System.out.println("No of Employees " + Employee.getNoOfEmployees());

        paige.bonus();
        // taro.bonus(1000);

        float amount = (float) taro.getPay()*.1f; 
        taro.bonus(amount);

        paige.employeeDetails();
        taro.employeeDetails();

        //Create a new Arraylist with the individual employee's skills 
        ArrayList<String> samSkills = new ArrayList<>();
        samSkills.add("Being Nice");
        samSkills.add("Making fancy coffee");
        samSkills.add("Quickness");
        samSkills.add("Bilingual");

        sam.setSkillSet(samSkills);

        sam.employeeDetails();

        paige.addSkill("Latte Art");
        paige.employeeDetails();

    }


    
}

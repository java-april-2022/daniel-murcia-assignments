import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        return "Hello, " + name + ". Lovely to see you.";
    }

    // OVERLOADING GUEST GREETING METHOD: 
    public String guestGreeting(String name, String dayPeriod) {
        // return "Good " + dayPeriod " , " + name + ". Lovely to see you.";
        return String.format("Good %s, %s.", "evening", "Beth");
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        return String.format("It is currently %s.", strDate);
    }
    

    public String respondBeforeAlexis(String conversation) {
        int a = conversation.indexOf("Alexis"); // if alexis is found, value of a will be 0 or greater. 
        int b = conversation.indexOf("Alfred"); // if alfred is found, value of b will be 0 or greater. 

        if (a >= 0) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (b >= 0) {
            return "At your service. As you wish, naturally.";
        }
        else {
            return "Right. And with that I shall retire.";
        }
    }



    public String yell(String whining) {
        int a = whining.indexOf("tired"); // if tired is found, value of a will be 0 or greater. 
        int b = whining.indexOf("catwoman"); // if catwoman is found, value of b will be 0 or greater. 

        if (a >= 0) {
            return "Batman can't afford to be lazy tonight! Off you go!";
        }
        else if (b >= 0) {
            return "With all due respect sir, you really are better off without such slimy company!";
        }
        else {
            return "Master Bruce, you must answer the batcall!";
        }
    }
}


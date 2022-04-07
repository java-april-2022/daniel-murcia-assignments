import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls(){
        //Instantiate an object of Random, called rand: 
        Random rand = new Random();
        //Instantiate an ArrayList:
        ArrayList<Integer>myArray = new ArrayList<Integer>();
        //Loop thru 10 indices, each time add a random integer from 0-20. 
        for (int i = 0; i<10; i++) {
            myArray.add(rand.nextInt(19)+1);
        }
        return myArray;
    }

    public String getRandomLetter(){
        String[] myArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        Random rand = new Random();
        int random_index = rand.nextInt(25);
        String random_letter = myArray[random_index];
        return random_letter;
    }


    public String generatePassword(){
        ArrayList<String> randomCharacters = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            randomCharacters.add(getRandomLetter());
        }
        String str = String.join("", randomCharacters);
        return str;
    }


    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> arrayEight = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arrayEight.add(generatePassword());
        }
        return arrayEight;
    }

}

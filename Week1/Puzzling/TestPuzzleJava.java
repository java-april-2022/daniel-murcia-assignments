import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();

        //GET ARRAY OF 10 RANDOM INTEGERS: 
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		

		// GET RANDOM LETTER:
        System.out.printf("The random letter is %s.\n", generator.getRandomLetter().toUpperCase());


		//GENERATE PASSWORD:
        System.out.printf("The randomly generated password is: %s.\n", (generator.generatePassword()));

		//GET NEW PASSWORD SET:
        System.out.printf("The randomly generated passwords are: %s.\n", (generator.getNewPasswordSet(4)));
	}
}

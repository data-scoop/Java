/*

Think you have ESP? Test your theory on the computer.
The computer will generate 10 random color choices from among a set, 
and the user is prompted to identify the color chosen before it is revealed to them.

*/

import javax.swing.JOptionPane;
import java.util.Random;
public class ESPTester {
	public static void main(String[] args) {
		String computerInput = "";
		String userInput = "";
		int intMatches = 0;
		// Print column headers
		System.out.print("ESP Game\n\nUser\tComputer\n----\t--------");
		for (int i = 0; i<10; i++) {
			// Get random color, get user input, display both, accumulate matches
			computerInput = getRandomColorString().toUpperCase();
			userInput = getUserInput().toUpperCase();
			System.out.print("\n" + userInput + "\t" + computerInput);
			if (userInput.matches(computerInput)) {
				intMatches++;
				System.out.print("\t< "+ intMatches);
			}
		}
		System.out.println("\n\nYou matched the computer's color " + intMatches + " times");
	} // End main()

	
	// Ask the computer for string
	public static String getRandomColorString() {
		int rNbr;
		String[] strArrColors = {"Red", "Green", "Blue", "Orange", "Yellow"};
		Random randomObject = new Random();
		rNbr = randomObject.nextInt(5);
        return strArrColors[rNbr];
	} // End getRandomColorString()
	
	
	// Ask the user for string
	public static String getUserInput(){
		String inputString;
		inputString = JOptionPane.showInputDialog("Input a color, from among the following:\n\nRed, Green, Blue, Orange, Yellow");
		return inputString;
	} // End getUserInput()

	
} // End ESPTester {}

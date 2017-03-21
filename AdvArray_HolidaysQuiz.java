/*

This file generates a quiz, an pits Player I vs Player II
The ten stock questions are randomly sequentialized, and assigned to each player.
Player I answers five questions -- then Player II answers five.
The scores are recorded and results rendered.

*/

import javax.swing.JOptionPane;
import java.util.*;
public class AdvArray_HolidaysQuiz {
	public static void main(String[] args) {
		// Test prep
		String[] answers = { "November", "November", "September", "January", "May", "January", "July", "February", "November", "November" };
		String[] questions = {
				"In what month is All Saints Day?",				// November	[10]
				"In what month is Election Day?",				// November	[10]
				"In what month is Labor Day?",					// September [9]
				"In what month is Martin Luther King Jr. Day?", // January	 [0]
				"In what month is Memorial Day?",				// May		 [4]
				"In what month is New Year's Day?",				// January	 [0]
				"In what month is Independence Day?",			// July		 [6]
				"In what month is President's Day?",			// February	 [1]
				"In what month is Thanksgiving?",				// November	[10]
				"In what month is Veterans Day?"				// November	[10]
		};
		
		// Create array "sequence" and preset all values to -1
		int i; int[] sequence = new int[10]; 
        for (i=0; i<10;i++){ sequence[i]=-1; }
        
        // Add digits 0-9 to "sequence",* in random order
		i = 0; int cRndNbr = -1;
		while (i < 10) { 
			cRndNbr = getRndInt(10);
			// If there was no case of cRndNbr in sequence, add it, and increment i one step
		    if (!checkIntPile(sequence, 10, cRndNbr)==true){ sequence[i] = cRndNbr; ++i;}
		    else {}	// cRndNbr is already in sequence
		}
		
		// Option list with prepended Answer index
		String[] options;
		
		// The entire array of questions
		Question[] TriviaQuestions = new Question[10];
		
		// Iterate through preset sequence, set to Questions objects
		for (int n : sequence) {
			
			// Knowing the answer text, make an array of four options
			options = getOptions(answers[n]);
			
			// Create a new Question object
			Question Q = new Question();
			
			// Set Question properties
			Q.setQuestionText(questions[n]);  
			Q.setOption1Text(options[1]);
			Q.setOption2Text(options[2]);
			Q.setOption3Text(options[3]);
			Q.setOption4Text(options[4]+"\n\n"+"Input the number (1, 2, 3, 4) that corresponds to your answer            ");

			// Convert String value at index 0, to an int and add 1; use as correct answer option number
			int intAnswerOptionIndex = Integer.parseInt(options[0])+1; 
			Q.setAnswerOptionIndex(intAnswerOptionIndex);
			
			// Now, get that very value, convert to integer, use as answer option index number
			int intAnswIndx = Integer.parseInt(Q.getAnswerOptionIndex());
			
			// Add Question to test, aka String[] "TriviaQuestions"
			TriviaQuestions[n] = Q;
		}
		
		// Test ready ... 
		
		// I know it's ugly and repeats. No time to re-factor
		
		int p1 = 0;
		System.out.println("Player One, begin.");
		for (int q=0; q<5; q++) {
			
			// Get this question's properties
			String qText = TriviaQuestions[sequence[q]].getQuestionText();
			String qOpt1Txt = TriviaQuestions[sequence[q]].getOption1Text();
			String qOpt2Txt = TriviaQuestions[sequence[q]].getOption2Text();
			String qOpt3Txt = TriviaQuestions[sequence[q]].getOption3Text();
			String qOpt4Txt = TriviaQuestions[sequence[q]].getOption4Text();
			String qAnswOptnIndx = TriviaQuestions[sequence[q]].getAnswerOptionIndex();
			
			// Get the user input
			String inputString;
			inputString = JOptionPane.showInputDialog("Player One : Question " + (q+1) + "\n\n" + qText + "\n1) " + qOpt1Txt  + 
					"\n2) " + qOpt2Txt  + "\n3) " + qOpt3Txt  + "\n4) " + qOpt4Txt );

			// Convert answer index and user input to integers, so as to compare
			int inputInt = Integer.parseInt(inputString);
			int optionInt = Integer.parseInt(qAnswOptnIndx);
			
			// If the user input the correct answer
			if (optionInt == inputInt){
				p1++;
			}
			else {} // Wrong answer
		} 
		int p2 = 0;
		System.out.println("Player Two, begin.");
		for (int q=5; q<10; q++) {
			
			// Get this question's properties
			String qText = TriviaQuestions[sequence[q]].getQuestionText();
			String qOpt1Txt = TriviaQuestions[sequence[q]].getOption1Text();
			String qOpt2Txt = TriviaQuestions[sequence[q]].getOption2Text();
			String qOpt3Txt = TriviaQuestions[sequence[q]].getOption3Text();
			String qOpt4Txt = TriviaQuestions[sequence[q]].getOption4Text();
			String qAnswOptnIndx = TriviaQuestions[sequence[q]].getAnswerOptionIndex();
			
			// Get the user input
			String inputString;
			inputString = JOptionPane.showInputDialog("Player Two : Question " + (q-4) + "\n\n" + qText + "\n1) " + qOpt1Txt  + 
					"\n2) " + qOpt2Txt  + "\n3) " + qOpt3Txt  + "\n4) " + qOpt4Txt );

			// Convert answer index and user input to integers, so as to compare
			int inputInt = Integer.parseInt(inputString);
			int optionInt = Integer.parseInt(qAnswOptnIndx);
			
			// If the user input the correct answer
			if (optionInt == inputInt){
				p2++;
			}
			else {} // Wrong answer
		} 
		
		if (p1 == p2) {System.out.println("Players 1 & 2 have tied with " + p1 + " correct answers!");}
		else if (p1 > p2) {System.out.println("Players 1 wins; " + p1 + " to " + p2);}
		else if (p1 < p2) {System.out.println("Players 2 wins; " + p2 + " to " + p1);}
	} // End main()
	
	
	// Fetch a question indexing number. // For this fnct, "upperBound" is actually upperBound-1
	public static int getRndInt(int upperBound){
		Random randomNumber; 
		randomNumber = new Random(); 
		int z = randomNumber.nextInt(upperBound);
		return z;
	}
	
	// Is the number already in sequence? 
    public static boolean checkIntPile(int[] seq, int u, int z ) {
    	for (int i = 0; i<u; i++) {
    		if (seq[i] == z) { return true;}
    	}
    	return false;
    }
    
    // Is the number already in wrongOptions?? 
    public static boolean checkStringPile(String[] seq, int upperBound, String monthName ) {
    	for (int i = 0; i<upperBound; i++) {
    		if (seq[i] == monthName) { return true;}
    	}
    	return false;
    }
    
    // Get 4 wrong choices
    public static String[] getOptions(String strCorrectAnswer){
    	String[] wrongOptions = new String[4];
    	String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
    	int i = 0; 
    	
		// Iterate wrongOptions
		while (i < 4) { 
			// Use a random integer, 0-9, as index key to monthNames array
			String cRndMonth = monthNames[getRndInt(12)];
			
			// If there is NOT! a case of cRndMonth in wrongOptions
		    if (!checkStringPile(wrongOptions, 4, cRndMonth)==true){ wrongOptions[i] = cRndMonth; ++i;}
		    else {}	// cRndMonth is already in wrongOptions
		} // End while()
		
		int pos;
		for (i = 0; i < 4; i++) { 
			if (wrongOptions[i] == strCorrectAnswer) { // Correct answer text found; set position found
				pos = i; 
				return new String[] {Integer.toString(pos), wrongOptions[0], wrongOptions[1], wrongOptions[2], wrongOptions[3] };
			}
			else {} // Correct answer is not in this element
		} // Correct answer is not in wrongOptions array
		
		// Get a random integer to represent one of the wrongOptions
		pos = getRndInt(4);
		
		// Set that randomly chosen wrongOptions element's text to the correct answer's text
		wrongOptions[pos] = strCorrectAnswer;
		
		// Create the returned value: an array of 5 values
        // Index (0-3) of correct answer option, followed by four options, one of which is correct
		// ie: {3, March, December, June, November} : November is correct
    	return new String[] {Integer.toString(pos), wrongOptions[0], wrongOptions[1], wrongOptions[2], wrongOptions[3] };
    }
} // End Class

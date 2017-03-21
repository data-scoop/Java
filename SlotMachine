/*

This simple program simulates a slot machine.
The user wagers a sum, and the computer generates 3 random results, which are then output to console.
The user wins a prize equal to 2x their wager when two values match, and 3x when all three match.

*/

import java.util.Random;
import javax.swing.JOptionPane;
public class Lab4Q6 {

	public static void main(String[] args) {

		boolean sentinelStanley = true;
		int dollarsWagered = 0;
		int dollarsLost = 0;
		int dollarsWon = 0;
		
		int balance = 0;
		
		while (sentinelStanley == true)
		{			
		// Setup possible values
		String[] elements = {"[ Cherries ]", "[ Oranges ]", "[ Plums ]", "[ Bells ]", "[ Melons ]", "[ Bars ]"};
		
		// Setup possible values
		String[] sayings = {"That'll put a cherry on top!", 
				"Orange you glad you played!", 
				"That's plum fantastic!", 
				"You rung the bell!", 
				"Oh, yes you cantaloups!", 
				"You broke open the vault!"};
		
		String inputString;
		inputString = JOptionPane.showInputDialog(" \nHow many dollars do you wish to wager?\n ");
		int inputWager;
		
		// Convert the input to an int.
		inputWager = Integer.parseInt(inputString);
		
		// Add debit to balance
		balance -= inputWager;
		
		// Sum of bets wagered, plus this bet
		dollarsWagered += inputWager;

		// Setup individual wheelspin results storage
		int[] wheelspins= {-1,-1,-1};
		String bonusMessage = "";
		
		// There are 6 possible values, indexed 0,1,2,3,4,5
		int randomIconIndex;
		
		// For each wheel in the slot machine calculation, display:
		for (int slots = 0; slots<3; slots++)
			{
				Random randomNumber = new Random();
				randomIconIndex = randomNumber.nextInt(6);
				wheelspins[slots] = randomIconIndex;
				
				// Print this wheel's spin result to screen
				System.out.print(elements[randomIconIndex]);
			}
		
		System.out.print("\n\tYou bet\t$"+inputWager);
		
		// Wheels #1, #2 & #3 match = All three same = 3x payout (Wheels aligned)
		if (wheelspins[0] == wheelspins[1] && wheelspins[0] == wheelspins[2]) {
			// Print this wheel's spin 3x payout
			bonusMessage="\t  3x BONUS\n\tYou won $" + (inputWager * 3) + "\n\t" + sayings[wheelspins[0]];
			balance += (inputWager * 3);
			dollarsWon += (inputWager * 3);}
		
		// Wheels #2 & #3 match = Two of three = 2x payout
		else if (wheelspins[1] == wheelspins[2])
		{bonusMessage = "\t  2x BONUS\n\tYou won $" + (inputWager * 2);
		balance += (inputWager * 2);
		dollarsWon += (inputWager * 2);}
		
		// Wheels #1 & #2 match = Two of three = 2x payout
		else if (wheelspins[0] == wheelspins[1] || wheelspins[0] == wheelspins[2])
		{bonusMessage = "\t  2x BONUS\n\tYou won $" + (inputWager * 2);
		balance += (inputWager * 2);
		dollarsWon += (inputWager * 2);}

		// No matches = 0x payout
		else {
			dollarsLost -= inputWager;
			bonusMessage="\t You won $0";}

		System.out.print("\n"+bonusMessage);
		System.out.print("\nPocket\tSlotted\tLost\tWon");
		System.out.print("\n$" + balance+"\t$"+dollarsWagered+"\t$"+dollarsLost+"\t$"+dollarsWon);
		System.out.print("\n -----------------------------------------\n");

		sentinelStanley = false;
		String strPlayAgain;
		strPlayAgain = JOptionPane.showInputDialog(" \nPlay Again? [Y / N]\n ");
		if (strPlayAgain.toCharArray()[0]=='y' || strPlayAgain.toCharArray()[0]=='Y'){sentinelStanley = true;}

		} // End While

		System.out.print(" -$----------------- ~ -----------------$-");
		System.out.print("\n\tYou wagered a total of $"+dollarsWagered+"\n\t  You won a total of $"+dollarsWon);
	} // End main()
} // End Lab4Q6

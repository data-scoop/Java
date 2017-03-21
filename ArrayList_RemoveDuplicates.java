/*

This program sets up three arrays containing some duplicated values. 
It then finds the duplicates and removes them, rendering a ArrayList of unique values

*/

import java.util.*;
public class ArrayList_RemoveDuplicates {

	public static void main(String[] args) {
		
		ArrayList<String> AL_TestA = new ArrayList<String>();
		AL_TestA.add("agua");		// Espanol	water
		AL_TestA.add("eau");		// French	water
		AL_TestA.add("gaseosa");	// Espanol	"soda pop"	? 
		AL_TestA.add("jugo");		// Espanol	juice
		AL_TestA.add("juice");
		AL_TestA.add("jus");		// French	juice
		AL_TestA.add("juisi");		// Swahili	juice
		AL_TestA.add("lait");		// French	milk
		AL_TestA.add("leche");		// Espanol
		AL_TestA.add("maji");		// Swahili	water
		AL_TestA.add("maziwa");		// Swahili	milk
		AL_TestA.add("milk");
		AL_TestA.add("mukaka");		// Shona	milk
		AL_TestA.add("mushaba");	// Shona	soda
		AL_TestA.add("muto");		// Shona	juice
		AL_TestA.add("mvura");		// Shona	water
		AL_TestA.add("pop");
		AL_TestA.add("pop");		// French	pop		<-- Repeat
		AL_TestA.add("pop");		// Shona	pop		<-- Repeat
		AL_TestA.add("pop");		// Swahili	pop		<-- Repeat
		AL_TestA.add("soda");
		AL_TestA.add("soda");		// French	soda	<-- Repeat
		AL_TestA.add("soda");		// Swahili	soda	<-- Repeat
		AL_TestA.add("water");
		
		ArrayList<String> AL_TestB = new ArrayList<String>();
		AL_TestB.add("Alberta");
		AL_TestB.add("British Columbia");
		AL_TestB.add("Manitoba");
		AL_TestB.add("Newfoundland");
		AL_TestB.add("Northwest Territory");
		AL_TestB.add("Nunavut");
		AL_TestB.add("Ontario");
		AL_TestB.add("Prince Edward Island");
		AL_TestB.add("Quebec");
		AL_TestB.add("Saskatchewan");
		AL_TestB.add("Alberta");		// <-- Repeat
		AL_TestB.add("Newfoundland");	// <-- Repeat
		AL_TestB.add("Ontario");		// <-- Repeat
		
		ArrayList<String> AL_TestC = new ArrayList<String>();
		AL_TestC.add("Achilles");
		AL_TestC.add("Achilles");		// <-- Repeat
		AL_TestC.add("Agamemnon");
		AL_TestC.add("Ajax");
		AL_TestC.add("Eumaeus");
		AL_TestC.add("Hector");
		AL_TestC.add("Nestor");
		AL_TestC.add("Odysseus");
		AL_TestC.add("Penelope");
		AL_TestC.add("Priam");
		AL_TestC.add("Telemachus");
		
		// Test AL_TestA, AL_TestB and AL_TestC
		System.out.println("Test A - Beverages "); removeDuplicates(AL_TestA);
		System.out.println("\n\n\nTest B - Provinces"); removeDuplicates(AL_TestB);
		System.out.println("\n\n\nTest C - The Odyssey"); removeDuplicates(AL_TestC);
	} 
  // End ArrayList_RemoveDuplicates{}
	
	
	public static void removeDuplicates(ArrayList<String> listOfItems) {
		// 
		String strOriginal = ""; String strReduced = "";
		
		// Create a similar, empty ArrayList<String>
		ArrayList<String> listOfItems_Reduced = new ArrayList<String>();
		
		// Loop through the populated ArrayList<String>. Build strOriginal with each value
		for (String value:listOfItems) { strOriginal+="[" + value + "] ";
			
			// If the new, 'reduced' ArrayList<String> doesn't contain the current, non-empty value ...
			if (listOfItems_Reduced.contains(value)==false && value != "") {

				// Add the given String to the 'reduced' ArrayList<String>. Build strReduced with each value
				listOfItems_Reduced.add(value); strReduced+="[" + value + "] ";
			} 
		}
		System.out.println("\n\tOriginal String\n\t" + strOriginal);
		System.out.println("\n\tReduced String\n\t" + strReduced);
		
	} // End removeDuplicates()
}

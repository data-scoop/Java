/*

This program transalates the letters in a user-provided phone number -- back into numbers.

*/

import javax.swing.JOptionPane;
public class Q3_Alphabetic_phone_number_translator {
	public static void main(String[] args) {
		
		// Acquire digits
		String s = JOptionPane.showInputDialog("Enter number to translate . . .").toUpperCase();
		
		// Echo user input
		System.out.println("Dial: "+ s);
		
		// Declare define dialpad
		String[] dialpad = {"[ABC]", "[DEF]", "[GHI]", "[JKL]", "[MNO]", "[PQRS]", "[TUV]", "[WXYZ]"};
		
		// dialpad "pattern" index, is the desired output integer, minus 2
		for (int pattern = 0; pattern<dialpad.length; pattern++){
			
			// Concatenation of +"" causes a needed cast to string
			s=s.replaceAll(dialpad[pattern], pattern+2+"");
		}
		
		// Echo replacement number
		System.out.print("Dial: " + s);
	}
}

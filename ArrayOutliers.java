/*

This program fills these arrays with random integers from 1-100.
It then compares the values in each array to a pre-defined pair of hardcoded, integer limits.
The program then counts how many values lie outside of the array's pre-defined range. 

*/

import java.util.Random;
public class ArrayOutliers {
	public static void main(String[] args) {
		
		// Hardcoded limits
		final int arr0_StartLimit =  0; final int arr0_EndLimit = 33;
		final int arr1_StartLimit = 34; final int arr1_EndLimit = 66;
		final int arr2_StartLimit = 67; final int arr2_EndLimit = 100;

		// Generate 3 ten-element arrays, random integers between 1-100
		int[] arr0 = new int[10]; int[] arr1 = new int[10]; int[] arr2 = new int[10]; 
		
		// Strings for printing results
		String strArr0 = "Array 0: { "; String strArr1 = "Array 1: { "; String strArr2 = "Array 2: { ";
				
		// Populate arrays randomly, and result printing strings, consequently
		Random randomNumber;
		for (int i = 0; i<10; i++) {
			randomNumber = new Random();
			arr0[i] = randomNumber.nextInt(100)+1; strArr0 += arr0[i] + " ";
			randomNumber = new Random();
			arr1[i] = randomNumber.nextInt(100)+1; strArr1 += arr1[i] + " ";
			randomNumber = new Random();
			arr2[i] = randomNumber.nextInt(100)+1; strArr2 += arr2[i] + " ";	
		}

		// The count of out of range values in each array  --------------------> // Limits
		int arr0Count = countOutOfRange(arr0, arr0_StartLimit, arr0_EndLimit); //  0,  33
		int arr1Count = countOutOfRange(arr1, arr1_StartLimit, arr1_EndLimit); // 34,  66
		int arr2Count = countOutOfRange(arr2, arr2_StartLimit, arr2_EndLimit); // 67, 100
		
		// The results strings are captioned with associated meta data
		strArr0 += "}\nStart: " + arr0_StartLimit + "\t  End: " + arr0_EndLimit + "\tOut of Range: " + arr0Count + "\n";
		strArr1 += "}\nStart: " + arr1_StartLimit + "\t  End: " + arr1_EndLimit + "\tOut of Range: " + arr1Count + "\n";
		strArr2 += "}\nStart: " + arr2_StartLimit + "\t  End: " + arr2_EndLimit + "\tOut of Range: " + arr2Count + "\n";
		
		// The results are printed
		System.out.println(strArr0);
		System.out.println(strArr1);
		System.out.println(strArr2);
	}
	
	// Returns a count of the number of range values, above or below the limit, inclusive
	public static int countOutOfRange(int[] inpArray, int valMin, int valMax) {
		int o = 0;
		for (int value:inpArray) {
			if (valMin > value  || valMax < value) {o++;}
			//System.out.println(value + " " + o);
		}
		return o;
	}
} // End ArrayOutliers{}

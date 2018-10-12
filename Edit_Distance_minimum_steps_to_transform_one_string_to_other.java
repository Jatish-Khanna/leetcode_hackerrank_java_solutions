class Solution {

	public static void main(String args[]) {
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println(editDist(str1, str2, str1.length(), str2.length()));
	}

	private static int editDist(String str1, String str2, int length, int length2) {
		int st1Length = str1.length();
		int st2Length = str2.length(); 
		// Dynamic programming solution
		int[][] dpSol = new int[st1Length + 1][st2Length + 1];

		// Loop each character of string 1 and string 2
		for (int indexSt1 = 0; indexSt1 <= st1Length; indexSt1++) {
			for (int indexSt2 = 0; indexSt2 <= st2Length; indexSt2++) {
				// For row = 0 where empty string is compared with second string
				if (indexSt1 == 0) {
					// Option is to insert characters of string#2
					dpSol[indexSt1][indexSt2] = indexSt2;
				} 
				// For column = 0 where string#2 is empty and compared with string#1
				else if (indexSt2 == 0) {
					// Option is to remove all the character from string#2
					dpSol[indexSt1][indexSt2] = indexSt1;
				} 
				   // Both string are non-empty
				else {
					// Character at this position is same 
					if (str1.charAt(indexSt1 - 1) == str2.charAt(indexSt2 - 1)) {
						
						// The string does not require any edit, store what we have done best
						dpSol[indexSt1][indexSt2] = dpSol[indexSt1 - 1][indexSt2 - 1];
					} else {
						// Characters does not match, value should be best of Replace, Add, remove
						dpSol[indexSt1][indexSt2] = Math.min(dpSol[indexSt1 - 1][indexSt2 - 1],
								Math.min(dpSol[indexSt1 - 1][indexSt2], dpSol[indexSt1][indexSt2 - 1])) + 1;
					}
				}
			}
		}

		// Return the edit distance for converting one string to other
		return dpSol[st1Length][st2Length];
	}
}

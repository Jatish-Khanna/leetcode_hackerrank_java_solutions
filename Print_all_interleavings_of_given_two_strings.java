class Solution {


	private static void printInterleavingString(char[] str1, char[] str2, int str1Length, int str2Length) {
		if ((str1 == null && str2 == null) || (str1Length == 0 && str2Length == 0)) {
			return;
		} else if (str1 == null || str1Length == 0) {
			System.out.println(str2.toString());
		} else if (str2 == null || str2Length == 0) {
			System.out.println(str1.toString());
		}

		char[] result = new char[str1Length + str2Length];
		printInterleavingStringUtil(result, str1, str2, 0, 0, 0);
	}

	private static void printInterleavingStringUtil(char[] result, char[] str1, char[] str2, int startStr1,
			int startStr2, int resultIndex) {

		if (startStr1 == str1.length && startStr2 == str2.length) {
			System.out.println(String.valueOf(result));
			return;
		}

		if (startStr1 < str1.length) {
			result[resultIndex] = str1[startStr1];
			printInterleavingStringUtil(result, str1, str2, startStr1 + 1, startStr2, resultIndex + 1);
		}

		if (startStr2 < str2.length) {
			result[resultIndex] = str2[startStr2];
			printInterleavingStringUtil(result, str1, str2, startStr1, startStr2 + 1, resultIndex + 1);
		}
	}

// Driver program to test above functions 
	public static void main(String[] args) {
		char str1[] = { 'A', 'B' };
		char str2[] = { 'C', 'D' };
		printInterleavingString(str1, str2, str1.length, str2.length);

	}

}

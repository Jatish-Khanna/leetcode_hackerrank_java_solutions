class Solution {


	private static boolean areEqual(int[] arr1, int[] arr2) {
		char[] dictionary = new char[256];

		if (arr1.length != arr2.length)
			return false;

		for (int index = 0; index < arr1.length; index++) {
			dictionary[arr1[index]]++;
		}

		for (int index = 0; index < arr2.length; index++) {
			dictionary[arr2[index]]--;
		}
		for (int index = 0; index < 256; index++) {
			if (dictionary[index] > 0)
				return false;
		}
		return true;
	}

	// Driver code
	public static void main(String[] args) {
		int arr1[] = { 3, 5, 2, 5, 2 };
		int arr2[] = { 2, 3, 5, 5, 1 };

		if (areEqual(arr1, arr2))
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}

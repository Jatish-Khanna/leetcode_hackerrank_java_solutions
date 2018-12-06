import java.util.HashSet;

class Solution {

	/**
	 * Find pair of element one from each set - totals to value - Element from First
	 * set can be part of multiple sets
	 * 
	 * @param arr1         first array
	 * @param arr2         second set
	 * @param firstLength
	 * @param secondLength
	 * @param sumToFind    - sum to find
	 */
	private static void findPairs(int arr1[], int[] arr2, int firstLength, int secondLength, int sumToFind) {
		HashSet<Integer> dictionary = new HashSet<>();

		for (int index = 0; index < firstLength; index++) {
			dictionary.add(arr1[index]);
		}

		for (int index = 0; index < secondLength; index++) {
			if (dictionary.contains(sumToFind - arr2[index])) {
				System.out.println("Pair - First: " + (sumToFind - arr2[index]) + " Second: " + arr2[index]);
			}
		}

	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr1[] = { 1, 0, -4, 7, 6, 4 };
		int arr2[] = { 0, 2, 4, -3, 2, 1 };
		int x = 8;

		findPairs(arr1, arr2, arr1.length, arr2.length, x);

	}

}

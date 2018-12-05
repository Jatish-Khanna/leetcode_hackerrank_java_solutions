import java.util.HashMap;

class Solution {


	private static int calculateSum(int[] arr) {
		int sum = 0;
		for (int index = 0; index < arr.length; index++) {
			sum += arr[index];
		}
		return sum;
	}

	private static void findSwapValues(int arr[], int firstLength, int arr2[], int secondLength) {
		int firstSum = calculateSum(arr);
		int secondSum = calculateSum(arr2);
		HashMap<Integer, Integer> dictionary = new HashMap<>();
		boolean hasFound = false;
		int findDiff = (firstSum - secondSum) / 2;

		for (int index = 0; index < arr.length; index++) {
			dictionary.put(arr[index] - findDiff, arr[index]);
		}

		for (int index = 0; index < arr2.length; index++) {
			if (dictionary.get(arr2[index] + findDiff) != null) {
				System.out.println(
						"Pair - First: " + dictionary.get(arr2[index] + findDiff) + "  second: " + arr2[index]);
				hasFound = true;
				break;
			}
		}

		if (!hasFound)
			System.out.println("Not found");
	}

	// driver program
	public static void main(String[] args) {
		int A[] = { 4, 1, 2, 1, 1, 2 };
		int n = A.length;
		int B[] = { 3, 6, 3, 3 };
		int m = B.length;

		// Call to function
		findSwapValues(A, n, B, m);
	}
}

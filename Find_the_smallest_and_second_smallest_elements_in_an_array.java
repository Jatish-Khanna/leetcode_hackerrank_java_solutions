class Solution {

	private static void print2Smallest(int[] arr) {

		if (arr.length < 2) {
			return;
		}

		int firstSmallest = arr[0] < arr[1] ? 0 : 1;
		int secondSmallest = 1 - firstSmallest;

		for (int index = 2; index < arr.length; index++) {
			if (arr[index] < arr[firstSmallest]) {
				secondSmallest = firstSmallest;
				firstSmallest = index;
			} else if (arr[index] < arr[secondSmallest] && arr[firstSmallest] != arr[index]) {
				secondSmallest = index;
			}
		}
		System.out.println("First smallest: " + arr[firstSmallest] + " Second smallest: " + arr[secondSmallest]);
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 12, 13, 1, 10, 34, 1 };
		print2Smallest(arr);
	}
}

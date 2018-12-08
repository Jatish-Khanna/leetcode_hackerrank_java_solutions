class Solution {


	private static void findCounts(int[] arr, int length) {
		for (int index = 0; index < length;) {

			int elementIndex = arr[index] - 1;

			if (arr[index] <= 0) {
				index++;
				continue;
			}

			if (arr[elementIndex] > 0) {
				arr[index] = arr[elementIndex];
				arr[elementIndex] = -1;
			} else {

				arr[elementIndex]--;
				arr[index] = 0;
				index++;
			}
		}

		for (int index = 0; index < length; index++) {
			System.out.print((index + 1) + "->" + (-arr[index]) + " ");
		}
		System.out.println();
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		int arr[] = { 2, 3, 3, 2, 5 };
		findCounts(arr, arr.length);

		int arr1[] = { 1 };
		findCounts(arr1, arr1.length);

		int arr3[] = { 4, 4, 4, 4 };
		findCounts(arr3, arr3.length);

		int arr2[] = { 1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1 };
		findCounts(arr2, arr2.length);

		int arr4[] = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		findCounts(arr4, arr4.length);

		int arr5[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		findCounts(arr5, arr5.length);

		int arr6[] = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		findCounts(arr6, arr6.length);
	}
}

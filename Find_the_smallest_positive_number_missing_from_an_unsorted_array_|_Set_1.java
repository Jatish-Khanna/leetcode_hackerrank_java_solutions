class Solution {

	private static int findFirstMissingPositiveNumber(int[] arr, int length) {

		int elementAsIndex;
		int tempForSwap;
		for (int elementIndex = 0; elementIndex < length; elementIndex++) {

			if (0 < arr[elementIndex]) {
				elementAsIndex = arr[elementIndex] - 1;
				if (elementAsIndex < length && 0 <= arr[elementAsIndex]) {
					tempForSwap = arr[elementIndex];
					arr[elementIndex] = arr[elementAsIndex];
					arr[elementAsIndex] = -tempForSwap;
					elementIndex--;
				}

			}
		}

		for (int elementIndex = 0; elementIndex < length; elementIndex++) {
			if (0 <= arr[elementIndex]) {
				return elementIndex + 1;
			}
		}
		return -1;
	}

	// main function
	public static void main(String[] args) {
		// Missing number is 4
		int arr[] = { 1,2,3,5,-10,-4 };
		int arr_size = arr.length;
		int missing = findFirstMissingPositiveNumber(arr, arr_size);
		System.out.println("The smallest positive missing number is " + missing);
	}
}

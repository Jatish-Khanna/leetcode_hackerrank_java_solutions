class Solution {

	private static int numberOne;
	private static int numberTwo;

	private static void getTwoElements(int[] arr, int length) {
		if (arr == null || length == 0)
			return;

		int[] count = new int[length + 1];
		for (int number : arr) {
			count[number]++;
			if (count[number] == 2)
				numberOne = number;
		}
		for (int index = 1; index <= length; index++) {
			if (count[index] == 0) {
				numberTwo = index;
				break;
			}
		}
	}

	private static void getTwoElementsWithMarkingMethod(int[] arr, int length) {
		if (arr == null || length == 0)
			return;

		int indexOfNumber;
		for (int number : arr) {
			indexOfNumber = Math.abs(number) - 1;
			if (arr[indexOfNumber] > 0) {
				arr[indexOfNumber] = -arr[indexOfNumber];
			} else {
				numberOne = Math.abs(number);
			}
		}

		for (int index = 0; index < length; index++) {
			if (arr[index] > 0) {
				numberTwo = index + 1;
				break;
			}
		}

	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 5, 1, 6, 2 };

		int n = arr.length;
		getTwoElements(arr, n);
		System.out.println(" The repeating element is  " + numberOne + " and the missing number is " + numberTwo);

		numberOne = 0;
		numberTwo = 0;

		getTwoElementsWithMarkingMethod(arr, n);
		System.out.println(" The repeating element is  " + numberOne + " and the missing number is " + numberTwo);

	}
}

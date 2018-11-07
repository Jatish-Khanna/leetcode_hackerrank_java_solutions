import java.util.Arrays;

class Solution {
	public static void main(String[] args) {
		int arr[] = new int[] { 4, 3, 7, 8, 6, 2, 1 };
		convertArrayToMinMaxOrder(arr, arr.length);
		Arrays.stream(arr).forEach(System.out::println);
	}

	/**
	 * Convert the elements in alternate order (starting with min and then max...)
	 * 
	 * @param arr    elements to be converted to required order
	 * @param length number of elements
	 */
	private static void convertArrayToMinMaxOrder(int[] arr, int length) {
		// First element should be minimum than second element
		// Other variants - include
		// First larger element - nextMaxOrder = false
		// First element unchanged (nextMaxOrder = arr[0] < arr[1]? true: false)
		boolean nextMaxOrder = true;
		int index = 0;

		// Iterate over each element until last but one element
		while (index < length - 1) {
			// if the order is nextMax but current order is max min then
			if (nextMaxOrder && arr[index] > arr[index + 1]) {
				// swap if above condition is true
				swapElements(arr, index, index + 1);
			}
			// if the order is nextMax = false but current order is min max then
			else if (!nextMaxOrder && arr[index] < arr[index + 1]) {
				// swap if above condition is true
				swapElements(arr, index, index + 1);
			}
			index++;
			// Flip the next required order
			nextMaxOrder = !nextMaxOrder;
		}
	}

	/**
	 * Swap elements at indexes
	 * @param arr original array where elements will be swapped
	 * @param index swap location first
	 * @param next swap location second
	 */
	private static void swapElements(int[] arr, int index, int next) {
		int tmp = arr[index];
		arr[index] = arr[next];
		arr[next] = tmp;
	}

}

class Solution {


	private static int binarySearch(int[] arr, int element) {
		if (arr == null)
			return -1;
		int start = 0;
		int end = arr.length - 1;
		int mid;
		while (start <= end) {
			mid = start + ((end - start) / 2);
			if (arr[mid] == element)
				return mid;
			else if (arr[mid] < element) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	// Driver method to test above
	public static void main(String args[]) {

		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 41;
		int result = binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element not present");
		else
			System.out.println("Element found at " + "index " + result);
	}
}

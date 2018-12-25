class Solution {


	private static int indexOfFirstOne(int[] arr, int start, int end) {
		if (arr == null || end == 0)
			return -1;

		int low = start;
		int high = end;
		int mid;
		while (low <= high) {
			mid = low + ((high - low) >> 1);
			if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
				return mid;
			} else if (arr[mid] == 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int arr[] = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 };
//		int arr[] = {  1, 1, 1 };
//		int arr[] = {  0,0 };
		int n = arr.length;
		System.out.println(indexOfFirstOne(arr, 0, n - 1));

	}
}
}

class Solution {
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sort(arr, arr_size);
		System.out.println("Array after seggregation ");
		Arrays.stream(arr).forEach(System.out::println);
	}

	/**
	 * Sort three number in ascending order - count algorithm will not work with
	 * objects
	 * 
	 * @param arr      array to be sorted (only has 0, 1, 2)
	 * @param arr_size (array size)
	 */
	private static void sort(int[] arr, int arr_size) {
		int low = 0;
		int mid = 0;
		int high = arr_size - 1;
		int swap = 0;

		// Until all the arrays are sorted
		while (mid <= high) {
			switch (arr[mid]) {
			// if item found is zero at location mid, swap both the positions
			case 0:
				swap = arr[mid];
				arr[mid] = arr[low];
				arr[low] = swap;
				low++;
				mid++;
				break;
			// if item found is one, move ahead
			case 1:
				mid++;
				break;
			// if item found is two, swap with mid, (if item at high = 0) then will be
			// reswapped as case 0
			case 2:
				swap = arr[mid];
				arr[mid] = arr[high];
				arr[high] = swap;
				high--;
				break;

			}
		}
	}
}

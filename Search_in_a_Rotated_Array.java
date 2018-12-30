class Soltion {

	private static int search(int[] arr, int left, int right, int keyToSearch) {
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;
		if (arr[mid] == keyToSearch)
			return mid;

		// Left ... Mid is sorted
		if (arr[left] <= arr[mid]) {
			// Key must be present in left Half
			if (arr[left] <= keyToSearch && keyToSearch <= arr[mid]) {
				return search(arr, left, mid - 1, keyToSearch);
			}
			// Key must be present in second half
			else {
				return search(arr, mid + 1, right, keyToSearch);
			}
		}
		// If left ... mid is not sorted then
		// mid ... right must be sorted
		if (arr[mid] <= keyToSearch && keyToSearch <= arr[right]) {
			return search(arr, mid + 1, right, keyToSearch);
		} else {
			return search(arr, left, mid - 1, keyToSearch);
		}
	}

	// main function
	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		int n = arr.length;
		int key = 1;
		int i = search(arr, 0, n - 1, key);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Key not found");
	}
}

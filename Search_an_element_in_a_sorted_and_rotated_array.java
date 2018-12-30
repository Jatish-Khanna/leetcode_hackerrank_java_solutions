class Solution {

	private static int pivotedBinarySearch(int[] arr, int length, int keyToSearch) {
		if (arr == null || length == 0)
			return -1;
		// Location after which rotation starts
		int pivotIndex = findPivotLocation(arr, 0, length - 1);

		if (pivotIndex == -1) {
			return pivotedBinarySearchUtil(arr, 0, length - 1, keyToSearch);
		}

		// Key found at pivot
		if (arr[pivotIndex] == keyToSearch) {
			return pivotIndex;
		}
		// Key must be in left of pivot
		else if (arr[0] <= keyToSearch) {
			return pivotedBinarySearchUtil(arr, 0, pivotIndex - 1, keyToSearch);
		}
		// Key must be present in right after the pivot index
		else {
			return pivotedBinarySearchUtil(arr, pivotIndex + 1, length - 1, keyToSearch);
		}
	}

	private static int findPivotLocation(int[] arr, int left, int right) {
		if (left > right)
			return -1;

		int mid = left + (right - left) / 2;
		if (mid < right && arr[mid + 1] < arr[mid]) {
			return mid;
		} else if (left < mid && arr[mid] < arr[mid - 1]) {
			return mid - 1;
		}

		if (arr[mid] <= arr[left]) {
			return findPivotLocation(arr, left, mid - 1);
		} else {
			return findPivotLocation(arr, mid + 1, right);
		}
	}

	private static int pivotedBinarySearchUtil(int[] arr, int left, int right, int keyToSearch) {
		if (right < left)
			return -1;

		int mid = left + (right - left) / 2;
		if (arr[mid] == keyToSearch) {
			return mid;
		} else if (arr[mid] > keyToSearch) {
			return pivotedBinarySearchUtil(arr, left, mid - 1, keyToSearch);
		} else {
			return pivotedBinarySearchUtil(arr, mid + 1, right, keyToSearch);
		}
	}

	// main function
	public static void main(String args[]) {
		// Let us search 3 in below array
		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int n = arr1.length;
		int key = 1;
		System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));
	}
}

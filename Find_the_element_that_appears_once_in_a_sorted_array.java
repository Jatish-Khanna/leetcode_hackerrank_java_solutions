class Solution {


	private static void searchElementWithOneFrequencyInSortedArray(int[] arr, int start, int end) {
		if (start > end) {
			System.out.println("Element not found");
			return;
		}
		if (start == end) {
			System.out.println("Element found at index: " + start + " and element is: " + arr[start]);
			return;
		}

		int length = end - start + 1;
		int mid = start + ((length - 1) / 2);

		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1]) {
				searchElementWithOneFrequencyInSortedArray(arr, mid + 2, end);
			} else {
				searchElementWithOneFrequencyInSortedArray(arr, start, mid);
			}
		} else {
			if (arr[mid] == arr[mid - 1]) {
				searchElementWithOneFrequencyInSortedArray(arr, mid + 1, end);
			} else {
				searchElementWithOneFrequencyInSortedArray(arr, start, mid - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 4, 4, 5, 5, 6, 6 };
		searchElementWithOneFrequencyInSortedArray(arr, 0, arr.length - 1);
	}
}
}

import java.util.Arrays;

class Solution {


	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end || arr == null)
			return;

		int pivot = findPivotAndPartionArray(arr, start, end);
		quickSort(arr, start, pivot - 1);
		quickSort(arr, pivot + 1, end);

	}

	private static int findPivotAndPartionArray(int[] arr, int start, int end) {

		int pivot = arr[end];
		int lastSmaller = start;
		// int current = start + 1;

		for (int current = lastSmaller; current <= end - 1; current++) {
			if (arr[current] <= pivot) {
				swap(arr, lastSmaller, current);
				lastSmaller++;
			}
		}

		swap(arr, lastSmaller, end);
		return lastSmaller++;
	}

	private static void swap(int[] arr, int firstIndex, int secondIndex) {

		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}

	// Driver program
	public static void main(String args[]) {
//		int arr[] = { 10, 7, 8, 9, 1, 5 };
//		int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//		int arr[] = { 10,9,8,7,6,5,4,3,2,1 };
		int arr[] = { 2, 2, 2, 3, 3, 3, 3, 1, 1, 1, 1 };
		int n = arr.length;

		// QuickSort ob = new QuickSort();
		quickSort(arr, 0, n - 1);

		System.out.println("sorted array");
		Arrays.stream(arr).forEach(element -> System.out.print(element + " "));
	}
}

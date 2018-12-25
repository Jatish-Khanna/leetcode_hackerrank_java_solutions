import java.util.Arrays.

class Solution {


	private static void mergeSort(int[] arr, int start, int end) {

		int mid;
		if (start < end) {
			mid = start + ((end - start) / 2);
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int[] temp = new int[end - start + 1];
		int firstIndex = start;
		int secondIndex = mid + 1;
		int storeIndex = 0;

		while (firstIndex <= mid && secondIndex <= end) {
			if (arr[firstIndex] <= arr[secondIndex]) {
				temp[storeIndex] = arr[firstIndex];
				firstIndex++;
			} else {
				temp[storeIndex] = arr[secondIndex];
				secondIndex++;
			}
			storeIndex++;
		}
		while (firstIndex <= mid) {
			temp[storeIndex] = arr[firstIndex];
			firstIndex++;
			storeIndex++;
		}

		while (secondIndex <= end) {
			temp[storeIndex] = arr[secondIndex];
			secondIndex++;
			storeIndex++;
		}

		for (int index = 0; index <= end - start; index++) {
			arr[start + index] = temp[index];
		}
	}

	// Driver method
	public static void main(String args[]) {
//		int arr[] = { 12, 11, 13, 5, 6, 7 };
//		 int arr[] = { 10, 7, 8, 9, 1, 5 };
//		int arr[] = { 1,2,3,4,5,6,7,8,9,10 };
//		int arr[] = { 10,9,8,7,6,5,4,3,2,1 };
//		int arr[] = { 2, 2, 2, 3, 3, 3, 3, 1, 1, 1, 1 };
		int arr[] = { 1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4 };

		System.out.println("Given Array");
		Arrays.stream(arr).forEach(element -> System.out.print(element + " "));

		// MergeSort ob = new MergeSort();
		mergeSort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		Arrays.stream(arr).forEach(element -> System.out.print(element + " "));
	}
}

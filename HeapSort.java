import java.util.Arrays;

class Solution {

	private static void heapSort(int[] arr) {
		if (arr == null || arr.length < 1)
			return;
		for (int index = arr.length / 2 - 1; index >= 0; index--) {
			heapify(arr, arr.length, index);
		}

		for (int index = arr.length - 1; index >= 0; index--) {
			swapElement(arr, 0, index);
			heapify(arr, index, 0);
		}

	}

	private static void heapify(int[] arr, int length, int index) {
		int largestElementAtIndex = index;
		int leftChild = largestElementAtIndex * 2 + 1;
		int rightChild = largestElementAtIndex * 2 + 2;

		if (leftChild < length && arr[leftChild] > arr[largestElementAtIndex]) {
			largestElementAtIndex = leftChild;
		}
		if (rightChild < length && arr[rightChild] > arr[largestElementAtIndex]) {
			largestElementAtIndex = rightChild;
		}

		if (largestElementAtIndex != index) {
			swapElement(arr, index, largestElementAtIndex);
			heapify(arr, length, largestElementAtIndex);
		}
	}

	private static void swapElement(int[] arr, int indexFirst, int indexSecond) {
		int temp = arr[indexFirst];
		arr[indexFirst] = arr[indexSecond];
		arr[indexSecond] = temp;
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		heapSort(arr);

		System.out.println("Sorted array is");
		Arrays.stream(arr).forEach(element -> System.out.print(element + " "));
	}
}

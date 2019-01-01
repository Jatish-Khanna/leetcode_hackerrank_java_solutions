class Solution {


	private static double getMedianOfTwoSortedArrays(int[] arr1, int[] arr2, int lengthOne, int lengthTwo) {
		if (lengthTwo == 0)
			return -1;
		else if (lengthOne == 0)
			return arr2[lengthTwo / 2];

		int minIndex = 0;
		int maxIndex = lengthOne;
		int midFirstArray = 0;
		int midSecondArray = 0;
		double median = 0.0;

		while (minIndex <= maxIndex) {

			// Middle element from first array
			midFirstArray = minIndex + (maxIndex - minIndex) / 2;
			// Remaining elements from the second array
			midSecondArray = ((lengthOne + lengthTwo + 1) / 2) - midFirstArray;

			// Search on the right half of first array and left half of second
			if (midFirstArray < lengthOne && midSecondArray > 0 && arr1[midFirstArray] < arr2[midSecondArray - 1]) {
				minIndex = midFirstArray + 1;
			}
			// Search on the left half of first array and right half of second array
			else if (midFirstArray > 0 && midSecondArray < lengthTwo
					&& arr2[midSecondArray] < arr1[midFirstArray - 1]) {
				maxIndex = midFirstArray - 1;
			}
			// The desired half have been found
			else {
				// No elements are available from First array's - first half
				// median is the last element from second array's first half
				if (midFirstArray == 0) {
					median = arr2[midSecondArray - 1];
				}
				// No elements available from the second array's first half
				// median is the last element from first array's first half
				else if (midSecondArray == 0) {
					median = arr1[midFirstArray - 1];
				}
				// Maximum element of first array's and second array's last element from first
				// half
				else {
					median = Math.max(arr1[midFirstArray - 1], arr2[midSecondArray - 1]);
				}

				break;
			}
		}
		// Odd length - we already have the median
		if ((lengthOne + lengthTwo) % 2 == 1) {
			return median;
		} 
		// No elements available from first array to be part of media
		// Second arrays's first half last element and
		// Second array's second half first element
		else if (midFirstArray == lengthOne) {
			median = (median + arr2[midSecondArray]) / 2;
		} 
		// No elements available from second array to be part of media
		// First arrays's first half last element and
		// First array's second half first element
		else if (midSecondArray == lengthTwo) {
			median = (median + arr1[midFirstArray]) / 2;
		} 
		// Minimum of first or second arrays second half
		else {
			median = (median + Math.min(arr1[midFirstArray], arr2[midSecondArray])) / 2;
		}
		return median;
	}

	public static void main(String[] args) {
		int[] arr1 = {};
		int[] arr2 = { 6, 8, 10 };

		int lengthOne = arr1.length;
		int lengthTwo = arr2.length;

		// To ensure time complexity O(log(min(lengthOne,lengthTwo)))
		if (lengthOne < lengthTwo) {
			System.out.println(getMedianOfTwoSortedArrays(arr1, arr2, lengthOne, lengthTwo));
		} else {
			System.out.println(getMedianOfTwoSortedArrays(arr2, arr1, lengthTwo, lengthOne));
		}
	}
}

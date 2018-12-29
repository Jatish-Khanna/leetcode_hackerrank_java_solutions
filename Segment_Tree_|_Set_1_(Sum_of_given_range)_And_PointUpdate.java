class Solution {
	// Driver program to test above functions
	public static void main(String args[]) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };
		int n = arr.length;
		SegmentTree tree = new SegmentTree(arr, n);

		// Build segment tree from given array

		// Print sum of values in array from index 1 to 3
		System.out.println("Sum of values in given range = " + tree.getSumForRange(n, 1, 3));

		// Update: set arr[1] = 10 and update corresponding segment
		// tree nodes
		tree.updateValue(arr, n, 1, 10);

		// Find sum after the value is updated
		System.out.println("Updated sum of values in given range = " + tree.getSumForRange(n, 1, 3));
	}
}

class SegmentTree {

	private int[] segmentTree;

	SegmentTree(int[] arr, int length) {
		int sizeOfTree = getSizeOfSegmentTree(getLargerNumberPowerOfTwo(length));
		segmentTree = new int[sizeOfTree];

		constructSegmentTree(arr, 0, length - 1, 0);

	}

	// Get the number larger than size i.e. power of two
	private int getLargerNumberPowerOfTwo(int number) {
		return (int) Math.pow(2, Math.ceil(Math.log(number) / Math.log(2)));
	}

	// Number of nodes in tree is - 2 * number - 1 (as root is 1 other nodes have
	// two childs or zero)
	private int getSizeOfSegmentTree(int number) {
		return 2 * number - 1;
	}

	private int constructSegmentTree(int[] arr, int left, int right, int elementIndex) {
		if (left == right) {
			segmentTree[elementIndex] = arr[left];
			return segmentTree[elementIndex];
		}

		int mid = getMidIndex(left, right);
		segmentTree[elementIndex] = constructSegmentTree(arr, left, mid, elementIndex * 2 + 1)
				+ constructSegmentTree(arr, mid + 1, right, elementIndex * 2 + 2);

		return segmentTree[elementIndex];
	}

	public int getSumForRange(int length, int startRange, int endRange) {
		if (checkOutOfBounds(length, startRange, endRange)) {
			System.out.println("The specified range is out of bounds.");
			return -1;
		}
		return getSumForRangeUtil(0, length - 1, startRange, endRange, 0);
	}

	private int getSumForRangeUtil(int left, int right, int startRange, int endRange, int segmentIndex) {

		// Query range is not in bounds - return 0
		if (right < startRange || left > endRange)
			return 0;

		// Query range is in bounds
		// If part of segment tree is within the range lookup
		if (startRange <= left && endRange >= right)
			return segmentTree[segmentIndex];

		int mid = getMidIndex(left, right);

		return getSumForRangeUtil(left, mid, startRange, endRange, segmentIndex * 2 + 1)
				+ getSumForRangeUtil(mid + 1, right, startRange, endRange, segmentIndex * 2 + 2);
	}

	// Find mid index for given positions
	private int getMidIndex(int start, int end) {
		return start + (end - start) / 2;
	}

	// Check the bounds - return true if Out of bounds
	private boolean checkOutOfBounds(int length, int startRange, int endRange) {
		return startRange < 0 || endRange >= length || startRange > endRange;
	}

	public void updateValue(int[] arr, int length, int indexToUpdate, int valueToUpdate) {

		// check update bounds
		if (indexToUpdate < 0 || indexToUpdate >= length) {
			System.out.println("Range invalid");
			return;
		}

		// Find the difference in value and propagate up- to ancestors
		int diffValue = valueToUpdate - arr[indexToUpdate];
		// Value update at index in the original array
		arr[indexToUpdate] = valueToUpdate;
		// Call update the segment tree with new difference value
		updateValueUtil(0, length - 1, indexToUpdate, diffValue, 0);
	}

	private void updateValueUtil(int left, int right, int indexToUpdate, int diffValue, int segmentIndex) {
		// Check the index to update is in bounds
		if (indexToUpdate < left || right < indexToUpdate) {
			return;
		}

		// Update the value in the segment tree
		segmentTree[segmentIndex] = segmentTree[segmentIndex] + diffValue;
		
		// Check if left and right bounds meet
		if (left != right) {

			int mid = getMidIndex(left, right);
			// Update the left half
			updateValueUtil(left, mid, indexToUpdate, diffValue, segmentIndex * 2 + 1);
			// Update the right half
			updateValueUtil(mid + 1, right, indexToUpdate, diffValue, segmentIndex * 2 + 2);
		}

	}

}

class Solution {

	static int[] binaryIndexedTree;

	private static void constructBITree(int[] arr, int length) {
		if (arr == null || length == 0)
			return;
		binaryIndexedTree = new int[length + 1];

		for (int index = 0; index < length; index++) {
			updateValue(index, arr[index], length);
		}
	}

	private static void updateValue(int indexToUpdate, int valueToUpdate, int length) {

		// BIT starts with indexing = 1..n
		indexToUpdate = indexToUpdate + 1;
		while (indexToUpdate <= length) {
			// Update value at index
			binaryIndexedTree[indexToUpdate] += valueToUpdate;

			// Update all children until end
			// Get the last set bit
			// Update the new index to its child
			indexToUpdate += (indexToUpdate & (-indexToUpdate));
		}
	}

	private static void update(int left, int right, int length, int valueToUpdate) {
		updateValue(left, valueToUpdate, length);
		updateValue(right + 1, -valueToUpdate, length);
	}

	private static int getSum(int index) {
		// Add +1 as BIT start with 1..n
		index = index + 1;
		int sum = 0;
		while (index > 0) {
			// Add the value to sum
			sum += binaryIndexedTree[index];
			// Update the index to its parent
			index -= (index & (-index));
		}
		return sum;
	}

	// Driver Code
	public static void main(String args[]) {
		int arr[] = { 0, 0, 0, 0, 0 };
		int n = arr.length;

		constructBITree(arr, n);

		// Add 2 to all the
		// element from [2,4]
		int l = 2, r = 4, val = 2;
		update(l, r, n, val);

		int index = 4;

		System.out.println("Element at index " + index + " is " + getSum(index));

		// Add 2 to all the
		// element from [0,3]
		l = 0;
		r = 3;
		val = 4;
		update(l, r, n, val);

		// Find the element
		// at Index 3
		index = 3;
		System.out.println("Element at index " + index + " is " + getSum(index));
	}
}

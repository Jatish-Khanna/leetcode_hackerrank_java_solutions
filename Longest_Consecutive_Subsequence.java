import java.util.HashSet;

class Solution {
	private static int findLongestConseqSubseq(int arr[], int length) {
		HashSet<Integer> dictionary = new HashSet<>();
		for (int index = 0; index < length; index++) {
			dictionary.add(arr[index]);
		}

		int currentElement;

		int maxLength = 0;

		for (int index = 0; index < length; index++) {
			if (!dictionary.contains(arr[index] - 1)) {
				currentElement = arr[index];
				while (dictionary.contains(currentElement)) {
					currentElement++;
				}

				maxLength = Math.max(currentElement - arr[index], maxLength);
			}
		}
		return maxLength;
	}

	// Testing program
	public static void main(String args[]) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2, 5, 11, 12, 13, 14 };
		int n = arr.length;
		System.out.println("Length of the Longest consecutive subsequence is " + findLongestConseqSubseq(arr, n));
	}

}

class Solution {
	public static void main(String args[]) {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println("Sum of maximum sum " + "increasing subsequence is " + maxSumIncresingSubSequence(arr, n));
	}

	private static int maxSumIncresingSubSequence(int[] arr, int n) {
		int maxSum = arr[0];
		int[] sumIndex = new int[n];
		sumIndex[0] = arr[0];
		for (int index = 1; index < n; index++) {
			for (int subIndex = 0; subIndex < index; subIndex++) {
				if (arr[subIndex] < arr[index]) {
					sumIndex[index] = Math.max(sumIndex[index], sumIndex[subIndex] + arr[index]);
				}
			}
			maxSum = Math.max(maxSum, sumIndex[index]);
		}
		return maxSum;
	}
}

class Solution {

	private static int maxIndexDiff(int[] arr, int length) {
		if (arr == null)
			return 0;

		int[] rightMax = new int[length];
		rightMax[length - 1] = arr[length - 1];
		for (int element = length - 2; element >= 0; element--) {
			rightMax[element] = Math.max(arr[element], rightMax[element + 1]);
		}

		int left = 0;
		int right = 0;
		int maxDiff = 0;
		while (left < length && right < length) {
			if (arr[left] < rightMax[right]) {
				maxDiff = Math.max(maxDiff, right - left);
				right++;
			} else {
				left++;
			}
		}
		return maxDiff;
	}

	/* Driver program to test the above functions */
	public static void main(String[] args) {

		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = maxIndexDiff(arr, n);
		System.out.println(maxDiff);
	}
}

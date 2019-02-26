class Solution {

	private static void longestConsecutiveSubarray(int[] arr) {

		int maxLength = 1;
		int length = 1;
		int previous = arr[0];

		for (int index = 1; index < arr.length; index++) {
			if (areConsecutiveElements(previous, arr[index])) {
				length++;
			} else {
				length = 1;
			}
			maxLength = Math.max(maxLength, length);
			previous = arr[index];
		}
		System.out.println(maxLength);
	}

	private static boolean areConsecutiveElements(int first, int second) {
		return Math.abs(first - second) == 1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 2, 1, 4, 3, 2, 1, 0 };
		longestConsecutiveSubarray(arr);

	}

}

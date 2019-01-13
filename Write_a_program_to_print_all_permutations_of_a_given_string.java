class Solution {

	private static void permute(char[] arr, int left, int right) {
		if (left == right) {
			printReult(arr);
		} else {
			for (int index = left; index <= right; index++) {

				swap(arr, left, index);
				permute(arr, left + 1, right);
				swap(arr, left, index);
			}
		}
	}

	private static void swap(char[] arr, int firstIndex, int secondIndex) {
		char temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}

	private static void printReult(char[] arr) {
		System.out.println(String.valueOf(arr));
	}

	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();

		permute(str.toCharArray(), 0, n - 1);
	}
}

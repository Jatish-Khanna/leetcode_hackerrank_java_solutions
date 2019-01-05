import java.util.Arrays;

class Solution {

	private static int countTriplets(int[] arr, int sum) {
		if (arr == null)
			return 0;

		Arrays.sort(arr);
		int left;
		int right;
		int count = 0;
		for (int element = 0; element < arr.length - 2; element++) {
			left = element + 1;
			right = arr.length - 1;
			while (left < right) {
				if (arr[element] + arr[left] + arr[right] < sum) {
					count += right - left;
					left++;
				} else {
					right--;
				}
			}

		}
		return count;
	}

	// Driver method to test the above function
	public static void main(String[] args) {
		int arr[] = new int[] { 5, 1, 3, 4, 7 };
		int sum = 12;
		System.out.println(countTriplets(arr, sum));
	}
}

import java.util.HashMap;

class Solution {


	private static int subarrayLengthWithSum0(int[] arr) {

		HashMap<Integer, Integer> dictionarySumIndex = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		for (int index = 0; index < arr.length; index++) {
			sum += arr[index];

			if (sum == 0)
				maxLength = index + 1;
			else if (arr[index] == 0 && maxLength == 0)
				maxLength = 1;

			if (dictionarySumIndex.get(sum) != null) {
				maxLength = Math.max(maxLength, index - dictionarySumIndex.get(sum));
			} else {
				dictionarySumIndex.put(sum, index);
			}
		}
		return maxLength;
	}

	// Drive method
	public static void main(String arg[]) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println("Length of the longest 0 sum subarray is " + subarrayLengthWithSum0(arr));
	}

}

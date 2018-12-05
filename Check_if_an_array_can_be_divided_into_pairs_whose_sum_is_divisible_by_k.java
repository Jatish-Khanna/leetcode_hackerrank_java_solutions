import java.util.HashSet;

class Solution {

	private static boolean canPairs(int[] arr, int K) {
		if (arr.length % 2 != 0)
			return false;
		HashSet<Integer> dictionary = new HashSet<>();

		int remainder;
		for (int index = 0; index < arr.length; index++) {
			remainder = arr[index] % K;

			if (dictionary.contains(K - remainder)) {
				dictionary.remove(K - remainder);
			} else {
				dictionary.add(remainder);
			}

		}
		return dictionary.size() == 0;

	}

	// Driver program to test above functions
	public static void main(String[] args) {
		int arr[] = { 92, 75, 65, 48, 45, 36 };
		int k = 10;
		boolean ans = canPairs(arr, k);
		if (ans)
			System.out.println("True");
		else
			System.out.println("False");

	}
}

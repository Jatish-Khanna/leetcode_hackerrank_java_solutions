import java.util.HashSet;
import java.util.Arrays;

class Solution {

	private static boolean isSubset(int[] arr1, int[] arr2, int firstLength, int secondLength) {
		HashSet<Integer> dictionary = new HashSet<>();

		for (int index = 0; index < firstLength; index++) {
			dictionary.add(arr1[index]);
		}

		return Arrays.stream(arr2).boxed().allMatch(dictionary::contains);

		// for(int index = 0; index < secondLength; index++) {
		// if(!dictionary.contains(arr2[index]))
		// return false;
		// }
		// return true;
	}

	public static void main(String[] args) {
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 1 };

		int m = arr1.length;
		int n = arr2.length;

		if (isSubset(arr1, arr2, m, n))
			System.out.println("arr2 is a subset of arr1");
		else
			System.out.println("arr2 is not a subset of arr1");
	}

}

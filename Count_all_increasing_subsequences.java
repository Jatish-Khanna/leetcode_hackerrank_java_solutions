import java.util.Arrays;

class Solution {

	// Driver program to run the test case
	public static void main(String[] args) {
		int arr[] = { 3, 2, 4, 5, 4 };
		int n = arr.length;

		System.out.println(countSub(arr, n));
	}

	private static int countSub(int[] arr, int n) {
		// TODO Auto-generated method stub
		int[] dpSol = new int[10];
		for (int value : arr) {
			dpSol[value]++;
			for (int lower = value - 1; lower >= 0; lower--) {
				dpSol[value] += dpSol[lower];
			}
		}
		return Arrays.stream(dpSol).sum();

	}
}

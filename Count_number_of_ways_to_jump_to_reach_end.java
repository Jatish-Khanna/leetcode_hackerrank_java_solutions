import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 8, 9, 1, 0, 7, 6, 8, 9 };
		int n = arr.length;

		countWaysToJump(arr, n);
	}

	private static void countWaysToJump(int[] arr, int n) {
		int[] solution = new int[n];
		for (int index = n - 2; index >= 0; index--) {
			if (arr[index] >= (n - index - 1)) {
				solution[index] = 1;
			}
			for (int indexToEnd = index + 1; indexToEnd < n - 1 && indexToEnd <= arr[index] + index; indexToEnd++) {
				if (solution[indexToEnd] != -1) {
					solution[index] += solution[indexToEnd];
				}
			}
			if (solution[index] == 0)
				solution[index] = -1;
		}

		Arrays.stream(solution).forEach(element -> System.out.print(element + " "));
	}
}

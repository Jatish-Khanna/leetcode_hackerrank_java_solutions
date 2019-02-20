import java.util.Arrays;

class Solution {


	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 2, -4, -3, -2, 4, 3,4,-1, 2 };
		int temp;
		int index = 0;
		int j = 0;
		int lastPositive;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				if (i != j) {
					temp = arr[i];
					lastPositive = i;
					index = i - 1;
					while (index >= j) {
						arr[lastPositive--] = arr[index--];
					}
					arr[j] = temp;
				}
				j++;
			}
		}
		Arrays.stream(arr).forEach(System.out::println);
	}
}

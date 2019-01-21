import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

	private static void calculateSpan(int[] price, int length, int[] solution) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		solution[0] = 1;

		for (int index = 1; index < length; index++) {
			while (!stack.isEmpty() && price[index] >= price[stack.peek()]) {
				stack.pop();
			}
			solution[index] = stack.isEmpty() ? index + 1 : index - stack.peek();
			stack.push(index);
		}
	}

	private static void printArray(int[] solution) {
		Arrays.stream(solution).forEach(element -> System.out.println(element + " "));
	}

	// Driver method
	public static void main(String[] args) {
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int n = price.length;
		int S[] = new int[n];

		// Fill the span values in array S[]
		calculateSpan(price, n, S);

		// print the calculated span values
		printArray(S);
	}
}

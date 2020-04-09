

public class Solution {
	// Max profit?
	// Give a list of Stocks
	public static void main(String[] args) {
		int[] ar = new int[] { 1, 2, 3, 4, 5, 3, 2, 1, 2 };
		// 120 + 40 = 160
		System.out.println(findMaxProfit(ar));
	}

	private static int findMaxProfit(int[] ar) {
		int profit = 0;
		int min = 0;
		int index = 1;

		while (index < ar.length - 1) {
			// 240 - 180
			if (ar[index - 1] > ar[index]) {
				profit += ar[index - 1] - ar[min];
				min = index;
			}
			index++;
		}
		if (min < index) {
			profit += Math.max(ar[index], ar[index - 1]) - ar[min];
		}
		return profit;
	}
}

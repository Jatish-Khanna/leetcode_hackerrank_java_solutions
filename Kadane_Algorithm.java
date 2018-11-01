

class KadaneAlgorithm {
	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = a.length;
		maxSubArraySum(a, n);
	}

	private static void maxSubArraySum(int[] a, int n) {
		int start = 0;
		int end = -1;
		int totalSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int index = 0; index < n; index++) {
			currentSum += a[index];
			if(currentSum > totalSum) {
				totalSum = currentSum;
				end = index;
			}
			if(currentSum < 0) {
				start = index + 1;
				currentSum = 0;
			}
		}
		System.out.println("Sum:" + totalSum);
		System.out.println("Start:" + start);
		System.out.println("End:" + end);
	}
}

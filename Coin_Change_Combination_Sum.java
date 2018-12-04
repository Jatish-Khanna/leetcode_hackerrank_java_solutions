class Solution {

	private static int waysToCreateNSum(int[] arr, int length, int sum) {
		int[] ways = new int[sum + 1];
		ways[0] = 1;
		
		for (int index = 0; index < length; index++) {
			for (int startSum = arr[index]; startSum <= sum; startSum += arr[index]) {
				ways[startSum] += ways[startSum - arr[index]];
			}
		}
		return ways[sum];
	}

	// Driver Function to test above function
	public static void main(String args[]) {
		int arr[] = { 1, 2, 3, 4 };
		int m = arr.length;
		int n = 6;
		System.out.println(waysToCreateNSum(arr, m, n));
	}
}

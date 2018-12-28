class Solution {


	private static void isKthBitSet(int number, int kthBit) {
		if (((number >> (kthBit - 1)) & 1) == 1) {
			System.out.println("Kth bit is set");
		} else {
			System.out.println("Kth bit not set");
		}
	}

// Driver code 
	public static void main(String[] args) {
		int n = 7, k = 1;
		isKthBitSet(n, k);
	}
}

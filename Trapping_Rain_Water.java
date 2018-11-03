class Solution {

	static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

//		int walls = in.nextInt();
		int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };// new int[walls];
		int walls = arr.length;
//		for (int index = 0; index < walls; index++) {
//			arr[index] = in.nextInt();
//		}
		calculateRain(arr, walls);
		calculateRainOptimized(arr, walls);

		in.close();
	}

	/**
	 * maintain two variables to store the maximum till that point. Since water
	 * trapped at any element = min( max_left, max_right) – arr[i] we will calculate
	 * water trapped on smaller element out of A[left] and A[right] first and move
	 * the pointers till left doesn’t cross right
	 * 
	 * @param arr   data with walls height at index
	 * @param walls - total number of elements in arr
	 */
	private static void calculateRainOptimized(int[] arr, int walls) {
		int result = 0;
		int left = 0;
		int leftMax = 0;
		int right = walls - 1;
		int rightMax = 0;
		// Iterate until left <= right
		while (left <= right) {
			// Step into when arr[left] < arr[right]
			if (arr[left] < arr[right]) {
				// This is wall with max height till now, update Max
				if (arr[left] > leftMax) {
					leftMax = arr[left];
				}
				// calculate the storage - wall with Max left (as Math.min(left, right is left)
				else {
					// remove height of current wall
					result += leftMax - arr[left];
				}
				// increment left
				left++;
			} 
			// Step into when arr[left] > arr[right]
			else {
				if (arr[right] > rightMax) {
					rightMax = arr[right];
				} 
				// calculate the storage - wall with Max right (as Math.min(left, right is right)
				else {
					// remove height of current wall
					result += rightMax - arr[right];
				}
				// decrement or move towards left
				right--;
			}

		}
		System.out.println(result);
	}

	private static void calculateRain(int[] arr, int walls) {
		int[] left = new int[walls];
		left[0] = arr[0];

		// calculate all max wall size till now, on the left of current element
		for (int index = 1; index < walls; index++) {
			left[index] = Math.max(left[index - 1], arr[index]);
		}

		int[] right = new int[walls];
		right[walls - 1] = arr[walls - 1];
		// calculate all max wall size till now, on the right of current element
		for (int index = walls - 2; index >= 0; index--) {
			right[index] = Math.max(right[index + 1], arr[index]);
		}
		int result = 0;
		// calculate the space, remove the size of current wall , smaller than Min(left, right)
		for (int index = 0; index < walls; index++) {
			result += Math.min(left[index], right[index]) - arr[index];
		}
		System.out.println(result);
	}

}

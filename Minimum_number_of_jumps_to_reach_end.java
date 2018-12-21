import java.util.Arrays;

class Solution {

	private static final int MAX_JUMPS = 1000;
	// Method#1 - Dynamic programming O(N^2)

	private static int minimumJumpsRequiredDynamicProgrammingON2(int[] arr) {

		if (arr == null)
			return -1;
		int[] jumps = new int[arr.length];
		Arrays.fill(jumps, MAX_JUMPS);
		jumps[0] = 0;

		for (int index = 1; index < arr.length; index++) {
			for (int previousBest = 0; previousBest < index; previousBest++) {
				if (index <= previousBest + arr[previousBest]) {
					jumps[index] = Math.min(jumps[previousBest] + 1, jumps[index]);
					break;
				}
			}
		}
		return jumps[arr.length - 1] == MAX_JUMPS ? -1 : jumps[arr.length - 1];
	}

	// Method#2 - Dynamic programming worst case O(N^2)
	private static int minimumJumpsRequiredDynamicProgrammingWorstCaseON2(int[] arr) {

		if (arr == null)
			return -1;

		int length = arr.length;
		int[] jumps = new int[length];
		Arrays.fill(jumps, MAX_JUMPS);
		jumps[length - 1] = 0;

		int jumpLocation = 0;

		for (int index = length - 2; index >= 0; index--) {
			if (arr[index] + index >= length - 1) {
				jumps[index] = 1;
			} else {

				jumpLocation = index + 1;
				while (jumpLocation <= arr[index] + index && jumpLocation < length) {
					jumps[index] = Math.min(jumps[index], jumps[jumpLocation] + 1);
					jumpLocation++;
				}
			}
		}
		return jumps[0] == MAX_JUMPS ? -1 : jumps[0];
	}
	
	// Method#1 - Max reach O(N)
	private static int minimumJumpsRequiredMaxReachON(int[] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		
		int maxReach = arr[0];
		int stepsAllowed = maxReach;
		int minJumps = 0;
		
		for(int index = 1; index < arr.length; index++) {
			maxReach = Math.max(maxReach, arr[index] + index);
			stepsAllowed--;
			if(stepsAllowed == 0) {
				
				// Case: arr[0] == 0, we are at index == 1
				if(index >= maxReach)
					return -1;
				stepsAllowed = maxReach - 1;
				// Taken one jump
				minJumps++;
			}
		}
		return minJumps == 0 ? -1 : minJumps + 1;
	}
	
	// Driver method to test the above function
	public static void main(String[] args) {
//		int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		 int arr[] = new int[] { 1, 0, 2 };

		// calling minJumps method
		System.out.println(minimumJumpsRequiredDynamicProgrammingON2(arr));

		// Calling Method#2
		System.out.println(minimumJumpsRequiredDynamicProgrammingWorstCaseON2(arr));
		
		// Calling Method#3
		System.out.println(minimumJumpsRequiredMaxReachON(arr));
	}

}

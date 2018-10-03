class Solution {
	public static void main(String args[]) {
		int N = 5;
		System.out.println("Count of ways for " + N + " sections is " + countWays(N));
	}

	private static int countWays(int n) {
		//base case- to optimize
		if (n == 1)
			return 4;
		int countedWays = 0;
		
		//Previous and current number of ways with space as last
		int waysWithLastSpace;
		int waysWithSpace = 1;
		//Previous and current number of ways with building as last
		int waysWithLastBuilding;
		int waysWithBuilding = 1;
		
		/*
		 * Range 2..n
		 * store the previous values
		 * update the new values as-
		 *   building: with previous position as space
		 *   space: with previous position as ( space +  building )
		 */
		for (int nextPlace = 2; nextPlace <= n; nextPlace++) {
			waysWithLastSpace = waysWithSpace;
			waysWithLastBuilding = waysWithBuilding;

			waysWithBuilding = waysWithLastSpace;
			waysWithSpace = waysWithLastSpace + waysWithLastBuilding;
		}

		//Total value is number of ways with space + buildings
		countedWays = waysWithBuilding + waysWithSpace;
		//Combination on both sides of street
		countedWays = countedWays*countedWays;
		return countedWays;
	}
}

class Solution {

	private static int countWaysToCoverDistanceStepsOneTwoThree(int distance) {
		if (distance == 0 || distance == 1)
			return 1;
		if (distance == 2)
			return 2;
		int[] dpSol = new int[distance + 1];
		dpSol[0] = 1;
		dpSol[1] = 1;
		dpSol[2] = 2;

		for (int index = 3; index <= distance; index++) {
			dpSol[index] = dpSol[index - 1] + dpSol[index - 2] + dpSol[index - 3];
		}
		return dpSol[distance];
	}

	// driver program
	public static void main(String[] args) {
		int distance = 4;
		System.out.println(countWaysToCoverDistanceStepsOneTwoThree(distance));
	}
}

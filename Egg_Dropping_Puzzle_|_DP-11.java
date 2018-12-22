class Solution {


	private static int minimumTrialsWithEggs(int numberOfEggs, int numberOfFloors) {
		if (numberOfEggs == 0)
			return -1;

		int[][] dpSol = new int[numberOfEggs + 1][numberOfFloors + 1];

		// We need one trial for One floor with eggs equals or more than one
		for (int index = 1; index <= numberOfEggs; index++) {
			dpSol[index][1] = 1;
		}

		// With one egg, we need trial equals numberOfFloors
		for (int index = 1; index <= numberOfFloors; index++) {
			dpSol[1][index] = index;
		}

		for (int eggNumber = 2; eggNumber <= numberOfEggs; eggNumber++) {
			for (int floorNumber = 2; floorNumber <= numberOfFloors; floorNumber++) {
				dpSol[eggNumber][floorNumber] = 1000;
				for (int floor = 1; floor <= floorNumber; floor++) {
					dpSol[eggNumber][floorNumber] = Math.min(1 + Math.max(dpSol[eggNumber - 1][floor - 1],
							dpSol[eggNumber][floorNumber - floor]), dpSol[eggNumber][floorNumber]);
				}
			}
		}

		return dpSol[numberOfEggs][numberOfFloors];
	}

	/* Driver program to test to print printDups */
	public static void main(String args[]) {
		int numberOfEggs = 5, numberOfFloors = 100;
		System.out.println("Minimum number of trials in worst case with " + numberOfEggs + "  eggs and "
				+ numberOfFloors + " floors is " + minimumTrialsWithEggs(numberOfEggs, numberOfFloors));
	}
}

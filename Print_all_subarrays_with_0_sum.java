import java.util.HashMap;

class Solution {

	final static ArrayList<Integer> BEGIN_INDEX = new ArrayList<>();

	static {
		BEGIN_INDEX.add(-1);
	}

	private static void findSubArraysWithSum0(int[] arr) {

		HashMap<Integer, ArrayList<Integer>> dictionarySumIndex = new HashMap<>();
		int sum = 0;
		for (int index = 0; index < arr.length; index++) {
			sum += arr[index];

			if (sum == 0)
				printIndexPair(BEGIN_INDEX, index);

			ArrayList<Integer> currentList = dictionarySumIndex.getOrDefault(sum, new ArrayList<Integer>());
			if (dictionarySumIndex.get(sum) != null) {
				printIndexPair(dictionarySumIndex.get(sum), index);
			} else {
				dictionarySumIndex.put(sum, currentList);
			}
			currentList.add(index);
		}
	}

	private static void printIndexPair(ArrayList<Integer> firstIndexList, int endIndex) {
		for (Integer firstIndex : firstIndexList)
			System.out.println("Pair - First: " + (firstIndex + 1) + " Second: " + (endIndex));
	}

	// Drive method
	public static void main(String arg[]) {
		int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		findSubArraysWithSum0(arr);
	}

}

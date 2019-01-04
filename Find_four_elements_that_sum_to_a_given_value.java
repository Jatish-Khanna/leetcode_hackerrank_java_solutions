import java.util.HashMap;

class Solution {

	static class Pair {
		int firstElementIndex;
		int secondElementIndex;
		int sumOfElements;

		Pair(int firstElementIndex, int secondElementIndex, int sumOfElements) {
			this.firstElementIndex = firstElementIndex;
			this.secondElementIndex = secondElementIndex;
			this.sumOfElements = sumOfElements;
		}
	}

	private static void findFourElementsSumToGivenValue(int[] arr, int length, int sum) {
		HashMap<Integer, Pair> pairSumMap = new HashMap<>();

		Pair pairReference;
		Pair pairReferenceDifference;
		// Calculate the sum of each pair for the array
		for (int firstElement = 0; firstElement < length - 1; firstElement++) {
			for (int secondElement = 1; secondElement < length; secondElement++) {
				pairReference = new Pair(firstElement, secondElement, arr[firstElement] + arr[secondElement]);
				pairSumMap.put(pairReference.sumOfElements, pairReference);
				if (checkPairSum(pairSumMap, sum, pairReference)
						&& checkElementsOverlap(pairSumMap, sum, pairReference)) {
					System.out.println("Elements found: ");
					System.out.println(
							arr[pairReference.firstElementIndex] + " " + arr[pairReference.secondElementIndex]);
					pairReferenceDifference = pairSumMap.get(sum - pairReference.sumOfElements);
					System.out.println(arr[pairReferenceDifference.firstElementIndex] + " "
							+ arr[pairReferenceDifference.secondElementIndex]);
				}
			}
		}
	}

	private static boolean checkElementsOverlap(HashMap<Integer, Pair> pairSumMap, int sum, Pair pairReference) {
		Pair pairReferenceDifference = pairSumMap.get(sum - pairReference.sumOfElements);
		if (pairReferenceDifference == null)
			return false;

		if (pairReference.firstElementIndex == pairReferenceDifference.firstElementIndex
				|| pairReference.firstElementIndex == pairReferenceDifference.secondElementIndex
				|| pairReference.secondElementIndex == pairReferenceDifference.firstElementIndex
				|| pairReference.secondElementIndex == pairReferenceDifference.secondElementIndex) {
			return false;
		}
		return true;
	}

	private static boolean checkPairSum(HashMap<Integer, Pair> pairSumMap, int sum, Pair pairReference) {
		return pairSumMap.get(sum - pairReference.sumOfElements) != null;
	}

// Driver program to test above function 
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int n = arr.length;
		int X = 91;
		findFourElementsSumToGivenValue(arr, n, X);

	}
}

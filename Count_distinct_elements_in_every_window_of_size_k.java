import java.util.HashMap;

class Solution {


	private static void countDistinct(int[] arr, int windowSize) {

		HashMap<Integer, Integer> dictionary = new HashMap<>();
		int index = 0;
		for (; index < windowSize; index++) {
			addElementToDictionary(dictionary, arr[index]);
		}
		
		System.out.println(dictionary.size());
		for (; index < arr.length; index++) {
			addElementToDictionary(dictionary, arr[index]);

			removeElementFromDictionary(dictionary, arr[index - windowSize]);
			System.out.println(dictionary.size());
		}

	}

	private static void addElementToDictionary(HashMap<Integer, Integer> dictionary, int element) {
		if (dictionary.get(element) != null)
			dictionary.put(element, dictionary.get(element) + 1);
		else
			dictionary.put(element, 1);
	}

	private static void removeElementFromDictionary(HashMap<Integer, Integer> dictionary, int element) {
		if (dictionary.get(element) > 1)
			dictionary.put(element, dictionary.get(element) - 1);
		else
			dictionary.remove(element);
	}

	// Driver method
	public static void main(String arg[]) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;
		countDistinct(arr, k);
	}
}

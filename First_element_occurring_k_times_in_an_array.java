import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {


	private static int firstElement(int[] arr, int length, int repeatCount) {
  
  // Hash All the element in dictionary and frequencies
		Map<Integer, Long> dictionary =

				Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		int elementWithFreq = -1;
    
    // Lookup each element and its collected frequencies
		for (int index = 0; index < length; index++) {
    // Find if any element with higher or equal frequency available
			if (dictionary.get(arr[index]) >= repeatCount) {
				elementWithFreq = arr[index];
				break;
			}
		}

		return elementWithFreq;
	}

// Driver program to test above 
	public static void main(String[] args) {
		int arr[] = { 1, 7, 4, 3, 40, 8, 9 };
		int n = arr.length;
		int k = 2;
		System.out.println(firstElement(arr, n, k));

	}
}

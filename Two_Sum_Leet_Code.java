import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		// Indexes of the elements whose sum equals target 
		int[] index = new int[2];
		
		// Store all the visited element as keys and index as value
		Map<Integer, Integer> visited = new HashMap<>();
		
		// One-pass hash map iterate over each element
		for (int element = 0; element < nums.length; element++) {
			
			// Find if compliment is available in already visited
			if (visited.containsKey(target - nums[element])) {
				
				// Store already visited in array, compliment of number
				index[0] = visited.get(target - nums[element]);
				// Store current number and index
				index[1] = element;
				break;
			} else {
				
				// Compliment not found, store the element as visited
				visited.put(nums[element], element);
			}
		}

		// Return the indexes of element + compliment equals target
		return index;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 13;
		System.out.println(new Solution().twoSum(nums, target)[1]);
	}
}

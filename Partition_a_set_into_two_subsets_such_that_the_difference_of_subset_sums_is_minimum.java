import java.util.Arrays;

class Solution {

	private static int findMinimumDifferenceAfterDividingIntoTwoSubsets (int []arr, int size) {
		if(arr == null || size == 0)
			return -1;
		
		int sum = Arrays.stream(arr).sum();
		
		boolean [][]dpSol = new boolean[arr.length+1][sum+1];
		
		// Zero sum is possible with all the elements
		for(int index = 0; index <= size; index++)
			dpSol[index][0] = true;
		
		// Check all the sums that are possible with the given set of elements
		for(int element = 1; element <= size; element++) {
			for(int sumIndex = arr[element-1]; sumIndex <= sum; sumIndex++) {
				dpSol[element][sumIndex] = dpSol[element-1][sumIndex];
				if(!dpSol[element][sumIndex] && arr[element-1] <= sumIndex) {
					dpSol[element][sumIndex] = dpSol[element-1][sumIndex - arr[element-1]];
				}
			}
		}
		
		// Start from mid, look for first sum which is calculated with values
		for(int index = sum >> 1; index>=0; index--){
			if(dpSol[size][index])
				return Math.abs(sum - (index << 1));
		}
		return -1;
	}

    // Driver program  
    public static void main (String[] args)  
    { 
        int arr[] = {3, 7, 10, 2, 2, 7}; 
        int n = arr.length; 
        System.out.println ("The minimum difference between 2 sets is "
                            + findMinimumDifferenceAfterDividingIntoTwoSubsets(arr, n)); 
      
    } 
} 

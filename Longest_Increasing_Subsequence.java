import java.util.Arrays;

class Solution {

	
	private static int longestIncreasingSubsequence(int []arr, int length) {
		int longestSubsequenceLength = -1;
		if(arr == null)
			reutn longestSubsequenceLength;
		
		int []dpSolution = new int[length];
		Arrays.fill(dpSolution, 1);
			
			
		for(int index = 1; index < length; index++) {
			for(int beforeIndex = 0; beforeIndex < index; beforeIndex++) {
				if(arr[beforeIndex] < arr[index]){
					dpSolution[index] = Math.max(dpSolution[beforeIndex] + 1, dpSolution[index]);
				}
			}
			longestSubsequenceLength = Math.max(longestSubsequenceLength, dpSolution[index]);
		}
		
		
	}

    public static void main(String args[]) 
    { 
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
            int n = arr.length; 
            System.out.println("Length of lis is " + longestIncreasingSubsequence( arr, n ) + "\n" ); 
    } 
}

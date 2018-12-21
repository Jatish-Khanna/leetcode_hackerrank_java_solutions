class Solution {

	private static int countWays(int []arr, int length, int sum) {
	
		if(arr == null || length == 0)
			return 0;
		int []ways = new int[sum+1];
		for(int index = 0; index < length; index++) {
			for(int calSum = arr[index]; calSum <= sum; calSum++) {
			// Including + Excluding
				ways[calSum] += ways[calSum - arr[index]];
			}
		}
	}
	
    // Driver Function to test above function 
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 3}; 
        int m = arr.length; 
        int n = 4; 
        System.out.println(countWays(arr, m, n)); 
    } 
}

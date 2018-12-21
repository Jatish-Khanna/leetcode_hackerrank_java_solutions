class Solution {
	
	private static int cutRodMaximumLength(int []arr, int size) {
		if(arr == null || size == 0)
			return 0;
			
		int []maxProfit = new int[size+1];
		
		// Cut a rod of length
		for(int length = 1; length <= size; length++) {
			// Check all sub lengths for rod of length
			for(int subLength = 0; subLength < length; subLength++) {
				// maximize profit
				maxProfit[length] = Math.max(maxProfit[length], maxProfit[subLength] + arr[length - subLength - 1]);
			}
		}
		return maxProfit[size];
	}	

    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
//    	int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int arr[] = new int[] {5,4,3}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is " + 
                            cutRodMaximumLength(arr, size)); 
    } 
}

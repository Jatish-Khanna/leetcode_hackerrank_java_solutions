class Solution {

	private static int numberOfPaths(int x, int y){
		int []arr = new int[y];
		
		arr[0] = 1;
		
		for(int index = 0; index < x; index++) {
			for(int colindex = 1; colindex < y; colindex++){
				arr[colindex] += arr[colindex - 1];
			}
		}
		
		return arr[y-1];
	}
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        System.out.println(numberOfPaths(4, 3)); 
    } 
}

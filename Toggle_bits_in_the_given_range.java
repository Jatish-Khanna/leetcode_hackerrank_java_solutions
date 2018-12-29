class Solution {


	private  static int toggleBitsFromLToR(int number, int left, int right) {
		return number ^( (1 << right) - 1) ^ ((1 << left - 1) - 1);
	}
 
 // driver program 
    public static void main (String[] args)  
    { 
        int n = 50; 
        int l = 2, r = 5; 
        System.out.println(toggleBitsFromLToR(n, l, r)); 
    } 
} 

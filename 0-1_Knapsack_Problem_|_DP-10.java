class Solution {

	private static int knapSack (int bagWeight, int []itemsWeight, int []itemsValue, int length) {
	
		int [][]dpSol = new int[length+1][bagWeight+1];
		
		for(int item = 1; item <= length; item++) {
			for(int weight = 1; weight <= bagWeight; weight++) {
				if(itemsWeight[item-1] <= weight) {
				  dpSol[item][weight] = Math.max(itemsValue[item-1] + dpSol[item-1][weight - itemsWeight[item-1]], dpSol[item-1][weight]);
				} else{
					dpSol[item][weight] = dpSol[item-1][weight];
				}
			}
		}
		return dpSol[length][bagWeight];
	}

    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        int val[] = new int[]{60, 100, 120}; 
    int wt[] = new int[]{10, 20, 30}; 
    int  W = 50; 
    int n = val.length; 
    System.out.println(knapSack(W, wt, val, n)); 
    } 

}

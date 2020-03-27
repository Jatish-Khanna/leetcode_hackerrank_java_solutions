

public class Solution {


	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int items;
		int W;
		for(int test = 0; test < T; test++) {
		    items = in.nextInt();
		    W = in.nextInt();
		    int []val = new int[items];
		    int []wt = new int[items];
		    
		    for(int index = 0; index < items; index++) {
		        val[index] = in.nextInt();
		    }
		    for(int index = 0; index < items; index++) {
		         wt[index] = in.nextInt();
		    }
		    
		    int []dpSol = new int[W + 1];
		    for(int weight = 1; weight <= W; weight++) {
		        for(int i = 0; i < items; i++) {
		            if(wt[i] <= weight) {
		              dpSol[weight] = Math.max(dpSol[weight], val[i] + dpSol[weight - wt[i]]);
		            }
		        }
		    }
		    System.out.println(dpSol[W]);
		}
		
		in.close();
	}
}

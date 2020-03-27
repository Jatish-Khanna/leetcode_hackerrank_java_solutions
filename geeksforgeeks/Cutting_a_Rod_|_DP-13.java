

public class Solution {


	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int test = 0; test < T; test++) {
		    int length = in.nextInt();
		    int []price = new int[length];
		    for(int index = 0; index < length; index++) {
		        price[index] = in.nextInt();
		    }
		    int dpSol[] = new int[length + 1];
		    for(int len = 1; len <= length; len++) {
		        for(int i = 0; i < len; i++) {
		            dpSol[len] = Math.max(dpSol[len], price[i] + dpSol[len - i - 1]);
		        }
		    }
		    System.out.println(dpSol[length]);
		}
		
		in.close();
	}
}

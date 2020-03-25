

public class Solution {


	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int number;
		for(int test = 0; test < T; test++) {
		    number = in.nextInt();
		    int [][][]dpSol = new int[number + 1][2][3];
		    for(int index = 0; index <= number; index++) {
		        for(int i = 0; i < 2; i++) {
		            for(int j = 0; j < 3; j++) {
		                dpSol[index][i][j] = -1;
		            }
		        }
		    }
		    System.out.println(count(dpSol, number, 1, 2));
		}
		
		in.close();
	}
	
	private static int count(int [][][]dpSol, int number, int bs, int cs) {
	    if(bs < 0 || cs < 0) {
	        return 0;
	    } else  if(number == 0) {
	        return 1;
	    } else if(bs == 0 && cs == 0) {
	        return 1;
	    }
	    if(dpSol[number][bs][cs] != -1) { return dpSol[number][bs][cs]; }
	    dpSol[number][bs][cs] = count(dpSol, number - 1, bs, cs) + count(dpSol, number - 1, bs - 1, cs) + count(dpSol, number - 1, bs, cs -1);
	    return dpSol[number][bs][cs];
	}
}

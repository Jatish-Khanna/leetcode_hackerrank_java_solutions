

public class Solution {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int number;
		for(int test = 0; test < T; test++) {
		    number = in.nextInt();
		    int []ar = new int[number * 2 + 2];
		    int xor = 0;
		    int first = 0;
		    int second = 0;
		    
		    for(int i = 0; i < ar.length; i++) {
		        ar[i] = in.nextInt();
		        xor ^= ar[i];
		    }
		    xor = xor & ~(xor - 1);
		    //System.out.println(xor);
		    for(int element : ar) {
		        if((xor & element) != 0) {
		            first ^= element;
		        } else {
		            second ^= element;
		        }
		    }
		    System.out.println(Math.min(first,second) + " " + Math.max(first,second));
		}
		in.close();
	}
}

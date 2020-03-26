

public class Solution {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		in.nextLine();
		for(int test = 0; test < T; test++) {
		    String first = in.nextLine();
		    String second = in.nextLine();
		    if(areMetaStrings(first.toCharArray(), second.toCharArray())) {
		        System.out.println(1);
		    } else {
		        System.out.println(0);
		    }
		}
		
		in.close();
	}
	
	private static boolean areMetaStrings(char []first, char []second) {
	    if(first.length != second.length) {
	        return false;
	    }
	    int count = 0;
	    int index = 0;
	    while(index < first.length) {
	        if(count > 2) {
	            return false;
	        } else if(first[index] != second[index]) {
	            count++;
	        }
	        index++;
	    }
	    return count == 2;
	}
}

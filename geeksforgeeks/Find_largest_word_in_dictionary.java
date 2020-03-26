

public class Solution {

	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int dictSize;
		for(int test = 0; test < T; test++) {
		    dictSize = in.nextInt();
		    in.nextLine();
		    String []dict = in.nextLine().split(" ");
		    String rawWord = in.nextLine();
		    int max = 0;
		    String maxWord = "";
		    for(String word  : dict) {
		        if(isSubsequence(word, rawWord)) {
		            if(max < word.length()) {
		                maxWord = word;
		                max = word.length();
		            }
		        }
		    }
		    System.out.println(maxWord);
		    //in.next();
		}
		
		in.close();
	}
	
	private static boolean isSubsequence(String word, String rawWord) {
	   int i = 0;
	   int j = 0;
	   char []first = word.toCharArray();
	   char []second = rawWord.toCharArray();
	   while(i < first.length && j < second.length) {
	       if(first[i] == second[j]) {
	           i++;
	       }
	       j++;
	   }
	   return i == first.length;
	}
}



public class Solution {

   public int heightChecker(int[] heights) {
       int []ar = new int[heights.length];
       System.arraycopy(heights, 0, ar, 0, heights.length);
       Arrays.sort(ar);
       int count = 0;
        for(int index = 0; index < ar.length; index++) {
            if(ar[index] != heights[index]) {
                count++;
            }
        }
        return count;
    }
}

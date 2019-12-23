
public class Solution {


    public int[] shortestToChar(String S, char C) {
        int size = S.length();
       int []left = new int[size];
        int []right = new int[size];
        int []result = new int[size];
        int leftS = size + 1;
        int rightS = size + 1;
        char []ar = S.toCharArray();
        for(int index = 0 ; index <size; index++) {
            int rIndex = size - 1 - index;
            if(ar[index] == C) {
                leftS = 0;
            } else {
                leftS++;
            }
            if(ar[rIndex] == C) {
                rightS = 0;
            } else {
                rightS++;
            }
            left[index] = leftS;
            right[rIndex] = rightS;
        }
        
        for(int index = 0; index < size; index++) {
            result[index] = Math.min(left[index], right[index]);
        }
        return result;
    }
}

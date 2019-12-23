

public class Solution {


    public int smallestRangeI(int[] A, int K) {
       int min = A[0];
       int max = A[0];
        
        
    for(int element : A) {
        if(element < min) {
            min = element;
        } 
        if(element > max) {
            max = element;
        }
    }
        int diff = max - min - K - K;
        return diff > 0 ? diff : 0;
    }
}

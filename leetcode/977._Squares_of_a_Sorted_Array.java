


public class Solution {

public int[] sortedSquares(int[] A) {
        int []result = new int[A.length];
        int low = 0;
        int high = A.length - 1;
        int rIndex = result.length - 1;
        while(low <= high) {
            if(Math.abs(A[low]) > Math.abs(A[high])) {
                result[rIndex] = A[low] * A[low];
                low++;
            } else {
                result[rIndex] = A[high] * A[high];
                high--;
            }
            rIndex--;
        }
        return result;
    }
}

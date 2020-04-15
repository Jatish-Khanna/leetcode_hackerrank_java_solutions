

public class Solution {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int index = A.length - 1; index > 1; index-- ) {
            if(A[index - 1] + A[index - 2] > A[index]) {
                return A[index - 1] + A[index - 2] + A[index];
            }
        }
        return 0;
    }
}

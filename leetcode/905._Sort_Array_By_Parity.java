
public class Solution {

public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length - 1;
        while(even < odd) {
            if(A[even] % 2 == 0) {
                even++;
            } else if(A[odd] % 2 != 0) {
                odd--;
            } else {
                swap(A, even, odd);
            }
        }
        return A;
    }
    
    public void swap(int []A, int even, int odd) {
        int temp = A[even];
        A[even] = A[odd];
        A[odd] = temp;
    }
}

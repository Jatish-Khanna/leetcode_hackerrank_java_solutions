public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        while(evenIndex < A.length && oddIndex < A.length) {
            if(A[evenIndex] % 2 == 1) {
                swap(A, evenIndex, oddIndex);
                oddIndex += 2;
            } else {
                evenIndex += 2;
            }
        }
        return A;
    }
    public void swap(int []A, int index, int oddIndex) {
        int temp = A[index];
        A[index] = A[oddIndex];
        A[oddIndex] = temp;
    }
}

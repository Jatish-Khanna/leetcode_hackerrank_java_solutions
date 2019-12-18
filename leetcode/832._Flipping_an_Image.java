

public class Solution {

public int[][] flipAndInvertImage(int[][] A) {
        int cols = A[0].length;
            
        for(int row = 0; row < A.length; row++) {
            for(int col = 0; col < cols / 2; col++) {
                int temp = A[row][col];
                A[row][col] = A[row][cols - col - 1] ^ 1;
                A[row][cols - col - 1] = temp ^ 1;
            }
            if(cols % 2 != 0) {
                A[row][cols / 2] = A[row][cols/2] ^ 1;
            }
        }
        return A;
    }
}



public class Solution {


    public int[] sumZero(int n) {
        int positive = 1;
        int negative = -1;
        int positiveIndex = n/2 + 1;
        int negativeIndex = n/2 - 1;
        int []result = new int[n];
        if(n % 2 == 1) {
            result[n/2] = 0;
        } else {
            positiveIndex--;
        }
        
        while(negativeIndex >= 0) {
            result[negativeIndex--] = negative--;
            result[positiveIndex++] = positive++;
        }
        return result;
    }
}

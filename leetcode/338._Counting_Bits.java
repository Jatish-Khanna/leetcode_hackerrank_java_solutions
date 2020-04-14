

public class Solution {


    public int[] countBits(int num) {
        int[] ar = new int[num+1];
        int count;
        for(int index = 1; index <= num; index++) {
            count = count1s(index);
            ar[index] = count;
        }
        return ar;
    }
    
    private int count1s(int number) {
        int count = 0;
        while(number > 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }
}

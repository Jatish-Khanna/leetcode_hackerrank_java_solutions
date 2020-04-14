

public class Solution {
  
    // Faster as the solution suggests - a simple dynamic programming approach
    
    public int[] countBits(int num) {
        int[] ar = new int[num+1];
        if(num == 0) {
            return ar;
        }
        
        ar[1] = 1;
        for(int index = 1; index <= num; index++) {
            if(index % 2 != 0) {
                ar[index] = 1;
            } 
            ar[index] += ar[index/2];
        }
        return ar;
    }

    
    // Slower solution

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



public class Solution {


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) { return 0;}
        
        int product = 1;
        int start = 0;
        int count = 0;
        
        for(int index = 0; index < nums.length; index++) {
            product *= nums[index];
            while(product >= k) {
                product /= nums[start++];
            }
            count += index - start + 1;
        }
        return count;
    }
}

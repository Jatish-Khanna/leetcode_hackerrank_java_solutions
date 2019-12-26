

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int startIndex = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for(int index = 0; index < nums.length; index++) {
            sum += nums[index];
            if(sum >= s) {
                while(startIndex < index && sum - nums[startIndex] >= s) {
                    sum -= nums[startIndex];
                    startIndex++;
                }
                length = Math.min(length, index - startIndex  + 1);
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
     }
}

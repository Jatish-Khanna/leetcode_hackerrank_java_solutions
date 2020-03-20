

public class Solution {

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) { return 0; }
        int []length = new int[nums.length];
        int max = 1;
        Arrays.fill(length, 1);
        for(int index = 1; index < nums.length; index++) {
            for(int current = 0; current < index; current++) {
                if(nums[current] < nums[index] && length[current] + 1 > length[index]) {
                    length[index] = length[current] + 1;
                }
            }
            max = Math.max(max, length[index]);
        }
        
        return max;
    }
}

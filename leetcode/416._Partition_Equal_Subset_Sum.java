

public class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) {
           total += num;
        }
        
        if(total % 2 != 0) { return false; }
        return isSubsetPossible(nums.length - 1, total / 2, nums);
    }
    
    public boolean isSubsetPossible(int index, int target, int []nums) {
        if(index < 0 || target < 0) { return false; }
        if(target == 0) { return true; }
        if(nums[index] > target) { return false; }
        return isSubsetPossible(index - 1, target - nums[index], nums) || isSubsetPossible(index - 1, target, nums);
    }
}

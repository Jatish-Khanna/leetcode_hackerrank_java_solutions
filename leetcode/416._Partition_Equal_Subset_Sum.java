

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
    
    // Slow solution in terms of Memory and CPU cycle when compared to recursive approach
        public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) {
           total += num;
        }
        
        if(total % 2 != 0) { return false; }
        total = total / 2;
       
        boolean [][]dpSol = new boolean[total + 1][nums.length + 1];
        Arrays.fill(dpSol[0], true);
        
        for(int sum = 1; sum <= total; sum++) {
            for(int element = 1; element <= nums.length; element++) {
                dpSol[sum][element] = dpSol[sum][element - 1];
                if(sum >= nums[element - 1]) {
                    dpSol[sum][element] = dpSol[sum][element -1 ] || dpSol[sum - nums[element - 1]][element - 1];
                }
            }
        }
        return dpSol[total][nums.length];
    }
}

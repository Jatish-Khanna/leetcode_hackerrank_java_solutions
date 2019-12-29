

public class Solution {


    public int firstMissingPositive(int[] nums) {
        // Cyclic sort algorithm
        for(int index = 0; index < nums.length;) {
            if(nums[index] <= 0 || nums[index] > nums.length || nums[index] == nums[nums[index]-1]) {
                index++;
            } else {
            swap(nums, index, nums[index] - 1);
            }
        }
        
        for(int index = 1; index <= nums.length; index++) {
            if(nums[index - 1] != index) {
                return index;
            }
        }
        return nums.length + 1;
    }
    
    public void swap(int []nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}

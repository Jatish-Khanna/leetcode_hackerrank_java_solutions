
public class Solution {

    // Faster solution with single pointer
        public int removeDuplicates(int[] nums) {
        if(nums.length == 0) { return 0;}

        int index = 0;
        for(int element : nums) {
            if(index < 2 || nums[index - 2] < element) {
                nums[index++] = element;
            }
        }
        return index;
    }

    
    
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) { return 0;}
       int prev = nums[0];
       int count = 1;
        int total = 1;
        for(int index = 1; index < nums.length; index++) {
            if(prev == nums[index]) {
                count++;
            } else {
                count = 1;
                prev = nums[index];
            }
            if(count <= 2) {
                total++;
            }
            nums[total - 1] = nums[index];
        }
        return total;
    }
}

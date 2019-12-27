
public class Solution {

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

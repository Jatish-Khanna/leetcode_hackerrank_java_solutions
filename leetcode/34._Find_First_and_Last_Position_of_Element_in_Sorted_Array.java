

public class Solution {


    public int[] searchRange(int[] nums, int target) {
        
        int []result = {-1, -1};
        if(nums.length == 0) { return result;}
        
        
        int start = 0;
        int end = nums.length - 1;
        int mid;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
                result[0] = mid;
                break;
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if(result[0] == -1) { return result; };
        start = result[0];
        end = nums.length - 1;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == nums.length - 1 || nums[mid + 1] > target) && nums[mid] == target) {
                result[1] = mid;
                break;
            } else if(nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}

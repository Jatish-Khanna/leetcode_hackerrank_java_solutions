

public class Solution {


    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0) { return -1; }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end) {
            mid = start + (end - start) / 2;
            
            if(start == end) { return nums[start]; }
            
            if(mid % 2 == 0) {
                if(nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid;
                }
            } else {
                if(nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[start];
    }
}

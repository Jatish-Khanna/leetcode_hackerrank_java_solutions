

public class Solution {

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) { return -1; }
        return searchUtil(0, nums.length - 1, nums, target);
    }
    
    private int searchUtilRecurse(int start, int end, int []nums, int target) {
        if(start > end) { return -1;}
        int mid = start + (end - start) / 2;
        if(nums[mid] < target) {
            return searchUtil(mid + 1, end, nums, target);
        } else if(nums[mid] > target) {
            return searchUtil(start, mid - 1, nums, target);
        } else {
            return mid;
        }
    }
    
    private int searchUtil(int start, int end, int []nums, int target) {
        int mid;
        while(start <= end) {
        mid = start + (end - start) / 2;
        if(nums[mid] < target) {
            start = mid + 1;
        } else if(nums[mid] > target) {
            end = mid - 1;
        } else {
            return mid;
        }
        }
        return -1;
    }
}

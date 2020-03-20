

public class Solution {
    
    // Binary search O(n logn)
        public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) { return 0; }
        
        int []element = new int[nums.length];
        int max = 1;
        element[0] = nums[0];
        int last;
        for(int index = 1; index < nums.length; index++) {
            last = binarySearch(element, 0, max, nums[index]);
            
            if(last >= max) {
                element[max++] = nums[index];
            } else {
                element[last] = nums[index];
            }
        }
        return max;
    }
    
    private int binarySearch(int []element, int start, int end, int target) {
        int mid;
        //element[end] = -1;
        while(start < end) {
            mid = start + (end - start) / 2;
            if(element[mid] == target) {
                return mid;
            } else if(element[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    // Commented Arrays.fill
        public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) { return 0; }
        int []length = new int[nums.length];
        int max = 1;
        //Arrays.fill(length, 1);
        length[0] = 1;
        for(int index = 1; index < nums.length; index++) {
            length[index] = 1;
            for(int current = 0; current < index; current++) {
                if(nums[current] < nums[index] && length[current] + 1 > length[index]) {
                    length[index] = length[current] + 1;
                }
            }
            max = Math.max(max, length[index]);
        }
        
        return max;
    }
    
    
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

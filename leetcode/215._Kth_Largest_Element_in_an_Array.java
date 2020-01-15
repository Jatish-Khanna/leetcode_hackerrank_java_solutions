

public class Solution {

// Quick Select - approach linear sort
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums, k - 1);
    }
    
    public int quickSelect(int start, int end, int []nums, int k) {
        if(start == end) { return nums[start]; }
        
        int pivot = nums[end], left = start; 
        for (int right = left; right < end; right++) 
        { 
            if (nums[right] >= pivot) 
            { 
                swap(nums, left, right); 
                left++; 
            } 
        } 
        swap(nums, left, end); 
        
        if (left - start > k) {
            return quickSelect(start, left - 1, nums,  k);
        }
        
        if (left - start < k) {
            return quickSelect(left + 1, end, nums,  k - left - 1 + start);
        }
        
        return nums[left];
    }

// Priority Queue - Slow solution 
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num : nums) {
            if(pq.size() == k) {
                if(pq.peek() > num) {continue;}
                else { pq.offer(num); pq.remove(); }
            }
            else if(pq.size() < k) { pq.offer(num); } 
        }
        return pq.peek();
    }
}

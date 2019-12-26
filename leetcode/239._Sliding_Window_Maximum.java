

public class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        int []result = new int[nums.length - k + 1];
        int rIndex = 0;
        for(; index < k; index++) {
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[index]) {
                queue.removeLast();
            }
            queue.add(index);
        }
        //System.out.println(queue);
        for(; index < nums.length; index++) {
            result[rIndex++] = nums[queue.peek()];
            
            while(!queue.isEmpty() && queue.peek() <= index - k) {
                queue.remove();
            } 
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[index]) {
                queue.removeLast();
            }
            queue.add(index);
        }
        result[rIndex] = nums[queue.peek()];
        return result;
    }
    
    // The approach is O(N) where left and right arrays are used using DP solution
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int size = nums.length;
        int []result = new int[size - k + 1];

        int []left = new int[size];
        int []right = new int[size];
        left[0] = nums[0];
        right[size - 1] = nums[size - 1];
        
        for(int index = 1; index < size; index++) {
            if(index % k == 0) {
                left[index] = nums[index];
            } else {
                left[index] = Math.max(left[index - 1], nums[index]);
            }
            
            int rt = size - index - 1;
            if(rt % k == (k - 1)) {
                right[rt] =  nums[rt];
            } else {
                right[rt] = Math.max(right[rt + 1], nums[rt]);
            }
            
        }
        
        for (int i = 0, j = i + k - 1; j < size; ++i, ++j) {
            result[i] = Math.max(left[j], right[i]);
        }
        
        
        return result;
    }
}

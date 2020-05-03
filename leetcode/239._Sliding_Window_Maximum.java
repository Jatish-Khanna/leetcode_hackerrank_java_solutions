

public class Solution {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int size = nums.length;
        int []result = new int[size - k + 1];
        
        Deque<Integer> max = new ArrayDeque<>();
        int i = 0;
        int j;
        for(j = 0; j < k; j++) {
            while(!max.isEmpty() && nums[max.peekLast()] < nums[j]) max.removeLast();
            max.add(j);
        }
        int index = 0;
        for(; j < size; j++) {
            result[index++] = nums[max.peek()];
            while(!max.isEmpty() && nums[max.peekLast()] < nums[j]) max.removeLast();
            max.add(j);
            if(i == max.peek()) {
                max.poll();
            }
            i++;
        }
        result[index] = nums[max.peek()];
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

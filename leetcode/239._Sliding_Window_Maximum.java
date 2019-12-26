

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
}

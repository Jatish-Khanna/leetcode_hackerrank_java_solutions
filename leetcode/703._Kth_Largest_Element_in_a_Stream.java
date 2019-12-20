

public class Solution {


    PriorityQueue<Integer> largest = new PriorityQueue<>();
    int capacity;
    public KthLargest(int k, int[] nums) {
        this.capacity = k;
        for(int val : nums) {
            add(val);
        }
    }
    
    public int add(int val) {
        if(largest.size() >= capacity) {
            if(val > largest.peek()) {
                largest.poll();
                largest.offer(val);
            }
        } else {
            largest.offer(val);
        }
        return largest.peek();
    }
}

class Solution {
    public int maximumProduct(int[] nums) {
        int min1 = 1001;
        int min2 = min1;
        PriorityQueue<Integer> max = new PriorityQueue<>();
        
        for(int element : nums) {
            max.offer(element);
            if(max.size() > 3) {
                max.poll();
            }
            
            
            if(element < min1) {
                min2 = min1;
                min1 = element;
            } else if(element < min2) {
                min2 = element;
            }
        }
        
        int result = max.poll() * max.poll();
        
        int high = max.poll();
        System.out.println(result +" " + high + " " + min1 + " " + min2 );
        return Math.max(result * high, high * min1 * min2);
    }
}

class Solution {
    
    // Faster solution

    public int maximumProduct(int[] nums) {
        int m1 = -1002;
        int m2 = -1002;
        int m3 = -1002;
        int s1 = 1001;
        int s2 = 1001;
        int tmp;
        for(int num : nums) {
            if(m3 < num) {
                m3 = num;
                if(m2 < num) {
                    m3 = m2;
                    m2 = num;
                    if(m1 < num) {
                        m2 = m1;
                        m1 = num;
                    }
                }
            }
            
            if(s2 > num) {
                s2 = num;
                if(s1 > num) {
                    s2 = s1;
                    s1 = num;
                }
            }
        }
        
        
        return Math.max(m1 * m2 * m3, m1 * s1 * s2);
    }

    
    // SLower solution due to priority queue
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

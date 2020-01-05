

public class MedianFinder {



    /** initialize your data structure here. */
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        // Max numbers
        pq1 = new PriorityQueue<>();
        // Min
        pq2 = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(pq2.size() == 0) {
            pq2.offer(num);
            return;
        }
        
        
        if(pq1.size() == pq2.size()) {
            if(pq1.peek() >= num) {
                pq2.offer(num);
            } else {
                pq2.offer(pq1.poll());
                pq1.offer(num);
            }
        } else {
            if(pq2.peek() <= num) {
                pq1.offer(num);
            } else {
                pq1.offer(pq2.poll());
                pq2.offer(num);
            }
        }
        //System.out.println(pq1);
        //System.out.println(pq2);
    }
    
    public double findMedian() {
            
        if(pq1.size() == pq2.size()) {
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else {
            return pq1.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

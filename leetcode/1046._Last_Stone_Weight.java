import java.util.*;


public class Solution {

public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> sHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : stones) {
            sHeap.offer(val);
        }
        int a, b;
        
        while(sHeap.size() > 1) {
            a = sHeap.poll();
            b = a - sHeap.poll();
           
            if(b > 0) {
                sHeap.offer(b);
            }
            //System.out.println(sHeap);
        }
        return sHeap.isEmpty() ? 0 : sHeap.peek();
    }
}

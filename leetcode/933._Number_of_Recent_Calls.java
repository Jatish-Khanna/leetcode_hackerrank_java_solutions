

public class RecentCounter {


    Queue<Integer> queue;
    public RecentCounter() {
         queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        
        queue.offer(t);
        int limit = t - 3000;
        while(limit > queue.peek()) {
            queue.poll();
        }
        return queue.size();
    }
}


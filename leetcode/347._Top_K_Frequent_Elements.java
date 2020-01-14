
public class Solution {

 static class Point {
         int key;
        int count;
        //boolean partOf;
        Point(int key, int count) {
            this.key = key;
            this.count = count;
        }
        

    }
        public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Point> heap = new PriorityQueue<Point>(8, (e1, e2) -> {
            if(e1.count == e2.count) {
                return e1.key - e2.key;
            } else {
            return e1.count - e2.count;
            }
        });
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
       
        
        for(Integer key : map.keySet()) {
            heap.offer(new Point(key, map.get(key)));
            if(heap.size() > k) { heap.poll(); }
            
        }
        List<Integer> result = new ArrayList<>();
        while(!heap.isEmpty()) {
            result.add(heap.poll().key);
        }
            return result;
    }
}

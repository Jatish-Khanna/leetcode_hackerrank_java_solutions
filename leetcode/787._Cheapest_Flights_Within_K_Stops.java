

public class Solution {

  static class Node {
          int dest;
        int price;
        Node(int dest, int price) {
            this.dest = dest;
            this.price = price;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        HashMap<Integer, List<Node>> labels = new HashMap<>();
        for(int []flight : flights) {
            labels.put(flight[0], labels.getOrDefault(flight[0], new ArrayList<>()));
            labels.get(flight[0]).add(new Node(flight[1], flight[2]));
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(src, 0));
        int levels = 0;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty() && levels <= K + 1) {
            int size = queue.size();
            while(size-- > 0) {
                Node node = queue.poll();
                if(node.price > min) { continue; }
                if(node.dest == dst) { min = Math.min(min, node.price); }
                if(labels.containsKey(node.dest)) {
                    for(Node current : labels.get(node.dest)) {
                        if(current.price + node.price > min) { continue;}
                        queue.add(new Node(current.dest, current.price + node.price));
                    }
                }
            }
            
            levels++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

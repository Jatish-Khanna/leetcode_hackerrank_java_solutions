

public class Solution {
  static class Node {
  
           int f1;
        int f2;
        int sum;
        Node(int f1, int f2) {
            this.f1 = f1;
            this.f2 = f2;
            this.sum = f1 + f2;
        }
    }
    
  // With optimized version - Add the next element pair of currently encountered
     
    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(num1 == null || num2 == null || num1.length == 0 || num2.length == 0 || k == 0) { return result; }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>((e1, e2) ->  e1.sum - e2.sum);
        for(int id = 0; id < num1.length; id++) {
            queue.offer(new Node(num1[id], num2[0], 0));
        }
        
        
        while(k-- > 0 && !queue.isEmpty()) {
            Node tmp = queue.poll();
            result.add(Arrays.asList(tmp.f1, tmp.f2));
            if(tmp.index == num2.length - 1) { continue; }
            queue.offer(new Node(tmp.f1, num2[tmp.index + 1], tmp.index + 1));
        }
    
        return result;
    }

  
  
  // With Max queue
    public List<List<Integer>> kSmallestPairs(int[] num1, int[] num2, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if(num1 == null || num2 == null || num1.length == 0 || num2.length == 0) { return result; }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>((e1, e2) ->  e2.sum - e1.sum);
        
    
    int currSum = 0;
    for(int index = 0; index < num1.length; index++) {
        for(int id = 0; id < num2.length; id++) {
            Node tmp = new Node(num1[index], num2[id]);
            if(queue.size() == k && queue.peek().sum > tmp.sum) {
                queue.poll();
                queue.offer(tmp);
            } else if(queue.size() < k) {
                queue.offer(tmp);
            }
        }
    }
    
    List<Integer> subList;
    while(!queue.isEmpty()) {
        subList = new ArrayList<>();
        Node tmp = queue.poll();
        subList.add(tmp.f1);
        subList.add(tmp.f2);
        result.addFirst(subList);
    }
    return result;
    }
}

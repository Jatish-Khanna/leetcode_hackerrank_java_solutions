

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



public class Solution {

 // Correct Solution
 
    public boolean isNStraightHand(int[] hand, int W) {
        Arrays.sort(hand);
        int n=hand.length;
        
        if(n % W!=0)return false;
        
        boolean[] visited = new boolean[n];
        
        int current = 0;
        int next = 0;
        int size = 0;
        int prev = -1;
        
        while(current < n) {
            if(visited[current]) {
                current++;
                continue;
            }
            size = 1;
            visited[current] = true;
            prev = hand[current];
            next = current + 1;
            
            while(size < W && next < n) {
                if(visited[next] || hand[next] == prev) {
                    next++;
                    continue;
                } else if(prev + 1 == hand[next]) {
                    size++;
                    visited[next] = true;
                    prev = hand[next];
                    next++;
                } else {
                    return false;
                }
            }
            if(size < W && next == n) { return false; }
            current++;
        }
        
        return true;
    }

 
 // Incorrect Solution
 
    public boolean isNStraightHand(int[] hand, int W) {
        int remainder = hand.length % W;
        if(remainder != 0) {
            return false;
        } else {
            int []bucket = new int[W];
            for(int element : hand) {
                bucket[element % W]++;
            }
            for(int index = 1; index < W; index++ ) {
                if(bucket[index - 1] != bucket[index]) {
                    return false;
                }
            }
            return true;
        }
    }
}

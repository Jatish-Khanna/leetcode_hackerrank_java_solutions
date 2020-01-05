

public class Solution {

    public String largestNumber(int[] nums) {
        if(nums != null && nums.length == 0) { return "0"; }
        PriorityQueue<String> queue = new PriorityQueue<String>((s1, s2) -> (s2+s1).compareTo(s1+s2));
    
        for(int num : nums) {
            queue.offer(String.valueOf(num));
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        
        return trimZeroAtFront(sb.toString());
    }
    
    public String trimZeroAtFront(String string) {
        for(char c : string.toCharArray())
            if(c != '0') return string;
        
        return "0";
    }
}



public class Solution {
    
    // Fastest
        public String largestNumber(int[] nums) {
        Comparator<String> cmp = (s1,s2) -> (s2 + s1).compareTo(s1 + s2);
        String []n = new String[nums.length];
        for(int index =0; index < nums.length; index++) {
            n[index] = String.valueOf(nums[index]);
        }
        Arrays.sort(n, cmp);
        if(n[0].equals("0")) { return "0"; }
        StringBuilder sb = new StringBuilder();
        for(String s : n) {
            sb.append(s);
        }
        return sb.toString();
    }
       

    // Optimized solution 
    
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
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
    
    
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



public class Solution {

    // Optimized solution 
    
    public List<Integer> partitionLabels(String S) {
        int []rs = new int[26];
        
        // Get the rightmost position
        for(int index = 0; index < S.length(); index++) {
            rs[S.charAt(index) - 'a'] = index;
        }
        
        int maxRight = 0;
        int current = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int index = 0; index < S.length(); index++) {
            // Number of chars in current label
            current = index;
            maxRight = rs[S.charAt(index) - 'a'];
            while(current < maxRight) {
                maxRight = Math.max(rs[S.charAt(current) - 'a'], maxRight);
                current++;
            } 
            
            result.add(maxRight - index + 1); // Length
            index = maxRight;
        }
        return result;
    }


    public List<Integer> partitionLabels(String S) {
        int []rs = new int[26];
        
        // Get the rightmost position
        for(int index = 0; index < S.length(); index++) {
            rs[S.charAt(index) - 'a'] = index;
        }
        
        int maxRight = -1;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        
        for(int index = 0; index < S.length(); index++) {
            // Number of chars in current label
            count++;
            if(maxRight < rs[S.charAt(index) - 'a']) {
                maxRight = rs[S.charAt(index) - 'a'];
            } 
            if(maxRight == index) {
                result.add(count); // Length
                count = 0;
            }
        }
        return result;
    }
}



public class Solution {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            
            if(Integer.toString(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    
    // Slower solution 
        public int findNumbersTernary(int[] nums) {
        int count = 0;
        for(int num : nums) {
            count += String.valueOf(num).length() % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}

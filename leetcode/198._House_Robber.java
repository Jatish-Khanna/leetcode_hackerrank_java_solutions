

public class Solution {


    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int include = nums[0];
        int notInclude = 0;
        int total;
        for(int i = 1; i < n; i++){
            total = nums[i] + notInclude;
            if(include > notInclude) {
              notInclude = include;  
            } 
            include = total;
        }
        return include > notInclude ? include : notInclude;
    }
}

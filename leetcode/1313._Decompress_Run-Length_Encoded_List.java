

public class Solution {


    public int[] decompressRLElist(int[] nums) {
        
        int size = 0;
        for(int index = 0; index < nums.length; index += 2) {
            size += nums[index];
        }
        
        int []result = new int[size];
        int rIndex = 0;
        int count;
        for(int index = 0; index < nums.length; index += 2) {
            count = nums[index];
            while(count-- > 0) {
                result[rIndex++] = nums[index + 1];
            }
        }
        return result;
    }
}

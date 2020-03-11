

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int []result = new int[nums.length];
        int []count = new int[101];
        for(int number : nums) {
            count[number]++;
        }
        
        for(int index = 1; index < count.length; index++) {
            count[index] += count[index - 1];
        }
        
        int index = 0;
        for(int number : nums) {
            if(number > 0) {
                result[index] = count[number - 1];
            }
            index++;
        }
        return result;
    }
}

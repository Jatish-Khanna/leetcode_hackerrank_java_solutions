

public class Solution {


    int []sumArray;
    
    public NumArray(int[] nums) {
        sumArray = new int[nums.length + 1];
        
        for(int index = 1; index < sumArray.length; index++) {
            sumArray[index] = sumArray[index - 1] + nums[index - 1];
        }
    }
    
    public int sumRange(int i, int j) {
            return sumArray[j + 1] - sumArray[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []result = new int[nums.length];
        int mul = nums[0];
        result[0] = 1;
        for(int index = 1; index < nums.length; index++) {
            result[index] = mul;
            mul *= nums[index];
        }
        
        mul = nums[nums.length - 1];
        for(int index = nums.length - 2; index >= 0; index--) {      
            result[index] *= mul;
            mul *= nums[index];
        }
        return result;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        if(max == 0 && nums.length == 1) {
            return true;
        }
        int i = 0;
        
        while(i < max && max < nums.length){ // if max==0, that means no jump possible
            // max--;// decrease the previous jump value because we already used one
            max = Math.max(max, nums[i++] + i); // check if we got bigger jump
            // System.out.println(max);
        }
        return max>=nums.length;
        
    }
}

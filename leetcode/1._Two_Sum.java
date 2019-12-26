

public class Solution {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            
            if(seen.containsKey(target - nums[index])) {
                return new int[] {seen.get(target - nums[index]), index};
            }
            seen.put(nums[index], index);
        }
        return new int[0];
    }
}

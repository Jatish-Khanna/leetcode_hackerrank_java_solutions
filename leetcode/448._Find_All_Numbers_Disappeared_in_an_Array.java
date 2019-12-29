
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int element : nums) {
            int index = Math.abs(element) - 1;
            nums[index] = -Math.abs(nums[index]);
        }
        List<Integer> list = new ArrayList<>();
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] > 0) {
                list.add(index+1);
            }
        }
        return list;
    }
}

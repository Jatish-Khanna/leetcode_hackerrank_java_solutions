

public class Solution {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) { return result; }
        
        permuteUtil(0, nums, result);
        return result;
    }
    
    private void permuteUtil(int index, int []nums, List<List<Integer>> result) {
        if(index == nums.length -1) {
            ArrayList<Integer> sList = new ArrayList<>();
            for(int element : nums) {
                sList.add(element);
            }
            result.add(sList);
            return;
        }
        
        for(int start = index ; start < nums.length; start++) {
            // Swap
            swap(nums, start, index);
            permuteUtil(index + 1, nums, result);
            // Swap back
            swap(nums, start, index);
        }
    }
    
    private void swap(int []nums, int first, int second) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}

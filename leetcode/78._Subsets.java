

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) { return result; }
        
        subsetsUtil(0, new boolean[nums.length], nums, result);
        return result;
    }
    
    
    // First include the element and then exclude the element
    // Result - [[1,2,3],[1,2],[1,3],[1],[2,3],[2],[3],[]]
    
    private void subsetsUtil(int index, boolean []partOf, int[]nums, List<List<Integer>> result) {
        if(index == nums.length) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int id = 0; id < partOf.length; id++) {
                if(partOf[id]) { sublist.add(nums[id]); }
            }
            result.add(sublist);
            return;
        }
        partOf[index] = true;
        subsetsUtil(index + 1, partOf, nums, result);
        partOf[index] = false;
        subsetsUtil(index + 1, partOf, nums, result);
    }
    
    // First Exclude the element and then include it
    
    private void subsetsUtil(int index, boolean []partOf, int[]nums, List<List<Integer>> result) {
        if(index == nums.length) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int id = 0; id < partOf.length; id++) {
                if(partOf[id]) { sublist.add(nums[id]); }
            }
            result.add(sublist);
            return;
        }
        subsetsUtil(index + 1, partOf, nums, result);
        partOf[index] = true;
        subsetsUtil(index + 1, partOf, nums, result);
        partOf[index] = false;
    }
    
    // Recurrse from the behind and include the first element of Array first
        public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) { return result; }
        
        subsetsUtil(nums.length - 1, new boolean[nums.length], nums, result);
        return result;
    }
    
    
        private void subsetsUtil(int index, boolean []partOf, int[]nums, List<List<Integer>> result) {
        if(index == -1) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int id = 0; id < partOf.length; id++) {
                if(partOf[id]) { sublist.add(nums[id]); }
            }
            result.add(sublist);
            return;
        }
        subsetsUtil(index - 1, partOf, nums, result);
        partOf[index] = true;
        subsetsUtil(index - 1, partOf, nums, result);
        partOf[index] = false;
    }
    
}

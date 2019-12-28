

public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) { return result;}
        Arrays.sort(nums);
        
        int size = nums.length;
        for(int index = 0; index < size - 2; index++) {
            if(index > 0 && nums[index] == nums[index - 1]) { continue;}
            int low = index + 1;
            int high = size - 1;
            while(low < high) {
                
                if(high < size - 1 && nums[high] == nums[high + 1]) {
                    high--;
                    continue;
                }
                
                int sum = nums[index] + nums[low] + nums[high];
                if(sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    low++;
                    high--;
                } else if(sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return result;
    }
}

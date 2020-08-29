

public class Solution {
   
    // Optimization by skipping more elements
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums == null || nums.length < 3) return result;
    Arrays.sort(nums);
    int i = 0;
    while(nums[i] <= 0 && i < nums.length - 1) {
      if(nums[i] > 0) return result;
      if(i > 0 && nums[i] == nums[i-1]) {
        i++;
        continue;
    }
      int left = i + 1;
      int right = nums.length - 1;
      int target = 0 - nums[i];
      while(left < right ) {
        if(nums[left] + nums[right] < target) left++;
        else if(nums[left] + nums[right] > target) right--;
        else {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(nums[i]);
          tmp.add(nums[left]);
          tmp.add(nums[right]);
          result.add(tmp);
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        }
      }
      i++;
    }
    return result;
  }
    
    

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

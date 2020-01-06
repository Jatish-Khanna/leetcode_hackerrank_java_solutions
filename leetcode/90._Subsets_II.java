

public class Solution {


    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    subsetsWithDupUtil(0, new ArrayList<>(), nums, result);
    return result;
  }

  private void subsetsWithDupUtil(int index, List<Integer> sublist, int[] nums,
      List<List<Integer>> result) {
    result.add(new ArrayList<>(sublist));
    for (int start = index; start < nums.length; start++) {
        // Add element to the subset
      sublist.add(nums[start]);
      subsetsWithDupUtil(start + 1, sublist, nums, result);
        // remove element from the subset
      sublist.remove(sublist.size() - 1);

        // Skip all the element already seen
      while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
        start++;
      }
    }
  }
}

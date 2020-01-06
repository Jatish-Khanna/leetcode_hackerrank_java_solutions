

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
    // Skip all the elements which are already seen earlier
    for (int start = index; start < nums.length; start++) {
      sublist.add(nums[start]);
      while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
        start++;
      }

      subsetsWithDupUtil(start + 1, sublist, nums, result);
      sublist.remove(sublist.size() - 1);

    }
  }

  public static void main(String[] args) {
    System.out
        .println(new Solution().subsetsWithDup(new int[] {1,2,2,2}));
  }
}

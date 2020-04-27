class Solution {
    public List<Integer> minSubsequence(int[] nums) {
       Arrays.sort(nums);
        int sum = 0;
       for(int num : nums) {
           sum += num;
       }
        int index = nums.length - 1;
        int current = 0;
        List<Integer> list = new ArrayList<>();
        sum = sum / 2;
        sum++;
        while(current < sum && index >= 0) {
            current += nums[index];
            list.add(nums[index]);
            index--;
        }
        return list;
    }
}

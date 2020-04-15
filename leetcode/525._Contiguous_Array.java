

public class Solution {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int n = nums.length;
        int maxLength = 0;
        int endIndex = 0;
        for(int index = 0; index < n; index++) {
            sum += (nums[index] == 0) ? -1 : 1;
            if(sum == 0) {
                maxLength = index + 1;
                endIndex = index;
            } else if(map.containsKey(sum + n)) {
                if(maxLength < index - map.get(sum + n)) {
                    maxLength = index - map.get(sum + n);
                    endIndex = index;
                }
            } else {
                map.put(sum + n, index);
            }
        }
        return maxLength;
    }
}

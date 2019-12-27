
public class Solution {

    // Faster solution with single pointer
        public int removeDuplicates(int[] nums) {
        if(nums.length == 0) { return 0;}

        int index = 0;
        for(int element : nums) {
            if(index < 2 || nums[index - 2] < element) {
                nums[index++] = element;
            }
        }
        return index;
    }

    public int findDuplicate(int[] nums) {
        
        for(int num : nums) {
            int n = Math.abs(num);
            if(nums[n - 1] < 0) {
                return n;
            }
            nums[n - 1] = -nums[n - 1];
        }
        return 0;
    }
    
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) { return 0;}
       int prev = nums[0];
       int count = 1;
        int total = 1;
        for(int index = 1; index < nums.length; index++) {
            if(prev == nums[index]) {
                count++;
            } else {
                count = 1;
                prev = nums[index];
            }
            if(count <= 2) {
                total++;
            }
            nums[total - 1] = nums[index];
        }
        return total;
    }
    
    // Tortoise and hare approach is best and fastest of all
    public int findDuplicate(int[] nums) {
        
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
}

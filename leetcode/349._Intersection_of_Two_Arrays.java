
public class Solution {

public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> found = new HashSet<>();
        for(int num : nums1) { 
          found.add(num);
        }
        HashSet<Integer> found2 = new HashSet<>();
        for(int num : nums2) {
            if(found.contains(num)) {
                found2.add(num);
            }
        }
        int index = 0;
        int []result = new int[found2.size()];
        for(Integer val : found2) {
            result[index++] = val;
        }
        return result;
    }
}

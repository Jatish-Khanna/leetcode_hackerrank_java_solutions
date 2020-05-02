class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = nextGreater(nums2);
        int []result = new int[nums1.length];
        int index = 0;
        for(int num : nums1) {
            if(map.containsKey(num)) {
                result[index] = nums2[map.get(num)];
            } else {
                result[index] = -1;
            }
            index++;
        }
        return result;
    }
    
    private Map<Integer, Integer> nextGreater(int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = nums2.length - 1;
        while(id >= 0) {
            
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[id]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                map.put(nums2[id], stack.peek());
            }
            stack.push(id);
            id--;
        }
        // System.out.println(map);
        return map;
    }
}



public class Solution {

   public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        Set<Integer> vals = new HashSet<>(map.values());
        return vals.size() == map.size();
    }
}

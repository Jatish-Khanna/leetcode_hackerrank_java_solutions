
public class Solution {

    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int result = 0;
        for(int index = 0; index < tree.length; index++) {
            map.put(tree[index], map.getOrDefault(tree[index], 0) + 1);
            while(map.size() > 2) {
                map.put(tree[start], map.get(tree[start]) - 1);
                if(map.get(tree[start]) == 0) { map.remove(tree[start]);}
                start++;
            }
            result = Math.max(result, index - start + 1);
        }
        return result;
    }
}

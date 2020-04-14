

public class Solution {


    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int value;
        int lasthigh = z;
        int mid;
        for(int index = 1; index <= z; index++) {
            int low = 1;
            int high = lasthigh;
            
            
            while(low <= high) {
                
                mid = low + (high - low) /2;
                value = customfunction.f(index, mid);
                
                if(value == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    list.add(mid);
                    result.add(list);
                    lasthigh = high - 1;
                    break;
                } else if(value < z) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}


public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       HashMap<Integer, Integer> count = new HashMap<>();
       TreeSet<Integer> list = new TreeSet<>();
        for(int element : arr1) {
            list.add(element);
            count.put(element, count.getOrDefault(element, 0) + 1);
        }
        
        int []result = new int[arr1.length];
        int index = 0;
        
        for(int element : arr2) {
            int size = count.get(element);
            while(size-- > 0) {
                result[index++] = element;
            }
            count.remove(element);
            list.remove(element);
        }
        
        
        for(int  element : list) {
            int size = count.get(element);
            while(size-- > 0) {
                result[index++] = element;
            }
        }
        return result;
    }
}

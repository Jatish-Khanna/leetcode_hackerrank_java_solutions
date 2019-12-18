

public class Solution {

   public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
       for(int element : A) {
         if(set.contains(element)) {
             return element;
         }   
         set.add(element);
       }
    return -1;
    }
}

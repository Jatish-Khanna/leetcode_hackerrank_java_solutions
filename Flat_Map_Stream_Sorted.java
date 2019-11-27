import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Solution {

  public static void main(String[] args) {

    Map<Integer, List<Integer>> map = new HashMap<>();
    map.put(1, Arrays.asList(1,2,4,3,2,5,6));
    map.put(2, Arrays.asList(1,10,15,17,13));
    map.put(3, Arrays.asList(8,1));
    map.put(4, Arrays.asList(6,7));
    
    List<Integer> result = map.values()
       .stream()
       .flatMap(list -> list.stream())
       .sorted(Collections.reverseOrder())
       .limit(10)
       .collect(Collectors.toList());
    System.out.println(result);
  }
}

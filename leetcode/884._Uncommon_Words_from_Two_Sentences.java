

public class Solution {

public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String element : A.split(" ")) {
            map.put(element, map.getOrDefault(element, 0 ) + 1);
        }
        
        for(String element : B.split(" ")) {
            map.put(element, map.getOrDefault(element, 0 ) + 1);
        }
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                list.add(key);
            }
        }
        return list.toArray(new String[0]);
    }
}

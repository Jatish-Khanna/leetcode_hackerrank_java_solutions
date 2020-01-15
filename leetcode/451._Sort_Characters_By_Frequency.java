

public class Solution {
 
 // Fastest of All without any collections
 
    public String frequencySort(String s) {
        int []map = new int[256];
        
        //List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
           // if(map[ch] == 0) { list.add(ch); }
           map[ch]++;
            
        }
        // Collections.sort(list, (c1, c2) -> {
        //    return map[c2] - map[c1];  
        // });
        
        StringBuilder sb = new StringBuilder();
        int maxIndex;
        
        while(true) {
            maxIndex = 0;
            for(int cIndex = 1; cIndex < map.length; cIndex++) {
                if(map[maxIndex] < map[cIndex]) {
                    maxIndex = cIndex;
                }
            }
            
            if(map[maxIndex] == 0) { break; }
            
            for(int index = 0; index < map[maxIndex]; index++) {
                sb.append((char)maxIndex);
            }
            map[maxIndex] = 0;
        }
        return sb.toString();
    }

 // Optimized by limiting space to Array and primitive types
 public String frequencySort(String s) {
        int []map = new int[256];
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(map[ch] == 0) { list.add(ch); }
           map[ch]++;
        }
        Collections.sort(list, (c1, c2) -> {
           return map[c2] - map[c1];  
        });
        
        StringBuilder sb = new StringBuilder();
        for(char ch : list) {
            for(int index = 0; index < map[ch]; index++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


// Slow solution when Using Map<Character, Integer> 
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for(char ch : s.toCharArray()) {
            if(!map.containsKey(ch)) { list.add(ch); }
            map.put(ch, map.getOrDefault(ch, 0)  + 1);
        }
        Collections.sort(list, (c1, c2) -> {
           return map.get(c2) - map.get(c1);  
        });
        
        StringBuilder sb = new StringBuilder();
        for(Character ch : list) {
            for(int index = 0; index < map.get(ch); index++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

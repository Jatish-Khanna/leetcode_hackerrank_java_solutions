

public class Solution {

  static class  CFreq {
        int freq;
        char data;
        CFreq(char data, int freq) {
            this.data = data;
            this.freq = freq;
        }
    }
    
    public String reorganizeString(String S) {
        
      Map<Character, Integer> map = new HashMap<>();
        for(char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)  + 1);
        }
      PriorityQueue<CFreq> pq = new PriorityQueue<CFreq>(map.size(), (e1, e2) -> {
         if(e1.freq == e2.freq) {
             return e1.data - e2.data;
         }
          return e2.freq - e1.freq;
      });
        
        for(char keys : map.keySet()) {
            pq.offer(new CFreq(keys, map.get(keys)));
        }
        
        StringBuilder sb = new StringBuilder();
        CFreq prev = null;
        CFreq current;
        while(!pq.isEmpty()) {
            
            current = pq.poll();
            if(prev != null && prev.freq > 0) { pq.offer(prev); }
            sb.append(current.data);
            current.freq--;
            prev = current;
        }
        return prev.freq > 0 ? "" : sb.toString();
    }
}

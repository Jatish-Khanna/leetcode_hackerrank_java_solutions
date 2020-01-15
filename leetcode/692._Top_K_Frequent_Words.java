

public class Solution {

  // Faster and better space utilization
  
      public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String word : words) {
        if(!map.containsKey(word)) {
            result.add(word);
        }
           map.put(word, map.getOrDefault(word, 0) + 1);
        
        }

        Collections.sort(result, (w1, w2) -> {
            if(map.get(w1).compareTo(map.get(w2)) == 0) {
                return w1.compareTo(w2);
            }
            return map.get(w2) - map.get(w1);
        });

        return result.subList(0,k);
    }
  
  
  // Slow than normal
  static class WordFreq {
  
  
        int freq;
        String word;
        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<WordFreq> pq = new PriorityQueue<WordFreq>(k, (w1, w2) -> {
           if(w1.freq == w2.freq) {
               return w2.word.compareTo(w1.word);
           } 
            return w1.freq - w2.freq;
        });
        
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for(String keys : map.keySet()) {
            pq.offer(new WordFreq(keys, map.get(keys)));
            if(pq.size() > k) { pq.poll(); }
        }
        LinkedList<String> result = new LinkedList<>();
        while(!pq.isEmpty()) {
            result.addFirst(pq.poll().word);
        }
        return result;
    }
}

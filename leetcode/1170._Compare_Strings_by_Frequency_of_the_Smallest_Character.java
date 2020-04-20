class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int []result = new int[queries.length];
        int []total = new int[12];
        for(String word : words) {
            total[getFreq(word)]++;
        }
        int index = 0;
        int sum = 0;
        for(int i = total.length - 2; i >= 0; i--) {
            total[i] += total[i + 1];
        }
        
        for(String query : queries) {
            result[index++] = total[getFreq(query) + 1];
        }
        //Arrays.stream(total).forEach(System.out::println);
        return result;
    }
    
    private int getFreq(String word) {
        char lowest = 'z';
        int freq = 0;
           for(char ch : word.toCharArray()){
               if(lowest == ch) {
                   freq++;
               } else if(ch < lowest) {
                   lowest = ch;
                   freq = 1;
               } 
               //System.out.println(freq + " .");
           }
        return freq;
    }
}

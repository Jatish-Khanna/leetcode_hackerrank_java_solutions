

public class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word : words) {
            if(findAndReplace(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
    
    public boolean findAndReplace(String word, String pattern) {
        int []w = new int[26];
        int []p = new int[26];
        Arrays.fill(w, -1);
        Arrays.fill(p, -1);
        int wId;
        int pId;
        for(int index = 0; index < word.length(); index++) {
            wId = word.charAt(index) - 'a';
            pId = pattern.charAt(index) - 'a';
            if(w[wId] == -1 && p[pId] == -1) {
                w[wId] = pId;
                p[pId] = wId;
            } else {
                if(w[wId] != pId || p[pId] != wId) {
                    return false;
                }
            }
        }
        return true;
    }
}

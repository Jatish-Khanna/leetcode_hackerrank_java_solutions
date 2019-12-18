

public class Solution {

  static class TrieNode {
  TrieNode []child = new TrieNode[26];
      boolean isWord;
      String word;
    }
    
    TrieNode root = new TrieNode();
    
    public String longestWord(String[] words) {
        for(String word : words) {
            insertTrie(word);
        }
        
        //TrieNode current = root;
        String result = null;
        Queue<TrieNode> nodes = new LinkedList<>();
        nodes.offer(root);
        
            
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            for(int index = 0; index < size; index++) {
                TrieNode process = nodes.poll();
        
                for(int charSize = 25; charSize >= 0; charSize--) {
                
                    if(process.child[charSize] != null && process.child[charSize].isWord){
                        result = process.child[charSize].word;
                        nodes.offer(process.child[charSize]);
                    }
                }
            }
        }
        return result == null ? "" : result;
    }
    
    public void insertTrie(String word) {
        TrieNode current = root;
        for(char val : word.toCharArray()) {
            if(current.child[val - 'a'] == null) {
                current.child[val - 'a'] = new TrieNode();
            }
            current = current.child[val - 'a'];
        }
        current.isWord = true;
        current.word = word;
    }
}

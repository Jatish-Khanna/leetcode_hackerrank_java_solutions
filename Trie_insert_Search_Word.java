

public class Solution {
  static TrieNode root;
  
  static class TrieNode {
      TrieNode[] children = new TrieNode[26];
    boolean isWord;
  }

  public static void main(String[] args) {
    String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their", "thaw"};

    String output[] = {"Not present in trie", "Present in trie"};


    root = new TrieNode();

    int i;
    for (i = 0; i < keys.length; i++)
      insert(keys[i]);

    // Search for different keys
    if (search("the") == true)
      System.out.println("the --- " + output[1]);
    else
      System.out.println("the --- " + output[0]);

    if (search("these") == true)
      System.out.println("these --- " + output[1]);
    else
      System.out.println("these --- " + output[0]);

    if (search("their") == true)
      System.out.println("their --- " + output[1]);
    else
      System.out.println("their --- " + output[0]);

    if (search("thaw") == true)
      System.out.println("thaw --- " + output[1]);
    else
      System.out.println("thaw --- " + output[0]);
  }

  private static boolean search(String string) {

    TrieNode current = root;
    int index;
    for(char character : string.toCharArray()) {
      index = character - 'a';
      if(current.children[index] == null) {
        return false;
      }
      current = current.children[index];
    }
    return current != null && current.isWord;
  }

  private static void insert(String string) {

    TrieNode current = root;
    int index;
    for (char character : string.toCharArray()) {
      index = character - 'a';
      if (current.children[index] == null) {
        current.children[index] = new TrieNode();
      }
      current = current.children[index];
    }
    current.isWord = true;
  }
}

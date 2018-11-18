import java.util.List;
import java.util.ArrayList;

class Solution {
    /* Driver program to test above function */
    public static void main(String[] args) {
        findFirstNonRepeating();
    }

    private static void findFirstNonRepeating() {
        List<Character> list = new ArrayList<>();
        boolean visited[] = new boolean[256];

        String stream = "ewruihjfgnmuerwlasdpjnzxz";

        /// Iterate over each character in stream
        for (int index = 0; index < stream.length(); index++) {
            // Get current character from stream
            Character character = stream.charAt(index);
            // Character is already seen twice in the stream
            if (!visited[character]) {
                // Character has been seen first or second time
                if (list.contains(character)) {
                    // Seen second time; remove it from unique list
                    list.remove(character);
                    // Mark it as repeating character
                    visited[character] = true;
                } else {
                    // Seen for the first time in the stream
                    list.add(character);
                }
            }
        }
        // Get the first non-repeating character from the stream or -1
        if (list.size() > 0)
            System.out.println("First non-repeating character:" + list.get(0));
        else
            System.out.println(-1);
    }
}

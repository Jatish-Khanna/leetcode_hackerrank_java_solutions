

public class Solution {


    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length;
        int mid;
        while(low < high) {
            mid = low + (high - low) / 2;
            if(letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low == letters.length ? letters[0] : letters[low];
    }
}

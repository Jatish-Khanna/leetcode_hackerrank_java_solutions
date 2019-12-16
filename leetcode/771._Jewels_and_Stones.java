

public class Solution {

    public int numJewelsInStones(String J, String S) {
        boolean []jewels = new boolean[256];
        for(char jewel : J.toCharArray()) {
            jewels[jewel] = true;
        }
        int count = 0;
        for(char stone : S.toCharArray()) {
            count += jewels[stone] ? 1 : 0;
        }
        return count;
    }
}

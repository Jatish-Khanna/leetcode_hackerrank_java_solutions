

public class Solution {

     public boolean judgeCircle(String moves) {
        int left = 0;
        int up = 0;
        for(char move : moves.toCharArray()) {
            switch(move) {
                case 'L': left++; break;
                case 'R': left--; break;
                case 'U': up++; break;
                case 'D': up--; break;
            }
        }
        return left == 0 && up == 0;
    }
}



public class Solution {

    int []dy = {-1, 0, 1, 0};
    int []dx = {0, 1, 0, -1};
    
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for(int rIndex = 0; rIndex < board.length; rIndex++) {
            for(int cIndex = 0; cIndex < board[0].length; cIndex++) {
                if(board[rIndex][cIndex] == 'R') {
                    for(int dIndex = 0; dIndex < dx.length; dIndex++) {
                     count += capturePawn(board, rIndex, cIndex, dx[dIndex], dy[dIndex]);
                    }
                    return count;
                }
            }
        }
        return count;
    }
    
    public int capturePawn(char [][]board, int x, int y, int ix, int iy) {
        x += ix;
        y += iy;
        while(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != 'B') {
            if(board[x][y] == 'p') return 1;
            x += ix;
            y += iy;
        }
        return 0;
    }
}

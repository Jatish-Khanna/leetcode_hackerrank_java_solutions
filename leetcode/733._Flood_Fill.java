


public class Solution {


    static int []dr = {-1, 0 , 1, 0};
    static int []dc = {0, 1, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (image[sr][sc] != newColor)
        floodFillUtil(image, sr, sc, oldColor, newColor);
        return image;
    }
    
    public void floodFillUtil(int [][]image, int sr, int sc, int oldColor, int newColor) {
        
        image[sr][sc] = newColor;
        for(int index = 0; index < dr.length; index++) {
         if(isValid(image, sr + dr[index], sc + dc[index], oldColor)) { continue;}
           floodFillUtil(image, sr + dr[index], sc + dc[index], oldColor, newColor);
        }
    }
    
    public boolean isValid(int [][]image, int sr, int sc, int oldColor) {
        return sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor;
    }
}

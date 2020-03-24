
public class Solution {
    
    static int []row = {-1, 0, 1, 0};
    static int []col = {0, -1, 0, 1};
    
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int m;
		int n;
		int x;
		int y;
		int newColor;
		for(int test = 0; test < T; test++) {
		    m = in.nextInt();
		    n = in.nextInt();
		    int [][]mat = new int[m][n];
		    for(int i = 0; i < m; i++) {
		        for(int j = 0; j < n; j++) {
		            mat[i][j] = in.nextInt();
		        }
		    }
		    x = in.nextInt();
		    y = in.nextInt();
		    newColor = in.nextInt();
		    // Input ends
		    
		    floodFill(x, y, mat[x][y], newColor, mat);
		    printMatrix(m, n, mat);
		    
		}
		
		in.close();
	}
	
	private static void floodFill(int x, int y, int oldColor, int newColor, int [][]mat) {
	    if(x < 0 || x >= mat.length || y < 0 || y >= mat[0].length || mat[x][y] != oldColor) {
	        return;
	    }
	    
	    mat[x][y] = newColor;
	    for(int dir = 0; dir < row.length; dir++) {
	        floodFill(x + row[dir], y + col[dir], oldColor, newColor, mat);
	    }
	    return;
	}
	
	private static void printMatrix(int m, int n, int [][]mat) {
	    for(int i = 0; i < m; i++) {
	        for(int j = 0; j < n; j++) {
	            System.out.print(mat[i][j] + " ");
	        }
	    }
	    System.out.println();
	}
}

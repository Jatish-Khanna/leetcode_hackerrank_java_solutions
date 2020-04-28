class Solution {
    
    int [][]dir = {{0,1},{1,0},{0,-1},{-1, 0}};
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // HashSet<String> visited = new HashSet<>();
        boolean [][]visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        int [][]res = new int[R*C][2];
        // visited[r0][c0] = true;
        queue.offer(new int[]{r0, c0});
        
        int []point;
        int nr;
        int nc;
        visited[r0][c0] = true;
        int id = 0;
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            while(size-- > 0) {
                point = queue.poll();
                res[id++] = point;
                for(int i = 0; i < dir.length; i++) {
                    nr = point[0] + dir[i][0];
                    nc = point[1] + dir[i][1];
                    if(isValid(nr, nc, R, C, visited)) {
                        queue.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;        
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isValid(int nr, int nc, int R, int C, boolean[][] visited) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc];
    }
}

class Solution {
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []visited = new boolean[rooms.size()];
        // count = visited.length;
        dfs(0, visited, rooms);
        return count == visited.length;
    }
    
    private void dfs(int room, boolean []visited, List<List<Integer>> rooms) {
        visited[room] = true;
        count++;
        for(Integer num : rooms.get(room)) {
            if(!visited[num]) {
                dfs(num, visited, rooms);
            }
        }
    }
}

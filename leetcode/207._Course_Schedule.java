

public class Solution {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> []adjList = new ArrayList[numCourses];
        for(int []course : prerequisites) {
            if(adjList[course[0]] == null) {
                adjList[course[0]] = new ArrayList<>();
            }
            adjList[course[0]].add(course[1]);
        }
        boolean []taken = new boolean[numCourses];
        boolean []seen = new boolean[numCourses];
        
        for(int index = 0; index < numCourses; index++) {
            if(adjList[index] == null ||adjList[index].size() == 0) {
                taken[index] = true;
            }
        }
        
        for(int index = 0; index < numCourses; index++) {
            
            if(!taken[index] && !dfs(index, seen, taken, adjList)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int index, boolean []seen, boolean []taken, List<Integer> []adjList) {
        if(taken[index]) { return true; }
        if(seen[index]) { return false;}
        seen[index] = true;
        
        for(int course : adjList[index]) {
            if(!dfs(course, seen, taken, adjList)) { return false;}
        }
        
        seen[index] = false;
        taken[index] = true;
        return true;
    }
}

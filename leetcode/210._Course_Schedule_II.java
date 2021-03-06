

class Solution {
    
    // BFS 
    
    static int rIndex = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> []graph = new ArrayList[numCourses];
        rIndex = 0;
        for(int index = 0; index < numCourses; index++) {
            graph[index] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for(int []dep : prerequisites) {
            graph[dep[0]].add(dep[1]);
            indegree[dep[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int index = 0; index < numCourses; index++) {
            if(indegree[index] == 0) {
                queue.offer(index);
            }
        }
        int[] result = new int[numCourses];
        int rIndex = numCourses - 1;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            result[rIndex--] = current;
            for(int neb : graph[current]) {
                if(--indegree[neb] == 0) {
                    queue.offer(neb);
                }
            }
        }
        if(rIndex == -1) {
            return result;
        }
        return new int[]{};
    }

    
    // DFS 
    
    static int rIndex = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> []graph = new ArrayList[numCourses];
        rIndex = 0;
        for(int index = 0; index < numCourses; index++) {
            graph[index] = new ArrayList<>();
        }
        
        for(int []dep : prerequisites) {
            graph[dep[0]].add(dep[1]);
        }
        //Arrays.stream(graph).forEach(System.out::println);
        
        boolean []seen = new boolean[numCourses];
        boolean []taken = new boolean[numCourses];
        int []result = new int[numCourses];
        //int rIndex = 0;
        

        
        for(int index = 0; index < numCourses; index++) {
            if(!taken[index] && !dfs(index, result, seen, taken, graph)) {
                return new int[]{};
            }
        }
        return result;
    }
    
    public boolean dfs(int course, int []result, boolean []seen, boolean []taken, List<Integer> []graph) {
        if(taken[course]) { return true; }
        if(seen[course]) { return false; }
        
        seen[course] = true;
        
        for(int next : graph[course]) {
            if(!taken[next] && !dfs(next, result, seen, taken, graph)) {
                return false;
            }
            
            if(!taken[next]) { result[rIndex++] = next; }
         }
        
        seen[course] = false;
        taken[course] = true;
        System.out.println(rIndex);
        result[rIndex++] = course;
        
        return true;
    }
}

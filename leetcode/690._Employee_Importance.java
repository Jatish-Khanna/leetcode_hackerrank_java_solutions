

public class Solution {

    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> mapper = employees.stream().collect(Collectors.toMap(e -> e.id, e -> e));
        
        Queue<Employee> employee = new LinkedList<>();
        Employee current;
        employee.offer(mapper.get(id));
        int importance = 0;
        while(!employee.isEmpty()) {
            current = employee.poll();
            importance += current.importance;
            for(Integer subordinate : current.subordinates) {
              employee.offer(mapper.get(subordinate));
            }
        }
        return importance;
    }
    
    // Note the Stream are much **slower** than the normal get/put operation
    public int getImportanceDFS(List<Employee> employees, int id) {
      mapper = new HashMap<>();
      for (Employee e : employees)
        mapper.put(e.id, e);      
      int importance = 0;
      return dfs(id);
    }
    public int dfs(int id) {
        int importance = mapper.get(id).importance;
        for(Integer sub : mapper.get(id).subordinates) {
          importance += dfs(sub);
        }
        return importance;
    }
}

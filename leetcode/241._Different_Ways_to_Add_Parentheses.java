

public class Solution {

    
    HashMap<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        
        if(map.containsKey(input)) { return map.get(input); }
        
        int index = 0;
        List<Integer> result = new ArrayList<>();
        if("".equals(input)) { return result; }
        
        for(char ch : input.toCharArray()) {
            if(isOperator(ch)) {
                List<Integer> leftResults = diffWaysToCompute(input.substring(0, index));
                List<Integer> rightResults = diffWaysToCompute(input.substring(index+1));
                for(int first : leftResults) {
                    for(int second : rightResults) {
                        result.add(operate(first, second, ch));
                    }
                }
            }
            
            index++;
        }
        if(result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        map.put(input, result);
        return result;
    }
    
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*';
    }
    
    private int operate(int first, int second, char ch) {
        switch(ch) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            default:
                return first + second;
        }
    }
}

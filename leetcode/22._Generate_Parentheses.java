

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) { return result; }
        char []ar = new char[n * 2];
        ar[0] = '(';
        generateParenthesisUtil(1, 1, 0, ar, result, n);
        return result;
    }
    
    private void generateParenthesisUtil(int index, int leftCount, int rightCount, char []ar, List<String> result, int size) {
        
        if(leftCount > size || rightCount > size || rightCount > leftCount) { return; }
        
        if(index == ar.length) {
            result.add(new String(ar));
            return;
        }
        ar[index] = '(';
        generateParenthesisUtil(index + 1, leftCount + 1, rightCount, ar, result, size);
        ar[index] = ')';
        generateParenthesisUtil(index + 1, leftCount, rightCount + 1, ar, result, size);
        
    }
}

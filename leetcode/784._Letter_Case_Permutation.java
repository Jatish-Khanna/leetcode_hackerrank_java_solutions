

public class Solution {
    List<String> result = new ArrayList<>();
    if(S == null || S.isEmpty()) { return result; }
    
    letterCasePermutationUtil(0, S.toCharArray(), result);
    return result;
}

private void letterCasePermutationUtil(int index, char []original, List<String> result) {
    if(index == original.length) {
        result.add(new String(original));
        return;
    }
    letterCasePermutationUtil(index + 1, original, result);
    char ch = original[index];
    if(!isDigit(ch)) {
        if(ch >= 'a') {
        original[index] = (char)(ch - 32);
        } else {
            original[index] = (char)(ch + 32);
        }
        letterCasePermutationUtil(index + 1, original, result);
        original[index] = ch;
    }
}

boolean isDigit(char ch) {
    return ch >= '0' && ch <= '9';
}
}

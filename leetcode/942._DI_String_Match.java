

public class Solution {


    public int[] diStringMatch(String S) {
        int low = 0;
        int high = S.length();
        int []result = new int[S.length() + 1];
        int index = 0;

        for(char ch : S.toCharArray()) {
            if(ch == 'I') {
                result[index++] = low++;
            } else {
                result[index++] = high--;
            }
        }
        result[index] = low;
        return result;
    }
}

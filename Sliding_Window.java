
class Result {

    /*
     * Complete the 'shortestSubstring' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int shortestSubstring(String s) {
    // Write your code here
        int min = s.length();
        boolean []freq = new boolean[26];
        int numOfChar = 0;
        for(char ch  : s.toCharArray()) {
            if(!freq[ch - 'a']) {
                numOfChar++;
                freq[ch - 'a'] = true;
            }
        }
        
        int start = 0;
        int current = 0;
        int[] ar = new int[26];
        int count = 0;
        char []str = s.toCharArray();
        
        
        
        while(current < s.length() || count == numOfChar) {
             if(count >= numOfChar) {
                 min = Math.min(min, current - start);
            //    se if(count > numOfChar) {
                 if(ar[str[start] - 'a']-- == 1) {
                     count--;
                 }
                 start++;
             } else {
                 if(ar[str[current] - 'a']++ == 0) {
                     count++;
                 }
                 current++;
             }
        }
        // System.out.print(count);
        // while(count > numOfChar) {
        //     if(ar[str[start] - 'a']-- == 1) {
        //         count--;
        //     }
        //     start++;
        // }
        // return Math.min(min, current - start);
        return min;
    }

}

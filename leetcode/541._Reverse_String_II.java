class Solution {
    public String reverseStr(String s, int k) {
        char []ar = s.toCharArray();
        int index = 0;
        int end;
        while(index < ar.length) {
            end = Math.min(index + k, ar.length) - 1;
            reverse(ar, index, end);
            index = index + 2 * k;
        }
        return new String(ar);
    }
    
    private void reverse(char []ar, int start, int end) {
        char tmp;
        while(start < end) {
            tmp = ar[start];
            ar[start] = ar[end];
            ar[end] = tmp;
            start++;
            end--;
        }
    }
}

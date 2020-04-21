class Solution {
    public String reverseVowels(String s) {
        char []ar = s.toCharArray();
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'));
        int start = 0;
        int end = ar.length - 1;
        char tmp;
        while(start < end) {
            while(start < end && !vowels.contains(ar[start])) start++;
            while(end > start && !vowels.contains(ar[end])) end--;
            
                tmp = ar[start];
                ar[start] = ar[end];
                ar[end] = tmp;
                start++;
                end--;
            
        }
        return new String(ar);
    }
}

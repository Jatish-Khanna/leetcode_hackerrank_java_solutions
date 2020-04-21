class Solution {
    public int repeatedStringMatch(String A, String B) {
        int []ar = new int[26];
        for(char ch : A.toCharArray()) {
            ar[ch - 'a']++;
        }
        
        for(char ch : B.toCharArray()) {
            if(ar[ch - 'a'] == 0) {
                return -1;
            }
        }
        
        int replicas = B.length() / A.length() + 1;
        int count = replicas;
        StringBuilder sb = new StringBuilder(A);
        while(replicas >= 0) {
            // System.out.println(A);
            if(sb.indexOf(B) != -1) { return count - replicas + 1; }
            sb.append(A);
            
            replicas--;
        }
        return -1;
    }
}

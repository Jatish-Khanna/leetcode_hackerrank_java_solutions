class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char []ar = s.toCharArray();
        int limit = ar.length / 2;
        for(int index = limit; index >= 1; index--) {
            if(ar.length % index == 0 && isReplica(ar, index)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isReplica(char []ar, int length) {
        
        for(int i = length; i < ar.length; i++) {
            if(ar[i] != ar[i % length]) {
                return false;
            }
        }
        //System.out.println(length);
        return true;
    }
}

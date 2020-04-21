class Solution {
    public int countSegments(String s) {
        int count  = 0;
        if(s.isEmpty()) {
            return count;
        }
        
        for(String str : s.split(" ")) {
            if(!str.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

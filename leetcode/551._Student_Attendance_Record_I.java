class Solution {
    public boolean checkRecord(String s) {
        int abs = 0;
        int late = 0;
        for(char rec : s.toCharArray()) {
            if(rec == 'A') {
                abs++;
                late = 0;
            } else if(rec == 'L') {
                late++;
            } else {
                late = 0;
            }
            
            if(abs > 1 || late > 2) {
                return false;
            }
        }
        return true;
    }
}

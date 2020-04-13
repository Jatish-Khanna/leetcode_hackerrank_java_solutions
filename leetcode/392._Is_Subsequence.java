

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int ti = 0;
        int si = 0;
        char tar[] = t.toCharArray();
        char sar[] = s.toCharArray();
        while(ti < tar.length && si < sar.length) {
            if(sar[si] == tar[ti]) {
                si++;
            }
            ti++;
        }
        return si == sar.length;
    }
}

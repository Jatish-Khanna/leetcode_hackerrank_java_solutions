class Solution {
    
    // DFS based - Faster solution
    class Solution {
    static int []next = {0, 1, 8, 2, 5, 6, 9};
    static int ans = 0; 
    public int rotatedDigits(int N) {
        if(N < 2) { return 0; }
        ans = 0;
        dfs(0, false, N);
        return ans;
    }
    
    private void dfs(int num, boolean isValid, int N) {
        if(num > N) { return; }
        if(isValid) {
            ans++;
        }
        int another;
        boolean aValid;
        for(int i = 0; i < next.length; i++) {
            aValid = isValid || (i > 2);
            another = (num * 10) + next[i];
            if(another == 0 || another > N) { continue; }
            dfs(another, aValid, N);
        }
    }
    
    
    // Slower solution
    
    public int rotatedDigits(int N) {
        int curr = 1;
        int result = 0;
        while(curr <= N) {
            if(canChange(curr)) {
                result++;
            }
            curr++;
        }
        return result;
    }
    
    private boolean canChange(int num) {
        int lastDigit;
        boolean ret = false;
        while(num > 0) {
            lastDigit = num % 10;
            if(lastDigit == 3 || lastDigit == 4 || lastDigit == 7) {
                return false;
            } else if(lastDigit == 2 || lastDigit == 5 || lastDigit == 6 || lastDigit == 9) {
                ret = true;
            }
            num /= 10;
        }
        return ret;
    }
}

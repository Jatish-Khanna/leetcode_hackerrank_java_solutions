class Solution {
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

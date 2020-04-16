class Solution {
    public boolean isPalindrome(int x) {
        int palin = 0;
        int replica = x;
        while(replica > 0) {
            palin = palin * 10 + replica % 10;
            replica /= 10;
        }
        return palin == x;
    }
}

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int []suit = new int[10000];
        int last = 0;
        for(int card : deck) {
            suit[card]++;
            //last = suit[card];
        }

        for(int count : suit) {
            if(count > 1) {
                last = gcd(last, count);        
            } else if(count == 1) {
                return false;
            }
        }
        return last > 1;
    }
    
    private int gcd(int one, int two) {
        if(two == 0) {
            return one;
        }
        return gcd(two, one % two);
    }
}

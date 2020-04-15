class Solution {
    
    /*
     Based on the formulae;
     where n = number of elements
     sum = total of all the elements without modification
     m =  number of moves
     
     a = (minElement + m) // means minElement will be modified at least m times to get sum =  n . a
     
     sum + m * (n - 1) = a * n
    */
    
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        return sum - (min * nums.length);
    }
}

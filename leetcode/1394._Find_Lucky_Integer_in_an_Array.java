class Solution {
    public int findLucky(int[] arr) {
        int []ar = new int[501];
        int last = -1;
        // int freq = -1;
        for(int num : arr) {
            ar[num]++;
        }
        // int id = 0;
        for(int id = 1; id < ar.length; id++) {
            if(id == ar[id]) {
                last = id;
            }
        }
        return last;
    }
}

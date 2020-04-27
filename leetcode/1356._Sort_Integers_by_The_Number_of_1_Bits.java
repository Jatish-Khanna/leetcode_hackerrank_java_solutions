class Solution {
    
    class Count {
        int num;
        int count;
        Count(int num) {
            this.num = num;
            this.count = count(num);
        }
        
        private int count(int num) {
            int c = 0;
            while(num > 0) {
                num = num & (num - 1);
                c++;
            }
            return c;
        }
    }
    
    public int[] sortByBits(int[] arr) {
        Count []dp = new Count[arr.length];
        int i = 0;
        for(int num : arr) {
            dp[i++] = new Count(num);
        }
        Arrays.sort(dp, (o1, o2) -> {
            if(o1.count == o2.count) {
                return o1.num - o2.num;
            }
            return o1.count - o2.count;
        });
        i = 0;
        while(i < arr.length) {
            arr[i] = dp[i].num;
            i++;
        }
        
        return arr;
    }
}

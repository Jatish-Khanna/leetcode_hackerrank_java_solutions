class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        for(int i = 1; i <= n; i++) {
            sum = getSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int max = 0;
        int maxItem = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxItem) {
                max++;
            } else if(entry.getValue() > maxItem) {
                maxItem = entry.getValue();
                max = 1;
            }
        }
        return max;
    }
    
    private int getSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

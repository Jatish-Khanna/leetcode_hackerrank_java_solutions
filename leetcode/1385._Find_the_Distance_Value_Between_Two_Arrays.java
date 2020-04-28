class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int diff;
        int res = 0;
        for(int num : arr1) {
            int index = Arrays.binarySearch(arr2, num);
            // System.out.println(index);
            if(index >= 0) {
                diff = 0;
            } else {
                index = Math.abs(index) - 1;
                if(index == 0) {
                    diff = arr2[0] - num;
                } else if(index == arr2.length) {
                    diff = num - arr2[arr2.length - 1];
                } else {
                    diff = Math.min(arr2[index] - num, num - arr2[index - 1]);
                }
            }
            
            res += diff > d ? 1 : 0;
        }
        return res;
    }
}

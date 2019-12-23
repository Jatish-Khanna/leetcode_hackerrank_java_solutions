

public class Solution {


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        
        int prev = arr[0];
        int diff;
        int min = Integer.MAX_VALUE;
        for(int index = 1; index < arr.length; index++) {
            min = Math.min(arr[index] - prev, min);
            prev = arr[index];
        }
        ArrayList<Integer> tmp;
        for(int index = 1; index < arr.length; index++) {
            if(arr[index] - arr[index - 1] == min) {
                tmp = new ArrayList<>();
                tmp.add(arr[index-1]);
                tmp.add(arr[index]);
                list.add(tmp);
            }
        }
        return list;
    }
}

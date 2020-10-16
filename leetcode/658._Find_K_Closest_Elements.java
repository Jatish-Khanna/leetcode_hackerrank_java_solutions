

public class Solution {
   
   
   // Clean code
   
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        if(k == 0)  {return list; }
        
        int index = binarySearch(arr, x);
        int left = index;
        int right;
               
        if(left <= 0) { return toList(arr, 0, k); }
        else if(left == arr.length) { return toList(arr,arr.length - k, arr.length); }       
        
        if(left > 0 && arr[left] != x) {
            if((x - arr[left - 1]) <= (arr[left] - x)) {
                --left;
            }

        }
        right = left + 1;
        
        while(right - left <= k) {
           
            if(left < 0) {
                list.add(arr[right++]);
                continue;
            }  else if(right == arr.length || x - arr[left] <= arr[right] - x) { 
                list.addFirst(arr[left--]);
            }
            else { 
                list.add(arr[right++]);
            }
        }
        return list;
    }
    
    public List<Integer> toList(int []arr, int start, int upperBound) {
        List<Integer> result = new ArrayList<>();
        for(int index = start; index < upperBound; index++) {
            result.add(arr[index]);
        }
        return result;
    }
    
    public int binarySearch(int []arr, int target) {
        int left = 0, right = arr.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] < target) { left = mid + 1; }
            else if(arr[mid] == target){ return mid; }
            else { right = mid - 1; }
        }
        
        return left;
    }

   
   
   // Use of copyOfRange is bit slower than normal usecase 3%
       public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(k == 0)  {return list; }
        
        int index = Arrays.binarySearch(arr, x);
        if(index == -1) { return toList(arr, 0, k); }
        if(-index == arr.length + 1) { return toList(arr,arr.length - k, arr.length); }
        
        //System.out.println(-index);
        int left = Math.abs(index);
        int right = Math.abs(index + 1);
        
        while(right - left < k) {
            if(left == 0) {
                ++right;
                continue;
            } else if(right == arr.length) {
                --left;
                continue;
            }
            if(Math.abs(arr[left - 1] - x) <= Math.abs(arr[right] - x)) { --left; }
            else { ++right; }
        }
        return toList(arr, left, right);
    }
    
    public List<Integer> toList(int []arr, int start, int upperBound) {
        List<Integer> result = new ArrayList<>();
        for(int index = start; index < upperBound; index++) {
            result.add(arr[index]);
        }
        return result;
    }
   
   
   // With Arrays.copyOfRange and Arrays.binarySearch implementation, 50% slower than other methods

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if(k == 0)  {return list; }
        
        int index = Arrays.binarySearch(arr, x);
        if(index == -1) { return toList(Arrays.copyOfRange(arr, 0, k)); }
        if(-index == arr.length + 1) { return toList(Arrays.copyOfRange(arr,arr.length - k, arr.length)); }
        
        //System.out.println(-index);
        int left = Math.abs(index);
        int right = Math.abs(index + 1);
        
        while(right - left < k) {
            if(left == 0) {
                ++right;
                continue;
            } else if(right == arr.length) {
                --left;
                continue;
            }
            if(Math.abs(arr[left - 1] - x) <= Math.abs(arr[right] - x)) { --left; }
            else { ++right; }
        }
        return toList(Arrays.copyOfRange(arr, left, right));
    }
    
    public List<Integer> toList(int []arr) {
        List<Integer> result = new ArrayList<>();
        for(int element :arr) {
            result.add(element);
        }
        return result;
    }
}

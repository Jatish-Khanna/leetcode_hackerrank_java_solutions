
public class Solution {

  public int largestUniqueNumber(int []arr) {
  
    int []result = new int[2001];
    for(int element : arr) {
      result[element]++;
    }
    

    for(int index = result.length -1 ; index >=0 ; index--) {
      if(result[index] == 1) {
        return index;      
      }
    }
    return -1;
  }
}

import java.util.Arrays;

class MergeSortWithSystemArrayCopy {

  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
     Scanner in = new Scanner(System.in);
    int numberOfElements = in.nextInt();
    in.nextLine();
    //String elements = in.nextLine();
    int []elementsToSort = new int[numberOfElements];
    //int index = 0;
    for(int index = 0; index < numberOfElements; index++) {
      elementsToSort[index] = in.nextInt();
    }
    
    int []sortedArray = mergeSort(elementsToSort, 0, numberOfElements-1);
    System.out.print("[");
    Arrays.stream(sortedArray).limit(sortedArray.length-1).forEach(element -> System.out.print(element+","));
    System.out.print(sortedArray[sortedArray.length-1]+"]");
    in.close();
  }
  
  private static int[] mergeSort(int []elementsToSort, int low, int high) {
    
    if(low < high) {
      int mid = low + (high - low) / 2;
      mergeSort(elementsToSort, low, mid);
      mergeSort(elementsToSort, mid+1, high);
      elementsToSort = merge(elementsToSort, low, mid, high);
    }
    return elementsToSort;
  }
  
  private static int[] merge(int []elementsToSort, int low, int mid, int high) {
    
    int firstIndex = low;
    int secondIndex = mid+1;
    int resultIndex = 0;
    int []resultList = new int[high - low + 1];
    
    while(firstIndex <= mid && secondIndex <= high) {
      if(elementsToSort[firstIndex] <= elementsToSort[secondIndex]) {
        resultList[resultIndex] = elementsToSort[firstIndex];
        firstIndex++;
      } else {
        resultList[resultIndex] = elementsToSort[secondIndex];
        secondIndex++;
      }
      resultIndex++;
    }
    
    if(firstIndex <= mid) {
      System.arraycopy(elementsToSort, firstIndex, resultList, resultIndex, mid - firstIndex + 1);
    } 
    if(secondIndex <= high) {
      System.arraycopy(elementsToSort, secondIndex, resultList, resultIndex, high - secondIndex + 1);
    }
    
    System.arraycopy(resultList, 0, elementsToSort, low, resultList.length);
    return elementsToSort;
  }
} 

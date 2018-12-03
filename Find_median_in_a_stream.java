import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;


class Solution {
  static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

  
  public static void main(String []args) {
		
	Scanner in = new Scanner(System.in);
	int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4}; 
	int number = A.length;
	for(int index = 0; index < number; index++){
		pushNumber(A[index]);
		printMedian();
	}
	
	in.close();
  }
  
  private static void pushNumber(int nextNumberInStream){
	if(checkEqual()){
		if(maxHeap.size() == 0 || nextNumberInStream < minHeap.peek()) {
			maxHeap.offer(nextNumberInStream);
		} else{
			maxHeap.offer(minHeap.poll());
			minHeap.offer(nextNumberInStream);
		}
	}
	else{
		if(maxHeap.peek() < nextNumberInStream) {
			minHeap.offer(nextNumberInStream);
		}
		else{
			minHeap.offer(maxHeap.poll());
			maxHeap.offer(nextNumberInStream);
		}
	
	}
  
  }
  
  private static void printMedian(){
  
	if(maxHeap.size() == 0)
		return;
	if(checkEqual()){
	
		System.out.println((maxHeap.peek() + minHeap.peek()) / 2.0d);
	}
	else {
	
		System.out.println(maxHeap.peek());
	}
	
  }
  
  private static boolean checkEqual() {return maxHeap.size() == minHeap.size();}
}

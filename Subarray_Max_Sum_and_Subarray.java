import java.util.Arrays;
import java.util.List;

public class Solution {

{
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> list = Arrays.asList(-1,-21);
		int end = 0;
		int start = 0;
		int currentS = 0;
		int maxSum = Integer.MIN_VALUE;
		int currentMax = 0;
		int currentSum = 0;
		
		for(int index = 0; index < list.size(); index++) {
		    currentSum += list.get(index);
		    if(currentSum < list.get(index)) {
		        currentSum = list.get(index);
		        currentS = index;
		    }
		    else if(currentSum > maxSum) {
		        start = currentS;
		        end = index;
		        maxSum = currentSum;
		    }
		    
		}
		
		System.out.println(start + " " + end + " " + maxSum);
	}
}

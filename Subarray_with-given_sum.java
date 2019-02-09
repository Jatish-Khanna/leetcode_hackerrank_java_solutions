/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class GFG {

  private static void subArraySum(int []arr, int length, int sum) {
    
    int startIndex = 0;
    int endIndex = 1;
    int calculatedSum = arr[startIndex];
        

    while(endIndex <= length) {
     
     while(calculatedSum > sum && startIndex < endIndex) {
       calculatedSum -= arr[startIndex];
	startIndex++;
    }
 
     if(calculatedSum == sum) {
	//System.out.println("Sum found between start index: " + startIndex + " and end index: "+ (endIndex - 1));
	System.out.println((startIndex+1) + " "+ (endIndex));

	return;
      }
     if(endIndex < length) {
	calculatedSum += arr[endIndex];
	endIndex++;
    }
    }
    
    System.out.println(-1);
  }

    public static void main(String[] args)  
    { 
        Scanner in = new Scanner(System.in);
        //int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int arr[];
        int T = in.nextInt();
        for(int test = 0; test < T; test++) {
        int n = in.nextInt();
        arr = new int[n];
        int sum = in.nextInt();
        for(int index = 0; index < n; index++) {
            arr[index] = in.nextInt();
            
        
        }
        subArraySum(arr, n, sum); 
        }
    } 
}	

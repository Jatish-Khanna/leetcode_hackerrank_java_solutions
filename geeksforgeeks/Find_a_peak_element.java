

public class Peak {

	// Function to find the peak element
	// a[]: input array
	// n: size of array a[]
	public int peakElement(int[] a,int n)
    {
       //add code here.
       if(n == 1) { return 0; }
       if(a[0] >= a[1]) {
           return 0;
       } else  if(a[n - 1] >= a[n - 2]) {
           return n-1;
       }
       
       int start = 1;
       int end = n - 2;
       int mid = start;
       while(start <= end) {
           mid = start + (end - start) / 2;
           if(a[mid - 1] <= a[mid] && a[mid + 1] <= a[mid]) {
               return mid;
           } else if(a[mid] < a[mid - 1]) {
               end = mid - 1;
           } else {
               start = mid + 1;
           }
       }
       //System.out.println(mid+" "+a[mid]);
       return mid;
    }
}

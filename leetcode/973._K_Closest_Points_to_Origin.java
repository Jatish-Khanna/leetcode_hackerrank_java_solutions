
public class Solution {
 
   // Quick select algorithm implementations - QuickSelect - QuickSort(no complete)
 
    public int[][] kClosest(int[][] points, int K) {
        int left = 0;
        int right = points.length - 1;
        while(left < right) {
            int pivot = quickSort(points, left, right);
            if(pivot < K - 1) {
                left = pivot + 1;
            } else if(pivot > K - 1) {
                right = pivot - 1;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int quickSort(int[][] points, int left, int right) {
        int[] pivitPoint = points[left];
        int pivit = distance(pivitPoint);
        while(left < right) {
            while(left < right && distance(points[right]) > pivit) right--;
            // swapping underway
            points[left] = points[right];
            while(left < right && distance(points[left]) <= pivit) left++;
            // swap second
            points[right] = points[left];
        }
        // swap the pivit and left
        points[left] = pivitPoint;
        return left;
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

 
 
 
  static class Point {
  
        double distance;
        int []point;
        Point(double distance, int []point) {
            this.distance = distance;
            this.point = point;
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> nearOrigin = new PriorityQueue<Point>(K, (e1, e2) -> {
           return Double.compare(e2.distance , e1.distance); 
        });
        
        for(int []current : points) {
            Point p = new Point(calculateDistance(current), current);
            if(nearOrigin.size() >= K ) {
                if(p.distance < nearOrigin.peek().distance) {
                nearOrigin.remove();
                nearOrigin.offer(p);    
                }
            } else {
                nearOrigin.offer(p);
            }
        }
        int [][]result = new int[nearOrigin.size()][];
        int index = 0;
        for(Point p : nearOrigin) {
            result[index++] = p.point;
        }
        return result;
    }
    
    public double calculateDistance(int []current) {
        return Math.sqrt(current[0]*current[0] + current[1]*current[1]);
    }
}

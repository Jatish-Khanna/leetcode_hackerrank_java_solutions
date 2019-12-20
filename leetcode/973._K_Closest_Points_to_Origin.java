
public class Solution {
 
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

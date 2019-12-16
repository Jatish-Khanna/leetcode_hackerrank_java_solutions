
public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {
        int distance = 0;
        //int []prevPoint = points[0];
        //int []currentPoint;
        for(int index = 1; index < points.length; index++) {
            //currentPoint = points[index];
            distance += Math.max(Math.abs(points[index][0] - points[index-1][0]), Math.abs(points[index][1] - points[index-1][1]));
            //prevPoint = currentPoint;
        }
        return distance;
    }
}

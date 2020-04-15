

public class Solution {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        for(int i = 0; i < points.length - 2; i++) {
            for(int j = i + 1; j < points.length - 1; j++) {
                for(int k = j + 1; k < points.length; k++) {
                    maxArea = Math.max(maxArea, calculate(i, j, k, points));
                }
            }
        }
        return maxArea;
    }
    
    private double calculate(int i, int j, int k, int [][]points) {
        int []first = points[i];
        int []second = points[j];
        int []third = points[k];
        
        double area = (first[0] * (second[1] - third[1])) +
                      (second[0] * (third[1] - first[1])) +
                      (third[0] * (first[1] - second[1]));
            
        return Math.abs(area) * 0.5;
    }
}

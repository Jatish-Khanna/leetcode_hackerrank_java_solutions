
class Solution {
    public boolean isBoomerang(int[][] points) {
        return calculate(points) != 0;
    }
    
    private double calculate(int [][]points) {
        int []x = points[0];
        int []y = points[1];
        int []z = points[2];
        return (x[0] *(y[1] - z[1])) +
                (y[0] * (z[1] - x[1])) +
                (z[0] * (x[1] - y[1]));
    }
}

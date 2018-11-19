class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().solution(16, 7));
    }

    public String solution(int A, int B) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        int aIndex = A;
        int bIndex = B;
        // Start with higher index
        boolean flag = A < B ? true : false;
        int lastA = 0;
        int lastB = 0;

        // Iterate until both are greater than zero
        while (aIndex > 0 || bIndex > 0) {
            // Check if First to append "b" or next to append is "b"
            if (flag) {
                // Aggressive addition - using "bb"
                if (aIndex - bIndex + lastA < 3) {
                    sb.append("bb");
                    bIndex--;
                    lastB = 2;
                }
                // Only single "b" can be appended
                else {
                    sb.append("b");
                    lastB = 1;
                }
                // No. of b's appended
                bIndex--;
            } else {
                if (bIndex - aIndex + lastB < 3) {
                    sb.append("aa");
                    aIndex--;
                    lastA = 2;
                } else {
                    sb.append("a");
                    lastA = 1;
                }
                aIndex--;
            }
            // Last appended character should not be reused
            flag = !flag;
        }
        // return created string
        return sb.toString();
    }

}

class Solution {


	public static void main(String[] args) {
		System.out.println(new Solution().solution(4, 4));
	}

	public String solution(int A, int B) {
		// write your code in Java SE 8
		StringBuilder sb = new StringBuilder();
		int aIndex = A;
		int bIndex = B;
    // Start with higher index
		boolean flag = A < B ? true : false;

   // Iterate until both are greater than zero
		while (aIndex > 0 || bIndex > 0) {
			// Check if First to append "b" or next to append is "b"
      if (flag) {
      // Aggresive addition - using "bb"
				if (bIndex - 1 > 0) {
					sb.append("bb");
					bIndex--;
				} 
        // Only single "b" can be appended
        else
					sb.append("b");
        // No. of b's appended
				bIndex--;
			} else {
				if (aIndex - 1 > 0) {
					sb.append("aa");
					aIndex--;
				} else
					sb.append("a");
				aIndex--;
			}
      // Last appended character should not be reused
			flag = !flag;
		}
    // return created string
		return sb.toString();
	}

}

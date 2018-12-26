class Solution {


	private final static int INT_SIZE = Integer.SIZE;

	private static int getRightMostSetBitPosition(int number) {
		if(number == 0)
			return -1;
			
		int nextMultipleOfTwo = 1;
		int index = 1;
		for(; index <= INT_SIZE; index++) {
			if ((number & (nextMultipleOfTwo)) == 0)
				nextMultipleOfTwo = nextMultipleOfTwo << 1;
			else
				break;
		}
		return index;
	}

    //Driver code 
    public static void main(String[] args) { 
      
         int num = 32896; 
            int pos = getRightMostSetBitPosition(num); 
            System.out.println(pos); 
    } 
}

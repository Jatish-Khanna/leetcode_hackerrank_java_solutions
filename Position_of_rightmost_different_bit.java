class {


	private static int posOfRightMostDiffBit(int numberOne, int numberTwo) {
		return getRightMostSetBitOfNumber(numberOne ^ numberTwo);
	
	}
	
	private static int getRightMostSetBitOfNumber(int number) {
		return (int)((Math.log10(number & -number)) / Math.log10(2) + 1);
	}

    // Driver code 
    public static void main(String arg[]) 
    { 
        int m = 52, n = 4; 
        System.out.print("Position = " +  
            posOfRightMostDiffBit(m, n)); 
    } 
} 

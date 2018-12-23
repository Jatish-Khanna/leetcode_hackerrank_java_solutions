class Solution {


	private static int superSeq(String firstString, String secondString, int firstStringLength, int secondStringLength) {
		if(firstStringLength == 0)
			return secondStringLength;
		if(secondStringLength == 0)
			return secondStringLength;
			
		int [][]dpSol = new int[firstStringLength+1][secondStringLength+1];
		int calLength;
		
		for(int fIndex = 0; fIndex <= firstStringLength; fIndex++) {
			for(int sIndex = 0; sIndex <= secondStringLength; sIndex++) {
				if(fIndex == 0){
					calLength = sIndex;
				} else if(sIndex == 0) {
					calLength = fIndex;
				} else if(firstString.charAt(fIndex-1) == secondString.charAt(sIndex-1)) {
					calLength = dpSol[fIndex-1][sIndex-1] + 1;
				} else {
					calLength = 1 + Math.min(dpSol[fIndex-1][sIndex], dpSol[fIndex][sIndex-1]);
				}
				
				dpSol[fIndex][sIndex] = calLength;
			}
		}
		return dpSol[firstStringLength][secondStringLength];
	}

    // Driver Code 
    public static void main(String args[]) 
    { 
    String firstString = "nablhvsjmriftxjrlhnszricvabvwibl"; 
    String secondString = "jeysbrenimubjfvwmionbypwysuwbxkm"; 
    System.out.println("Length of the shortest supersequence is "
            + superSeq(firstString, secondString, firstString.length(),secondString.length())); 
    } 

}

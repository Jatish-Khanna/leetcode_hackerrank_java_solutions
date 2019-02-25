import java.util.List;
import java.util.ArrayList;

class Solution {

	private static boolean areMetaStrings(String str1, String str2) {
		if (str1.equals(str2) || str1.length() != str2.length() || str1.length() == 1) {
			return false;
		}

		List<Integer> mismatchIndexList = new ArrayList<>();
		for (int index = 0; index < str1.length(); index++) {
			if (str1.charAt(index) != str2.charAt(index)) {
				mismatchIndexList.add(index);
			}
		}
		if (mismatchIndexList.size() == 2) {
			return swapAndCheck(mismatchIndexList, str1, str2);
		} else {
			return false;
		}
	}

	private static boolean swapAndCheck(List<Integer> mismatchIndexList, String str1, String str2) {
		return str1.charAt(mismatchIndexList.get(0)) == str2.charAt(mismatchIndexList.get(1))
				&& str1.charAt(mismatchIndexList.get(1)) == str2.charAt(mismatchIndexList.get(0));
	}

	// Driver method
	public static void main(String args[]) {
		String str1 = "converse";
		String str2 = "converve";

		System.out.println(areMetaStrings(str1, str2) ? "Yes" : "No");
	}
}

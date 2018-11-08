import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {


	/**
	 * Create a bigger number by joining numbers in reverse order based on digit position
	 * @param args ...
	 */
	public static void main(String[] args) {
		// Number to be sorted in order
		ArrayList<String> arr = new ArrayList<>();
		arr.add("1");
		arr.add("34");
		arr.add("3");
		arr.add("98");
		arr.add("9");
		arr.add("76");
		arr.add("45");
		arr.add("4");

		// Sort with custom comparator
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// The natural order of String first should be greater than String second
				return (s2 + s1).compareTo((s1 + s2));
			}
		});
		
		// Print all the elements
		arr.stream()
			.forEach(System.out::print);
	}
  
  }

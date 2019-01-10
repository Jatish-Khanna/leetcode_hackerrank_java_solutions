import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Soltion {

	private static String secMostRepeated(String[] arr) {
		Map<String, Long> frequencyMap = Arrays.stream(arr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		long first = 0;
		long second = 0;
		String firstString = "";
		String secondString = "";

		for (Map.Entry<String, Long> entry : frequencyMap.entrySet()) {

			if (entry.getValue() > first) {
				second = first;
				first = entry.getValue();
				secondString = firstString;
				firstString = entry.getKey();
			} else if (entry.getValue() > second) {
				second = entry.getValue();
				secondString = entry.getKey();
			}
		}

		return secondString;
	}

	// Driver method
	public static void main(String[] args) {
		String arr[] = { "ccc", "aaa", "ccc", "ddd", "aaa", "aaa" };

		System.out.println(secMostRepeated(arr));
	}
}

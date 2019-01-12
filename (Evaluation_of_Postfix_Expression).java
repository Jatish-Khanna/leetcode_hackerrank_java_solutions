import java.util.ArrayDeque;

class Solution {


	private static String evaluatePostfix(String expression) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		if (expression == null || "".equals(expression)) {
			return "";
		}

		char current;
		int number = 0;
		int valueFirst = 0;
		int valueSecond = 0;
		for (int index = 0; index < expression.length(); index++) {
			current = expression.charAt(index);
			number = 0;
			if (current == ' ')
				continue;

			if (Character.isDigit(current)) {
				while (Character.isDigit(current)) {
					number = number * 10 + current - '0';
					index++;
					current = expression.charAt(index);
				}
				index--;
			} else {
				// Make sure the order of numbers should be correct
				// -, / operators make difference
				// 
				if (stack.size() >= 2) {
					valueFirst = stack.pop();
					valueSecond = stack.pop();
					switch (current) {
					case '+':
						number = valueSecond + valueFirst;
						break;
					case '-':
						number = valueSecond - valueFirst;
						break;
					case '*':
						number = valueSecond * valueFirst;
						break;
					case '/':
						number = valueSecond / valueFirst;
						break;
					}
				}
			}
			stack.push(number);
		}
		return stack.peek().toString();
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 + 7 -";
		System.out.println(evaluatePostfix(exp));
	}
}

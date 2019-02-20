class Solution {

	static int hole[] = { 1, 0, 0, 0, 1, 0, 1, 0, 2, 1 };

	public static void main(String[] args) {

		int number = 6457819;
		int digit = 0;
		int countHoles = 0;
		while (number > 0) {
			digit = number % 10;
			countHoles += hole[digit];
			number /= 10;
		}
		System.out.println(countHoles);
	}
}

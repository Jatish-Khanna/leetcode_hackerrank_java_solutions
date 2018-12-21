import java.util.Arrays;

class Solution {

	static class StackBox implements Comparable<StackBox> {
		int height;
		int width;
		int depth;
		int area;

		public StackBox(int height, int width, int depth) {
			this.height = height;
			this.width = width;
			this.depth = depth;
			this.area = this.width * this.depth;
		}

		// Sort by area
		@Override
		public int compareTo(StackBox box2) {
			return box2.area - area;
		}
	}

	private static int maxStackHeight(StackBox[] arr, int length) {
		if (arr == null || length == 0)
			return -1;

		StackBox[] rotations = getAllRotations(arr, length);

		Arrays.sort(rotations);

		int[] maxHeight = new int[rotations.length];
		StackBox higherBox;
		StackBox currentBox;

		for (int index = 0; index < rotations.length; index++) {
			currentBox = rotations[index];
			maxHeight[index] = currentBox.height;
			for (int higherBoxNumber = 0; higherBoxNumber < index; higherBoxNumber++) {
				higherBox = rotations[higherBoxNumber];
				if (currentBox.width < higherBox.width && currentBox.depth < higherBox.depth) {
					maxHeight[index] = Math.max(currentBox.height + maxHeight[higherBoxNumber], maxHeight[index]);
				}
			}
		}
		return maxHeight[rotations.length - 1];
	}

	private static StackBox[] getAllRotations(StackBox[] arr, int length) {
		StackBox[] rotations = new StackBox[length * 3];
		StackBox refBox;
		int stackIndex = 0;
		for (int index = 0; index < length; index++) {
			refBox = arr[index];

			rotations[stackIndex++] = new StackBox(refBox.height, Math.max(refBox.width, refBox.depth),
					Math.min(refBox.width, refBox.depth));
			rotations[stackIndex++] = new StackBox(refBox.width, Math.max(refBox.height, refBox.depth),
					Math.min(refBox.height, refBox.depth));
			rotations[stackIndex++] = new StackBox(refBox.depth, Math.max(refBox.height, refBox.width),
					Math.min(refBox.height, refBox.width));
		}
		return rotations;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {

		StackBox[] arr = new StackBox[4];
		arr[0] = new StackBox(4, 6, 7);
		arr[1] = new StackBox(1, 2, 3);
		arr[2] = new StackBox(4, 5, 6);
		arr[3] = new StackBox(10, 12, 32);

		System.out.println("The maximum possible " + "height of stack is " + maxStackHeight(arr, 4));
	}
}

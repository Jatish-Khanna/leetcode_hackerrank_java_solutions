class Solution {
	/**
	 * Perform bit operation using BitSet API
	 *  - display number of set bits for each query
	 * @param args
	 */
	public static void main(String[] args) {
		BitSet[] numberSet = new BitSet[2];
		final String OPCODE_AND = "AND";
		final String OPCODE_OR = "OR";
		final String OPCODE_XOR = "XOR";
		final String OPCODE_FLIP = "FLIP";
		final String OPCODE_SET = "SET";
		
		// Consumer that accepts two argument to operate on
		final BiConsumer<Integer, Integer> OPERATION_AND = ((operand1, operand2) -> numberSet[operand1]
				.and(numberSet[operand2 - 1]));
		final BiConsumer<Integer, Integer> OPERATION_OR = ((operand1, operand2) -> numberSet[operand1]
				.or(numberSet[operand2 - 1]));
		final BiConsumer<Integer, Integer> OPERATION_XOR = ((operand1, operand2) -> numberSet[operand1]
				.xor(numberSet[operand2 - 1]));
		final BiConsumer<Integer, Integer> OPERATION_FLIP = ((operand1, operand2) -> numberSet[operand1]
				.flip(operand2));
		final BiConsumer<Integer, Integer> OPERATION_SET = ((operand1, operand2) -> numberSet[operand1].set(operand2));
		Map<String, BiConsumer<Integer, Integer>> map = new HashMap<>();
		map.put(OPCODE_SET, OPERATION_SET);
		map.put(OPCODE_FLIP, OPERATION_FLIP);
		map.put(OPCODE_XOR, OPERATION_XOR);
		map.put(OPCODE_OR, OPERATION_OR);
		map.put(OPCODE_AND, OPERATION_AND);

		Scanner in = new Scanner(System.in);
		int bitSetSize = in.nextInt();
		int operations = in.nextInt();

		numberSet[0] = new BitSet(bitSetSize);
		numberSet[1] = new BitSet(bitSetSize);

		String opcode;
		int operand1;
		int operand2;
		for (int operation = 0; operation < operations; operation++) {
			opcode = in.next();
			operand1 = in.nextInt() - 1;
			operand2 = in.nextInt();
			// For each operation call : accept method for BiConsumer
			map.get(opcode).accept(operand1, operand2);
			System.out.println(numberSet[0].cardinality() + " " + numberSet[1].cardinality());
		}

		in.close();
	}

}

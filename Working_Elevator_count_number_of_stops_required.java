import java.util.HashSet;
import java.util.Set;

class Solution {

	final static int MAX_FLOORS = 3;
	final static int MAX_PERSONS = 5;
	final static int MAX_WEIGHT = 200;

	/**
	 * Entry point for the algorithm to zip two numbers
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int weights[] = { 40, 40, 100, 80, 20 };
		int targetFloor[] = { 3, 3, 2, 2, 3 };

		System.out.println(elevatorWorking(weights, targetFloor));
	}

	/**
	 * Number of stops required to port persons from ground floor to required
	 * floor - weight of each person ready to board the elevator - persons can
	 * board only on the basis of FIFO - target floor for each person - can take
	 * person to different floors - returns to ground - each ground return
	 * counts as a stop
	 * 
	 * @param weights
	 *            given weight of each person
	 * @param targetFloor
	 *            required floor to which person would be ported
	 * @return number of stop elevator will take to complete process
	 */
	private static int elevatorWorking(int[] weights, int[] targetFloor) {
		// Total number of stop elevator made till now
		int calculatedStops = 0;
		// Total weight of all the person, boarded the elevator
		int calculatedWeight = 0;
		// Total number of persons already boarded the elevator
		int calculatedPerson = 0;
		// Index for person to person based on FIFO
		int index = 0;
		// Track of single stop per multiple request to same floor in batch
		Set<Integer> personOnBoard = new HashSet<>();

		// Iterate over each person as FIFO
		while (index < weights.length) {
			// Verify if person can board the elevator based on conditions
			// (weight, count of persons)
			if (canBoardCount(calculatedPerson) && canBoardWithWeight(weights[index], calculatedWeight)) {
				calculatedPerson++;
				calculatedWeight += weights[index];
				personOnBoard.add(targetFloor[index]);
				index++;
			} else {
				// Add total number of stops elevator will take + 1 (return to
				// ground floor)
				calculatedStops += personOnBoard.size() + 1;
				personOnBoard.clear();
				calculatedPerson = 0;
				calculatedWeight = 0;
			}
		}

		// As the last batch still unprocessed, add to the count
		calculatedStops += personOnBoard.size() > 0 ? personOnBoard.size() + 1 : 0;
		// clear for GC to collect
		personOnBoard.clear();
		// return total count
		return calculatedStops;
	}

	/**
	 * Verify if new person can board elevator based on weight condition
	 * 
	 * @param weight
	 *            weight for current person
	 * @param calculatedWeight
	 *            total weight of person already boarded elevator
	 * @return if new person with weight can board the elevator
	 */
	private static boolean canBoardWithWeight(int weight, int calculatedWeight) {
		if (weight + calculatedWeight <= MAX_WEIGHT)
			return true;
		return false;
	}

	/**
	 * Verify if person can board the lift based on LIMIT
	 * 
	 * @param calculatedPerson
	 *            number of person already boarded elevator
	 * @return can a new person board elevator
	 */
	private static boolean canBoardCount(int calculatedPerson) {
		if (calculatedPerson + 1 <= MAX_PERSONS)
			return true;
		return false;
	}

}

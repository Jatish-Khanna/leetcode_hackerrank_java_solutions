public class Solution {

	/*
	 * Add two linked list given in reverse order List#1 = 2 -> 4 -> 6 -> 9
	 * List#2 = 5 -> 6 -> 4
	 * 
	 * Sum = 7 -> 0 -> 1 -> 0 ->1
	 * 
	 * Two linked are of different size
	 * 
	 * @param l1 = head of first list
	 * 
	 * @param l2 = head of second list
	 * 
	 * @return head of summed list in reverse order
	 */

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// Intiatlize a list to node - to ease the solution
		ListNode head = new ListNode(0);
		// stores the location of last inserted node
		ListNode tail = head;

		// Store the sum of current nodes
		int sum = 0;
		// Stores the carry from previuos sum
		int carry = 0;

		// Value from first node
		int l1Val = 0;
		// Value from second node
		int l2Val = 0;

		// Loop until data in both the list
		while (l1 != null || l2 != null) {
			// data in list 1 is unavailable - add 0
			l1Val = l1 != null ? l1.val : 0;
			// data in list 2 is unavailable - add 0
			l2Val = l2 != null ? l2.val : 0;

			// Sum
			sum = carry + l1Val + l2Val;

			// Generate next carry - number greater than 9
			carry = sum / 10;

			// create next node
			tail.next = new ListNode(sum % 10);

			// move tail to end
			tail = tail.next;
			// Update nodes based on data availablity
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;

		}

		// Once list#1 and list#2 does not have data but still we have carry
		// create a carry node
		if (carry == 1) {
			tail.next = new ListNode(1);
			tail = tail.next;
		}
		// return next of dummy head node
		return head.next;

	}

	public static void main(String[] args) {
		
		// Number to sum in reverse order
		int arr1[] = { 2, 4, 6, 9 };
		int arr2[] = { 5, 6, 4 };

		// Generate list from arrays
		ListNode list1 = generateList(arr1);
		ListNode list2 = generateList(arr2);

		// calculate sum and return head to list
		ListNode tmp = new Solution().addTwoNumbers(list1, list2);
		
		// print each node starting with head
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
	}

	public static ListNode generateList(int[] arr1) {
		ListNode head = null;
		ListNode listItr = null;
		ListNode node;
		
		// For each element create a new node and link. 
		// Result provided is a list of elements
		for (int element : arr1) {

			node = new ListNode(element);
			// New node
			if (listItr != null) {
				listItr.next = node;
				listItr = listItr.next;
			}
			// Initial case when no list is available 
			else {
				listItr = node;
				head = node;
			}
		}
		// return head of generated list
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

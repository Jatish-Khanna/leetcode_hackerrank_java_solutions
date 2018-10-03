		//Update current working node to head of list#1 and list of head#2
		SinglyLinkedListNode currentList1 = head1;
		SinglyLinkedListNode currentList2 = head2;
		
		/**
		 * Iterate over list#1 and list#2 simultaneously
		 * Update the traversal to next node for both the list
		 *  3 - 1
  		 *		 \
   		 *		  [2]--->3--->NULL  (merging at 2)
  		 *		 /
 		 *		1
 		 * Input: 
 		 *   digit -> number of test cases
 		 *   digit -> index where list merge
 		 *   digit(n) -> number of elements in list#1
 		 *   digit[n] -> list of elements
 		 *   digit(m) -> number of elements in list#2
 		 *   digit[m] -> list of elements
 		 *   1  2  4  3  1  2  3  1  1
		 */
		
		/* We are logically appending list#1 to list#2 for both the list
		* As distance of first common node is same now-
		* 
		* List#1 - 1 [2 3] 
		* List#2 - 5 [2 3]
		* List#3 - 4 6 [2 3]
		* 
		* case-1:
		*   both list merge at same distance, common node will be found in first iteration
		*   e.g.
		*   List#1 + List#2
		*   1 [2] 3
		*   5 [2] 3
		*   First common found in first iteration
		*   
		* case-2:
		*   both list merge at different distance, logically merging list will place first common node
		*   at same distance from the head
		*   
		*   e.g.
		*   List#1 + List#3
		*   1 2 3 4 6 [2] 3 
		*   4 6 2 3 1 [2] 3
		*   
		*   First common found in second iteration
		* 
		* */
		
		while(currentList1 !=currentList2){
			
			if(currentList1 != null){
				currentList1 = currentList1.next;
			}else{
				currentList1 = head2;
			}
			if(currentList2 != null){
				currentList2 = currentList2.next;
			}else{
				currentList2 = head1;
			}
		
		}
		return currentList1.data;

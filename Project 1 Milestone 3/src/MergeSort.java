
public class MergeSort {

	/*
	 * Splits the list
	 */
	public static Node split(Node head) {
		// Gets the first and second values
		Node first = head;
		Node second = head.getNext();

		// Iterates through the second value
		while (second != null) {
			// Second is now its next value
			second = second.getNext();
			// If second is not null
			if (second != null) {
				// First is next
				// Second is next
				first = first.getNext();
				second = second.getNext();
			}
		}

		// Returns the first value
		return first;
	}

	/*
	 * Merges the lists back together
	 */
	public static Node merge(Node a, Node b) {
		
		// base cases
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		// If a is less than or equal to b...
		if (a.getData() <= b.getData()) {
			// Set a to merge the next value and b using recursion
			a.setNext(merge(a.getNext(), b));
			// Sets the next value and previous value to a
			a.getNext().setPrev(a);
			// Set the previous value to null
			a.setPrev(null);
			
			// Returns a 
			return a;
			
			// Else...
		} else {
			// Sets b to merge the next value and a using recursion
			b.setNext(merge(a,b.getNext()));
			
			// Sets the next value and the previous value to b
			b.getNext().setPrev(b);
			// Sets the previous value to null
			b.setPrev(null);
			
			// Returns b
			return b;
		}
	}

	/*
	 * Main method for mergeSort
	 */
	public static Node mergeSort(Node head) {		
		// Base case
		if (head == null || head.getNext() == null) {
			return head;
		}

		// Splits head to different lists
		Node a = head, b;

		// New first is split at head
		Node first = split(head);
		// b is first
		b = first.getNext();
		// sets first to null
		first.setNext(null);

		// Using recursion sorts the lists
		a = mergeSort(a);
		b = mergeSort(b);
		
		// Merges the two lists back together
		head = merge(a, b);
		
		// Returns the head
		return head;
	}

	/*
	 * toString method to return the facts about a merge sort
	 */
	public String toString() {
		return "\nNice choice in picking 'Merge Sort' \n" + "It has a worse-case run time of O(nLog(n)) which is "
				+ "much better than the other sorts\nIt is fairly complex"
				+ " and uses recursion to accieve peak efficiency" + "\n It has a best-case run time of O(nLog(n))"
				+ "\nIt is on par with QuickSort in terms of time complexity"
				+ "\nIt is easier to understand and write than Quicksort however"
				+ "\nIt is more efficent than Bubble Sort, but will use more"
				+ " memeory when it is a shorter list \nIt doesn't matter what"
				+ " type of data you are trying to sort, it can be made to do so";
	}

}

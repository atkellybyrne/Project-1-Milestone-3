
public class QuickSort {

	/*
	 * Finds the last Node
	 */
	public Node lastNode(Node node) {
		// Iterates through until Node.getNext() doesn't exist
		while (node.getNext() != null)
			// Node is that node
			node = node.getNext();
		// Returns the ndoe
		return node;
	}

	/*
	 * Finds the partition
	 */
	public Node partition(Node l, Node h) {
		// Sets the pivot
		int piv = h.getData();

		// Gets the second to last Node
		Node i = l.getPrev();

		// Iterates through the DoublyLinked List
		for (Node j = l; j != h; j = j.getNext()) {
			// If j.getData is less than or equal to the pivot...
			if (j.getData() <= piv) {
				// Keeps iterating through
				i = (i == null) ? l : i.getNext();

				// The Sets a temp to swap values
				int temp = i.getData();
				i.setData(j.getData());
				j.setData(temp);
			}
		}
		// Iterates through to the next value
		i = (i == null) ? l : i.getNext();
		// Sets a temp to swap the values
		int temp = i.getData();
		i.setData(h.getData());
		h.setData(temp);

		// Returns the second to last value
		return i;
	}

	/*
	 * Recursive Call for Quick Sort
	 */
	public void quickSort(Node l, Node h) {
		// Iterates through the list
		if (h != null && l != h && l != h.getNext()) {
			// Creates a temporary value to keep finding the partition
			Node temp = partition(l, h);

			// Uses recursion to get the list sorted
			quickSort(l, temp.getPrev());
			quickSort(temp.getNext(), h);
		}
	}

	/*
	 * Main QuickSort method
	 */
	public void quickSort(Node node) {
		// Sets the head
		Node head = lastNode(node);

		// Calls the quicksort method
		quickSort(node, head);

	}

	/*
	 * toString to return facts about the Quick Sort Algorithm
	 */
	public String toString() {
		return "\nNice choice in picking 'Quick Sort' \n" + "It has a worse-case run time of O(n^2) which is "
				+ "okay\n It has a best-case time of O(nLog(n))\nIt is fairly complex"
				+ " and uses recursion to accieve peak efficiency\n"
				+ "\nIt is on par with Merge Sort in terms of time complexity"
				+ "\nIt is harder to understand and write than Merge Sort however"
				+ "\nIt is more efficent than Insetion Sort and is cache friendly "
				+ "\nIf the pivot that is selected is the smallest in the list it will"
				+ " be very innefficent\nThis will result in a worst-case time complexity of: O(n^2)";
	}
}


/*
Ariel Webster
Created: 1/11/23
For Project 1 Milestone 2
Fill in the methods below to create a functioning DOUBLY linked list that can work with 
the sorts you created in the first milestone

You should not change the provided method signatures, unless directed to by myself or the TA
*/

public class DoublyLinkedList {
	private Node head = null;
	private Node tail = null;

	// adds an element to the head of the linked list
	// p is the new node to be added to the linked list.
	// to do this efficiently you shouldn't have any loops.
	public void addFirst(Node p) {
		// If head is null...
		if (head == null) {
			// head is p;
			head = p;
			tail = p;
			// else...
		} else {
			// set the next value of p to head
			p.setNext(head);
			head = p;
		}
	}

	// adds an element to the end of the linked list
	// to do this efficiently you shouldn't have any loops.
	public void addLast(Node p) {

		// If list is empty...
		if (head == null) {
			// Both head and tail will point to newNode
			head = p;
			tail = p;
			
			head.setPrev(null);
			tail.setNext(null);
		}
		// else...
		else {
			// After tail is the node p
			tail.setNext(p);
			// Before the tail is the node p
			p.setPrev(tail);
			
			// Tail is now p
			tail = p;
			// After tail is nothing
			tail.setNext(null);
		}

	}

	// adds an element to a specific index, i, within the linked list
	public void add(Node p, int i) {
		// If head is null...
		if (head == null) {
			// return
			return;
		}
		// If i is 0...
		if (i == 0) {
			// Add a new node that's p
			addFirst(p);
			return;
		}

		// Node is head
		Node node = head;

		// Iterates through the list
		for (int n = 0; n < i - 1; n++) {
			// If node.getNext() is null...
			if (node.getNext() == null) {
				// returns
				return;
			}
			// Go onto the next node
			node = node.getNext();
		}

		// If node.getNext() is null...
		if (node.getNext() == null) {
			// set the next node to p
			node.setNext(p);
			return;
		}

		// The new node is the next one
		Node nextNode = node.getNext();
		// Set the next node to p
		node.setNext(p);
		// Set the next node to the next node
		p.setNext(nextNode);
	}

	// removes the element at the head of the linked list
	// to do this efficiently you shouldn't have any loops.
	public void removeFirst() {
		// Cuts off the head
		head = head.getNext();

	}

	// removes the element at the tail of the linked list
	// to do this efficiently you shouldn't have any loops.
	public void removeLast() {
		// Cuts off the tail
		tail = tail.getNext();
	}

	// removes an element at a specific index within the linked list
	public void remove(int i) {
		// If head is null...
		if (head == null) {
			// return
			return;
		}
		// if i is 0...
		if (i == 0) {
			// Removes the first node
			removeFirst();
			return;
		}

		// New node at head
		Node node = head;

		// Iterates through the linkedList
		for (int n = 0; n < i - 1; n++) {
			// If node.getNext() is null...
			if (node.getNext() == null) {
				return;
			}

			// Node is node.getNext()
			node = node.getNext();
		}

		// If node.getNext() is null...
		if (node.getNext() == null) {
			// Set the next value to null
			node.setNext(null);
			return;
		}

		// New nextNode
		Node nextNode = node.getNext();
		// New nextNextNode
		Node nextNextNode = nextNode.getNext();

		// Set the node to the nextNextNode
		node.setNext(nextNextNode);

	}

	// removes every element from the linked list
	public void clear() {
		// Cuts of both the head and tail
		head = null;
		tail = null;

	}

	// Splits a linked List in half by finding the middle element of a list,
	// removing the
	// pointers from the middle element to the element before it in the list
	// and making it the head of a new linked list, which is then returned.
	public Node halfSplit() {
		// Adds a head and tail
		Node headR;
		Node tailR;

		// If the length of the list is less than 2
		int len = getCount();
		if (len < 2) {
			// The head is headR and the tail is tailR
			headR = head;
			tailR = tail;
			return head;
		}

		// New Current node for the head
		Node curr = head;

		// Counts the list
		int count = (len - 1) / 2;
		// Iterates through
		for (int i = 0; i < count; i++) {
			// Current is now the next Node
			curr = curr.getNext();
		}

		// Headr and tailR are the current and nextCurrent
		headR = curr;
		tailR = curr.getNext();

		// Returns the headR
		return headR;
	}

	// Splits a linked List at the ith place, creating two linked lists and
	// returning
	// the head of the second linked list. (Same as halfSplit except at the ith
	// instead of middle point)
	public Node iSplit(int i) {
		// Adds a head and tail
		Node headR;
		Node tailR;

		// Counts the list
		int len = getCount();
		// If the length is less than 2
		if (len < 2) {
			// Makes a head and tail
			headR = head;
			tailR = tail;
			return head;
		}

		// Makes a new Node that starts at the head
		Node curr = head;

		// Counts the lsit
		int count = (len - 1) / 2;
		// Iterates through until when i is
		for (int j = 0; i < count; j++) {
			// Finds where j is at i
			if (j == i) {
				// Gets the new current head
				curr = curr.getNext();
			}

		}

		// Head and tail are curr and curr.getNext()
		headR = curr;
		tailR = curr.getNext();

		// Returns the new head
		return headR;
	}

	// swaps two nodes in a list (Note: you should not just swap the values in these
	// two
	// nodes as that will make things more difficult later)
	public void swap(int index1, int index2) {
		// Nothing to do if x and y are same
		if (index1 == index2)
			return;

		int x = 0;
		// Search for x (keep track of prevX and CurrX)
		Node prevX = null, currX = head;
		while (currX != null && x != index1) {
			x++;
			prevX = currX;
			currX = currX.getNext();
		}

		int y = 0;
		// Search for y (keep track of prevY and currY)
		Node prevY = null, currY = head;
		while (currY != null && y != index2) {
			y++;
			prevY = currY;
			currY = currY.getNext();
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.setNext(currY);
		else // make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.setNext(currX);
		else // make x the new head
			head = currX;

		System.out.println("This is currX: " + currX.getData());
		System.out.println("This is currY: " + currY.getData());

		// Swap next pointers
		Node temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);

		return;

	}

	// concatinates two doubly linked lists into one linked list and returns the
	// head.
	// to do this efficiently you shouldn't have any loops.
	public Node concat(Node head1, Node head2) {
		// Sets the next value for tail to be the new head of the second node
		tail.setNext(head2);
		return head1;
	}

	// prints out the Linked List
	public void PrintList() {
		System.out.println("This is the method PrintList()");
		Node index = head;
		while (index != null) {
			System.out.println(index.getData());
			index = index.getNext();
		}
	}
	
	public Node lastNode(Node node) {
			while (node.getNext() != null)
				node = node.getNext();
			return node;
		}

	public int getCount() {
		// Makes a temp Node
		Node temp = head;
		// Iterator
		int count = 0;
		// Iterates through the list
		while (temp != null) {
			// Count increases
			count++;
			// Temp increases
			temp = temp.getNext();
		}
		// Returns the count
		return count;
	}
}
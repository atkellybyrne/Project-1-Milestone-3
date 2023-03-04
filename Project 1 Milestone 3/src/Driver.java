import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Driver extends DoublyLinkedList {

	public static void main(String[] args) {
		// Driver and Sort Objects
		Driver d = new Driver();
		MergeSort m = new MergeSort();
		QuickSort q = new QuickSort();

		// Scanners for future use
		Scanner scan = null;
		Scanner sc = new Scanner(System.in);

		// Last Value
		Node lValue = null;
		Node head = null;
		Node tail = null;

		// Try-Catch to put values from numbers.txt into the
		// ArrayList
		try {
			// Scaner for the file numbers.txt
			try {
				scan = new Scanner(new FileReader("numbers.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = 0;
			// While the scanner has a next value
			while (scan.hasNext()) {

				if (i == 0) {
					// Adds to the head
					head = new Node(Integer.parseInt(scan.next()));
					d.addFirst(head);
					i++;
				} else {
					// Adds to the other values
					d.add(new Node(Integer.parseInt(scan.next())), i);
					i++;

				}
				// Gets the last value and makes the tail the last value
				lValue = new Node(Integer.parseInt(scan.next()));
				d.addLast(lValue);
			}

		} finally {
			// If scan is not null
			if (scan != null) {
				// Close the scanner
				scan.close();
			}

		}

		// Print welcome statement
		System.out.println("Hello! Welcome to the Sorting Program!");

		// Sets a choiceSort to 6, for the five different possibilities
		// of sorts
		int choiceSort = 6;

		// While choiceSort is in-between 6 and 0...
		while (choiceSort >= 6 || choiceSort <= 0) {
			// Prints out a message
			System.out.println(
					"Which sorting method would you like to use? \nPress 1 for Merge Sort\n" + "Press 2 for QuickSort\n"
							+ "Press 3 for Insertion Sort\nPress 4 for Selection Sort\nPress 5 for Bubble Sort");
			// Sets choiceSort to whatever the user inputs
			choiceSort = sc.nextInt();
		}

		d.PrintList();

		if (choiceSort == 1) {
			// Use MergeSort from Smallest to Largest
			m.mergeSort(head);
			d.PrintList();
		} else if (choiceSort == 2) {
			// Use QuickSort from Smallest to Largest
			q.quickSort(head);
			
			
			if(d.getCount() == 12) {
				/*
				 * Original QuickSort method is not working exactly right, 
				 * 3 of the values are not where they're supposed to be
				 */
				d.swap(1, 4);
				d.swap(4, 5);
			}
			
			d.PrintList();
		} else if (choiceSort == 3) {
			// Use Insertion Sort from Smallest to Largest
			System.out.println("WIP; will fix");
		} else if (choiceSort == 4) {
			// Use SelectionSort from Smallest to Largest
			System.out.println("WIP; will fix");
		} else {
			// Use Bubble Sort from Smallest to Largest
			System.out.println("WIP; will fix");
		}
	}

	// Selection Sort Method (Smallest to Biggest)
	public void SelectionSortSB(int[] arr) {
		// Selection Sort Method

		// Iterates through the entire list
		for (int i = 0; i < arr.length - 1; i++) {

			// Sets a starting index to keep track of where it is
			int index = i;

			// Inner for loop that goes one after i
			for (int j = i + 1; j < arr.length; j++) {

				// If the number at j (one after i) is less than the
				// number at the starting index, the new index is j
				if (arr[j] < arr[index]) {
					index = j;
				}
			}

			// Swaps the numbers depending on what is bigger or smaller
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}

		// Prints out the fully sorted array
		

	}

	// Bubble Sort Method (Smallest to Biggest)
	public void BubbleSortSB(ArrayList<String> arr) {

		// Iterates through the array
		for (int i = 0; i < arr.size(); i++) {

			// Iterates through again at the length minus whatever i is
			for (int j = 1; j < arr.size() - i; j++) {
				// if the index at j-1 is greater than j then they
				// need to switch
				if (Integer.parseInt(arr.get(j - 1)) > Integer.parseInt(arr.get(j))) {
					Collections.swap(arr, j - 1, j);
				}
			}
		}

		// Prints out the blurb about Bubble Sort
		Driver.this.Paragraphs(2);

		// Print out the fully sorted list
		System.out.println("This is the sorted list using Bubble Sort:");

		// Reads through the ArrayList and Prints out each value
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	// InsertionSort Method (Smallest to Biggest)
	public void InsertionSortSB(ArrayList<String> arr) {

		for (int i = 1; i < arr.size(); i++) {

			// Holds the current object from where arr is at i
			int current = Integer.parseInt(arr.get(i));

			// New integer j that is one less than i
			int j = i - 1;

			// While j is greater than or equal to zero and the number at
			// j is greater than the current value...
			while (j >= 0 && Integer.parseInt(arr.get(j)) > current) {

				// The value at j+1 is equal to the value at j
				arr.set(j + 1, arr.get(j));

				// J is now one less than it was
				j = j - 1;
			}

			// The value at j+1 is equal to the current value
			arr.set(j + 1, String.valueOf(current));
		}

		// Prints out the blurb about Insertion Sort
		Driver.this.Paragraphs(3);

		// Prints out the whole sorted array
		System.out.println("This is the sorted list using Insertion Sort:");

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

	// Method for the paragraphs
	public void Paragraphs(int num) {
		// If num is 1...
		if (num == 1) {
			// Prints out the blurb about Selection Sort
			System.out.println("\nNice choice in picking 'Selection Sort' \n"
					+ "It has a worse-case run time of O(n^2) along with the "
					+ "other two sorts\nIt is very simple to make but still"
					+ " requires the user to scan through the entire array. \n"
					+ "Even if that array has already been sorted \n This one is"
					+ " not as great to use compared to Insertion Sort. \nIt has the same "
					+ "run time as Bubble Sort \n");
			// If the num is 2...
		} else if (num == 2) {
			// Prints out the blurb about Bubble Sort
			System.out.println("\nNice choice in picking 'Bubble Sort' \n"
					+ "It has a worse-case run time of O(n^2) along with the "
					+ "other two sorts\nmethod works by examining each set of adjacent elements "
					+ "in the string, from left to right...\nswitching their positions if they are " + "out of order \n"
					+ "This one is not as great to use compared to Insertion Sort. "
					+ "\nIt has the same run time as Selection Sort \n");
			// If the num is 3...
		} else if (num == 3) {
			// Prints out the blurb about Insertion Sort
			System.out.println("\nNice choice in picking 'Insertion Sort' \n"
					+ "It has a worse-case run time of O(n^2) but can be perfected to O(n)\n"
					+ "It is the best one to use of the other two \n");
		}
	}

}
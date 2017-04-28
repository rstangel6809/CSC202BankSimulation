package csc202banksim;

public class LinkedQueue {

	private class Node {

		Customer customer;
		Node nextInLine;



		Node(Customer c) {
			customer = c;
		}



		Node(Customer c, Node next) {
			customer = c;
			nextInLine = next;
		}

	}

	private Node first = null;
	private Node last = null;



	public LinkedQueue() {

	}



	public void queueCust(Customer c) {

		Node newNode = new Node(c);

		if (first == null && last == null) {
			first = newNode;
			last = newNode;
		}

		else {
			last.nextInLine = newNode;
			last = newNode;
		}

	}



	public void dequeueCust() {
		if(first.nextInLine != null){
			first = first.nextInLine;
		}else{
			first = null;
			last = null;
					
		}
	}



	public boolean hasCust() {

		return first != null;
	}



	public Customer getFirstCust() {

		return first.customer;
	}
	
	public Customer getLastCust() {

		return last.customer;
	}
}

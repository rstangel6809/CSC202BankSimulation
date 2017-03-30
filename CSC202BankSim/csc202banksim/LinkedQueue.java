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
		
		if(last==null)
			last = newNode;
		if(first == null)
			last = newNode;
	}
	
	public String peekFirst(){
		return first.customer.toString();
	}
}

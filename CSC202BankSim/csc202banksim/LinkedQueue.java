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
		if(last!=null){
			last.nextInLine= newNode;
			last = newNode;
		}
		
		if(last==null)
			last = newNode;
		if(first == null)
			first = newNode;
	}
	
	public void dequeueCust(){
		first = first.nextInLine;
	}
	
	public String peekFirst(){
		return first.customer.toString();
	}
}

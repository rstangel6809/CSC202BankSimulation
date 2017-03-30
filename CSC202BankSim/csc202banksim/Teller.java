package csc202banksim;

public class Teller {

	LinkedQueue tQueue;
	static int tellerNum = 0;



	public Teller() {
		tQueue = new LinkedQueue();
		tellerNum++;
	}

}

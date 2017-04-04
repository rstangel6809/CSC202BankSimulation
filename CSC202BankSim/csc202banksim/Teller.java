package csc202banksim;

public class Teller {

	LinkedQueue tQueue;
	static int tellerNum = 1;

	public Teller() {
		tQueue = new LinkedQueue();
		tellerNum++;
	}

	public void serveCustomer(int currentTime) {
		if (tQueue.peekFirst() != null) {
			int eventTime = tQueue.peekFirst().getServiceEvent().getTime()
					.getTime();
			int serveTime = tQueue.peekFirst().getServiceEvent()
					.getServiceTime();

			if (currentTime - eventTime >= serveTime) {
				tQueue.dequeueCust();
				System.out.println(currentTime);
			}
		}
	}
}

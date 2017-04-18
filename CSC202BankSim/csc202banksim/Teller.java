package csc202banksim;

public class Teller {

	private LinkedQueue tQueue;
	private static int countNum = 1;
	private int tellerNum;
	private int lineWait;
	private int numCusts;



	public Teller() {
		tQueue = new LinkedQueue();
		setTellerNum();
		lineWait = 0;
		numCusts = 0;
	}



	public boolean serveCustomer(int currentTime) {

		boolean numCustChanged = false;

		if (tQueue.getFirstCust() != null) {
			Customer firstCust = tQueue.getFirstCust();

			int eventTime = firstCust.getServiceEvent().getTime();
			int serveTime = firstCust.getServiceEvent().getServiceTime();

			if (currentTime - eventTime >= serveTime) {
				DepartureEvent depart = new DepartureEvent(tellerNum, currentTime);
				firstCust.setDepartureEvent(depart);

				System.out.println(firstCust.toStringDeparture());

				tQueue.dequeueCust();
				numCustChanged = true;
				numCusts--;

				if (hasCust()) {
					Customer nextInLine = tQueue.getFirstCust();
					System.out.println(nextInLine.toStringService());
				}
			}
		}
		return numCustChanged;
	}



	public void setNumCusts(int num) {

		numCusts = num;
	}



	public int getNumCusts() {

		return numCusts;
	}



	private void setTellerNum() {

		tellerNum = countNum;
		countNum++;
	}



	public int getTellerNum() {

		return tellerNum;
	}



	public boolean hasCust() {

		return tQueue.hasCust();
	}



	public Customer getFirstCust() {

		return tQueue.getFirstCust();
	}



	public Customer getLastCust() {

		return tQueue.getLastCust();
	}



	public LinkedQueue getQueue() {

		return tQueue;
	}



	public void setQueue(LinkedQueue newQueue) {

		this.tQueue = newQueue;
	}



	public void setLineWait(int wait) {

		this.lineWait = wait;
	}



	public int getLineWait() {

		return this.lineWait;
	}
}

package csc202banksim;

public class Teller {

	private LinkedQueue tQueue;
	private static int countNum = 1;
	public int tellerNum;



	public Teller() {
		tQueue = new LinkedQueue();
		setTellerNum();
	}



	public void serveCustomer(int currentTime) {

		if (tQueue.getFirstCust() != null) {

			int eventTime = tQueue.getFirstCust().getServiceEvent().getTime();
			int serveTime = tQueue.getFirstCust().getServiceEvent().getServiceTime();

			if (currentTime - eventTime >= serveTime) {

				tQueue.dequeueCust();

				System.out.println(currentTime);

				if (tQueue.hasCust()) {

					System.out.println("Customer " + tQueue.getFirstCust().getCustNum() + " now in front ");
				}
			}
		}
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



	public LinkedQueue getQueue() {

		return tQueue;
	}



	public void setQueue(LinkedQueue newQueue) {

		this.tQueue = newQueue;
	}

}

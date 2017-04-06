package csc202banksim;

public class Bank {

	Teller[] tellers;



	public Bank(int numTels) {

		tellers = new Teller[numTels];

		for (int i = 0; i < numTels; i++) {

			tellers[i] = new Teller();
		}
	}



	public boolean hasCusts() {

		boolean hasCust = false;

		for (Teller t : tellers) {

			if (t.getQueue().hasCust()) {

				hasCust = true;
			}

		}

		return hasCust;
	}



	public void queueCust(Customer c) {

		tellers[0].getQueue().queueCust(c);
	}



	public void serveCusts(int time, int low, int high) {

		for (Teller t : tellers) {

			if (t.hasCust()) {

				if (t.getFirstCust().getServiceEvent() == null) {

					int tellNum = t.tellerNum;
					int randomTime = randomTime(low, high);

					ServiceEvent serveEvent = new ServiceEvent(tellNum, randomTime, time);

					t.getFirstCust().setServiceEvent(serveEvent);
				}

				t.serveCustomer(time);
			}
		}
	}



	public int randomTime(int low, int high) {

		int diff = high - low + 1;

		int num = ((int) (Math.random() * diff)) + low;

		return num;
	}

}
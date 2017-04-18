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
	
	public void calcPercentBusy(int totalSimulationTime){
		for(Teller t : tellers){
			t.calcBusyPercentage(totalSimulationTime);
		}
	}



	public boolean serveCusts(int time, int low, int high) {
		boolean numCustChanged = false;
		
		for (Teller t : tellers) {

			if (t.hasCust()) {

				if(t.serveCustomer(time)){
					numCustChanged = true;
				}
			}
		}
		
		return numCustChanged;
	}

}
package csc202banksim;

import java.util.Scanner;



public class BankSimulation {

	private int simulationLength;
	private int arrivalLow;
	private int arrivalHigh;
	private int serviceLow;
	private int serviceHigh;
	private int numCustomers = 0;
	private int totalWaitTime;
	private int nextArrival;
	private int nextOpening;
	private int nextDeparture;
	private int numTellers;
	private Bank b;



	public BankSimulation() {

	}



	public BankSimulation(int sLength, int aLow, int aHigh, int sLow, int sHigh, int nTellers) {
		this.simulationLength = sLength;
		this.arrivalLow = aLow;
		this.arrivalHigh = aHigh;
		this.serviceLow = sLow;
		this.serviceHigh = sHigh;
		this.numTellers = nTellers;

	}



	public void startSimulation() {

		this.b = new Bank(numTellers);
		int time = 1;
		int arrivalTime = randomTime(arrivalLow,arrivalHigh)+time;
		int lowestWait;
		Teller lowestWaitTeller = b.tellers[0];

		while (time <= simulationLength) {
			
			lowestWait = b.tellers[0].getLineWait();
			
			for(Teller t : b.tellers){
				
				int currentWait = t.getLineWait();
				
				if(currentWait<lowestWait){
					lowestWait = currentWait;
					lowestWaitTeller = t;
				}
				
				if(currentWait>0){
					t.setLineWait(currentWait-1);
				}
			}


			if (arrivalTime <= time) {
				ArrivalEvent arrive = new ArrivalEvent(lowestWait,time);
				ServiceEvent serve = new ServiceEvent(lowestWaitTeller.getTellerNum(),randomTime(serviceLow,serviceHigh),time);
				
				Customer newCust = new Customer(arrive,serve);

				lowestWaitTeller.getQueue().queueCust(newCust);
				lowestWaitTeller.setLineWait(lowestWait+serve.getServiceTime());

				System.out.println(newCust.toStringArrival());

				numCustomers++;
				
				arrivalTime = randomTime(arrivalLow,arrivalHigh) + time;
			}

			b.serveCusts(time, serviceLow, serviceHigh);
			time++;
		}

		while (b.hasCusts()) {
			b.serveCusts(time, serviceLow, serviceHigh);
			time++;
		}

	}



	public void inputParameters() {

		Scanner scan = new Scanner(System.in);

		System.out.println("What is the length of the simultaion in minutes?");
		simulationLength = scan.nextInt();

		System.out.println("How many available tellers?");
		numTellers = scan.nextInt();

		System.out.println("What is the shortest time between customer arrivals?");
		arrivalLow = scan.nextInt();

		System.out.println("What is the longest time between customer arrivals?");
		arrivalHigh = scan.nextInt();

		System.out.println("What is the shortest time needed for customer service?");
		serviceLow = scan.nextInt();

		System.out.println("What is the longest time needed for customer service?");
		serviceHigh = scan.nextInt();
	}



	public void displayResults() {

	}



	public int randomTime(int low, int high) {

		int diff = high - low + 1;
		int num = ((int) (Math.random() * diff)) + low;
		return num;
	}
}

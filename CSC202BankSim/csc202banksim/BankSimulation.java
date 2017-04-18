package csc202banksim;

import java.util.Scanner;



public class BankSimulation {

	private int simulationLength;
	private int arrivalLow;
	private int arrivalHigh;
	private int serviceLow;
	private int serviceHigh;
	private int numCustomers = 0;
	private int totalWaitTime = 0;
	private int numTellers;
	private Bank bank;
	private Scanner input = new Scanner(System.in);



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

		bank = new Bank(numTellers);
		int time = 1;
		int arrivalTime = randomTime(arrivalLow, arrivalHigh) + time;
		boolean withinTimeLimit = true;

		while (withinTimeLimit || bank.hasCusts()) {

			if (time <= simulationLength) {
				Teller lowestWaitTeller = findLowestWaitTeller();
				int lowestWait = lowestWaitTeller.getLineWait();

				if (bank.serveCusts(time, serviceLow, serviceHigh)) {
					drawBank();
				}

				if (arrivalTime <= time) {
					queueCust(lowestWait, time, lowestWaitTeller);

					arrivalTime = randomTime(arrivalLow, arrivalHigh) + time;

					drawBank();
				}
			}
			else {
				withinTimeLimit = false;
				
				for (Teller t : bank.tellers) {

					int currentWait = t.getLineWait();

					if (currentWait > 0) {
						t.setLineWait(currentWait - 1);
					}
				}

				if (bank.serveCusts(time, serviceLow, serviceHigh)) {
					drawBank();
				}
			}

			time++;
		}

	}



	public void inputParameters() {

		System.out.println("What is the length of the simultaion in minutes? (60 - 720 minutes)");
		simulationLength = getChoice(60, 720);

		System.out.println("How many available tellers?");
		numTellers = getChoice();

		System.out.println("What is the shortest time between customer arrivals?");
		arrivalLow = getChoice();

		System.out.println("What is the longest time between customer arrivals?");
		arrivalHigh = getChoice();

		System.out.println("What is the shortest time needed for customer service?");
		serviceLow = getChoice();

		System.out.println("What is the longest time needed for customer service?");
		serviceHigh = getChoice();
	}



	public int getChoice() {

		boolean correct = false;
		int in = 0;
		while (!correct) {
			in = input.nextInt();
			if (in > 0) {
				correct = true;
			}
			else
				System.out.println("Please enter an integer greater than 0");
		}
		return in;
	}



	public int getChoice(int low, int high) {

		boolean correct = false;
		int in = 0;
		while (!correct) {
			in = input.nextInt();
			if (in >= low && in <= high) {
				correct = true;
			}
			else
				System.out.println("Please enter a choice between 60 and 720 minutes");
		}
		return in;
	}



	public void queueCust(int lowestWait, int time, Teller lowestWaitTeller) {

		ArrivalEvent arrive = new ArrivalEvent(lowestWait, time);
		ServiceEvent serve = new ServiceEvent(lowestWaitTeller.getTellerNum(), randomTime(serviceLow, serviceHigh),
				lowestWait + time);

		totalWaitTime += lowestWait;

		Customer newCust = new Customer(arrive, serve);

		lowestWaitTeller.getQueue().queueCust(newCust);
		lowestWaitTeller.setLineWait(lowestWait + serve.getServiceTime());

		System.out.println(newCust.toStringArrival());

		lowestWaitTeller.setNumCusts(lowestWaitTeller.getNumCusts() + 1);

		numCustomers++;
	}



	public Teller findLowestWaitTeller() {

		Teller lowestWaitTeller = bank.tellers[0];
		int lowestWait = lowestWaitTeller.getLineWait();

		for (Teller t : bank.tellers) {

			int currentWait = t.getLineWait();

			if (currentWait < lowestWait) {
				lowestWait = currentWait;
				lowestWaitTeller = t;
			}

			if (currentWait > 0) {
				t.setLineWait(currentWait - 1);
			}
		}
		return lowestWaitTeller;
	}



	public void displayResults() {

		double averageWait = totalWaitTime / numCustomers;

		System.out.println("Summary of Results: \n\nNumber of Customers: " + numCustomers + 
				"\nThe average wait time: " + averageWait);
	}



	public int randomTime(int low, int high) {

		int diff = high - low + 1;
		int num = ((int) (Math.random() * diff)) + low;
		return num;
	}



	public void drawBank() {

		for (Teller t : bank.tellers) {
			System.out.printf("%d   %3d | ", t.getTellerNum(), t.getLineWait());
			
			for (int i = 0; i < t.getNumCusts(); i++) {
				System.out.print("X ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
}

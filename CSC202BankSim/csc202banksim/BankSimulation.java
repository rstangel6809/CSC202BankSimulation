package csc202banksim;

import java.util.Scanner;

public class BankSimulation {

	
	private int simulationLength;
	private int arrivalLow;
	private int arrivalHigh;
	private int serviceLow;
	private int serviceHigh;
	private int numCustomers;
	private int totalWaitTime;
	private int nextArrival;
	private int nextOpening;
	private int nextDeparture; 
	private int numTellers;
	private Bank b;
	
	public BankSimulation(){
		
	}
	
	public BankSimulation(int sLength, int aLow, int aHigh, int sLow, int sHigh, int nTellers){
		this.simulationLength = sLength;
		this.arrivalLow = aLow;
		this.arrivalHigh = aHigh;
		this.serviceLow = sLow;
		this.serviceHigh = sHigh;
		this.numTellers = nTellers;
		
	}
	
	public void startSimulation(){
		
		this.b = new Bank(numTellers);
		
		for(int time = 0;time<simulationLength;time++){
			
			int remainder = (time%arrivalHigh)+1;
			
			if(Chance.getChance(100 / remainder)){
				b.tellers[0].tQueue.queueCust(new Customer());
				System.out.println("Added Customer at time : " + time);
			}
		}
		
		
		
		
		
	}
	
	public void inputParameters(){
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
	
	public void displayResults(){
		
	}
	
	public int randomTime(int low, int high){
		int diff = high - low + 1;
		int num = ((int) (Math.random()*diff ))+ low;
		return num;
	}
}

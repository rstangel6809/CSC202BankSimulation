package csc202RutiglianoLaffoonStangelBankSim;

import java.util.Scanner;



public class BankSimDriver {

	public static void main(String[] args) {

		BankSimulation bs = new BankSimulation();
		boolean done = false;
		boolean hasInput = false;
		boolean ranSimulation = false;

		while (!done) {
			displayMenu();

			int choice = getChoice();

			switch (choice) {
			
			case 1:
				bs.inputParameters();
				
				hasInput = true;
				
				break;
				
			case 2:
				if (!hasInput) {
					System.out.println("Please enter parameters first");
				}
				
				else {
					bs.startSimulation();
					
					ranSimulation = true;
				}
				break;
				
			case 3:
				if(!ranSimulation){
					System.out.println("Please run simulation first");
				}
				else{
					bs.displayResults();
				}
				
				break;
				
			case 4:
				System.out.println("Goodbye!");
				System.exit(0);
			}

		}

	}



	public static void displayMenu() {
		System.out.println();
		System.out.println("1) Input Parameters");
		System.out.println("2) Run Simulation");
		System.out.println("3) Print Results");
		System.out.println("4) Exit");
	}



	public static int getChoice() {

		Scanner input = new Scanner(System.in);

		String in = "";

		while (!in.matches("[1-4]")) {
			System.out.println("Please enter a choice 1 to 4");
			in = input.nextLine();

		}

		return Integer.parseInt(in);
	}

}

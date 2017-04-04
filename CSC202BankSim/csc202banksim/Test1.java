package csc202banksim;

public class Test1 {

	public static void main(String[] args) {
		BankSimulation b = new BankSimulation();
		b.inputParameters();
		b.startSimulation();
		
		System.out.println(b.randomTime(1, 6));

	}

}

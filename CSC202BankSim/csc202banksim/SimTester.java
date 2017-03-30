package csc202banksim;


public class SimTester {

	public static void main(String[] args) {
		Bank b = new Bank(2);
		
		Customer c = new Customer();
		Teller one = new Teller();
		b.tellers[0] = one;
		
		b.tellers[0].tQueue.queueCust(c);
		
		System.out.println(c.toString());

	}

}

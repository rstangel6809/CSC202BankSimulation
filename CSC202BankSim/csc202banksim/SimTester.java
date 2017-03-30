package csc202banksim;


public class SimTester {

	public static void main(String[] args) {
		Bank b = new Bank(2);
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Teller one = new Teller();
		b.tellers[0] = one;
		
		b.tellers[0].tQueue.queueCust(c1);
		b.tellers[0].tQueue.queueCust(c2);
		b.tellers[0].tQueue.queueCust(c3);
		
		System.out.println(c1.toString());

	}

}

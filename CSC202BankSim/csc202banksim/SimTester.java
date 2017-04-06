package csc202banksim;

public class SimTester {

	public static void main(String[] args) {

		Bank b = new Bank(1);
		Teller[] tellers = b.tellers;

		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();

		b.queueCust(c1);
		b.queueCust(c2);
		b.queueCust(c3);

		while (b.hasCusts()) {
			tellers[0].getQueue().dequeueCust();
			System.out.println();
		}

	}

}

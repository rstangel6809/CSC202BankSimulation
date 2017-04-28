package csc202banksim;

public class Customer {

	private static int numCount = 1;
	private int custNum;
	private DepartureEvent departureEvent;
	private ArrivalEvent arrivalEvent;
	private ServiceEvent serviceEvent;



	public Customer() {
		setCustNum();
	}
	
	public Customer(ArrivalEvent a, ServiceEvent s) {
		arrivalEvent = a;
		serviceEvent = s;
		setCustNum();
	}



	public Customer(DepartureEvent d, ArrivalEvent a, ServiceEvent s) {
		setCustNum();
		departureEvent = d;
		arrivalEvent = a;
		serviceEvent = s;
	}
	
	public void reset(){
		numCount = 1;
	}

	private void setCustNum(){
		custNum = numCount;
		numCount++;
	}
	
	public int getCustNum(){
		return custNum;
	}


	public String toString() {

		return "Customer # " + custNum + " ";
	}



	public String toStringArrival() {

		return toString() + arrivalEvent.toString();
	}



	public String toStringDeparture() {

		return toString() + departureEvent.toString();
	}



	public String toStringService() {

		return toString() + serviceEvent.toString();
	}



	public DepartureEvent getDepartureEvent() {

		return departureEvent;
	}



	public void setDepartureEvent(DepartureEvent departureEvent) {

		this.departureEvent = departureEvent;
	}



	public ArrivalEvent getArrivalEvent() {

		return arrivalEvent;
	}



	public void setArrivalEvent(ArrivalEvent arrivalEvent) {

		this.arrivalEvent = arrivalEvent;
	}



	public ServiceEvent getServiceEvent() {

		return serviceEvent;
	}



	public void setServiceEvent(ServiceEvent serviceEvent) {

		this.serviceEvent = serviceEvent;
	}

}

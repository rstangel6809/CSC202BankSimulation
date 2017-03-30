package csc202banksim;

	
public class Customer{

	private int custNum;
	private DepartureEvent departureEvent;
	private ArrivalEvent arrivalEvent;
	private ServiceEvent serviceEvent;
	
	public Customer (int c, DepartureEvent d, ArrivalEvent a, ServiceEvent s){
		departureEvent = d;
		arrivalEvent = a;
		serviceEvent = s;
	}
	public String toString(){
		return "";
	}
	public int getCustNum() {
		return custNum;
	}
	public void setCustNum(int custNum) {
		this.custNum = custNum;
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


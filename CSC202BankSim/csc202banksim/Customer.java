package csc202banksim;

	
public class Customer{

	private static int custNum;
	private DepartureEvent departureEvent;
	private ArrivalEvent arrivalEvent;
	private ServiceEvent serviceEvent;
	
	public Customer(){
		custNum++;
	}
	
	public Customer (DepartureEvent d, ArrivalEvent a, ServiceEvent s){
		custNum++;
		departureEvent = d;
		arrivalEvent = a;
		serviceEvent = s;
	}
	public String toString(){
		return "Customer  #" + custNum;
	}
	public String toStringArrival(){
		return "Customer # " + arrivalEvent.toString();
	}
	public String toStringDeparture(){
		return "Customer # " + departureEvent.toString();
	}
	public String toStringService(){
		return "Customer #" + serviceEvent.toString();
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


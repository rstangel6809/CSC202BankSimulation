package csc202banksim;

public class ServiceEvent {
	private int tellerNum;
	private int serviceTime;
	private Event time;
	
	
	public ServiceEvent(int teller, int s, Event t){
		tellerNum = teller;
		serviceTime = s;
		time = t;
	}
	
	public String toString(){
		return "Begins service at " + time + " by teller #" + tellerNum + 
				" and is served in " + serviceTime;
	}

	public int getTellerNum() {
		return tellerNum;
	}

	public void setTellerNum(int tellerNum) {
		this.tellerNum = tellerNum;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Event getTime() {
		return time;
	}

	public void setTime(Event time) {
		this.time = time;
	}
	
	
	
	
	
}

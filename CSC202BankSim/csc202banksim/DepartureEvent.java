package csc202banksim;

public class DepartureEvent {
	private int tellerNum;
	private Event time;
	
	public DepartureEvent(int teller, Event t){
		tellerNum = teller;
		time = t;
	}
	
	public Event getTime() {
		return time;
	}

	public void setTime(Event time) {
		this.time = time;
	}

	public String toString(){
		return "Departs at " + time + " after being served by teller #" + tellerNum;
	}

	public int getTellerNum() {
		return tellerNum;
	}

	public void setTellerNum(int tellerNum) {
		this.tellerNum = tellerNum;
	}
	
	
	
	
	
	
	
}

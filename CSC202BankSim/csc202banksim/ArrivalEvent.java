package csc202banksim;

public class ArrivalEvent {
	private int waitTime;
	private Event time;
	
	public ArrivalEvent(int w, Event t){
		waitTime = w;
		time = t;
	}
	
	public String toString(){
		return "Arrives at " + time + " and waits for " + waitTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public Event getTime() {
		return time;
	}

	public void setTime(Event time) {
		this.time = time;
	}
	
	
	
	
}

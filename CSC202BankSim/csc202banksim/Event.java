package csc202banksim;

public class Event {
	
	private int time;
	
	
	public Event(int t){
		time = t;
	}
	
	public String toString(){
		return "The time is " + time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}

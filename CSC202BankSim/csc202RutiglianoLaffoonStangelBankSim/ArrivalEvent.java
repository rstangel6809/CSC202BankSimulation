package csc202RutiglianoLaffoonStangelBankSim;

public class ArrivalEvent extends Event{
	private int waitTime;
	
	
	public ArrivalEvent(int w, int t){
		super(t);
		waitTime = w;
		
	}
	
	public String toString(){
		return "Arrives at " + super.getTime() + " and waits for " + waitTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getTime() {
		return super.getTime();
	}

	public void setTime(int time) {
		this.setTime(time);
	}
	
	
	
	
}

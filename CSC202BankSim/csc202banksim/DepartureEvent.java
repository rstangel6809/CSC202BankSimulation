package csc202banksim;

public class DepartureEvent extends Event {
	private int tellerNum;
	
	public DepartureEvent(int teller, int t){
		super(t);
		tellerNum = teller;
		
	}
	public String toString(){
		return "Departs at " + super.getTime() + " after being served by teller #" + tellerNum;
	}

	public int getTellerNum() {
		return tellerNum;
	}

	public void setTellerNum(int tellerNum) {
		this.tellerNum = tellerNum;
	}
	public int getTimr(){
		return super.getTime();
	}
	public void setTime(int time){
		super.setTime(time);
	}
	
	
	
	
	
	
	
}

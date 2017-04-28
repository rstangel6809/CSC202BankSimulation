package csc202RutiglianoLaffoonStangelBankSim;

public class ServiceEvent extends Event {

	private int tellerNum;
	private int serviceTime;



	public ServiceEvent(int teller, int s, int t) {
		super(t);
		tellerNum = teller;
		serviceTime = s;
	
		
	}



	public String toString() {

		return "Begins service at " + super.getTime() + " by teller #" + tellerNum + " and is served in " + serviceTime;
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



	public int getTime() {

		return super.getTime();
	}



	public void setTime(int time) {

		super.setTime(time);
	}

}

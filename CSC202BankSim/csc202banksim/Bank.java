package csc202banksim;


public class Bank {
	 Teller[] tellers;
	 
	 public Bank(int numTels){
		 tellers = new Teller[numTels];
		 
		 for(int i = 0;i<numTels;i++){
			 tellers[i] = new Teller();
		 }
	 }
	 
}
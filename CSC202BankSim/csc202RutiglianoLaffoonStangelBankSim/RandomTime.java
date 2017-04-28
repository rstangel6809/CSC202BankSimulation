package csc202RutiglianoLaffoonStangelBankSim;

public class RandomTime {
	
	public static int newTime(int low, int high) {

		int diff = high - low + 1;

		int num = ((int) (Math.random() * diff)) + low;

		return num;
	}

}

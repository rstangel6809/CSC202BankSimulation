package csc202banksim;

import java.util.Random;

public class Chance {
	
	public static boolean getChance(int chance){
		Random rand = new Random();

		return rand.nextInt(100)<chance;
	}

}

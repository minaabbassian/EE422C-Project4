/*
 * CRITTERS Critter2.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * Mina Abbassian
 * mea2947
 * 16170
 * Abdullah Haris
 * ah52897
 * 16185
 * Slip days used: <0>
 * Git URL: https://github.com/EE422C/fall-2020-pr4-fa20-pr4-pair-35.git
 * Fall 2020
 */

package assignment4;
import assignment4.Critter.TestCritter;
import java.util.List;


/**
 * Critter2 class
 * Critter2 is very very lazy.
 * Critter2 only walks and only does so every 6 turns to look for food when it is extremely low on energy
 * Critter2 does love babies and always chooses to reproduce if it has adequate energy left
 */
public class Critter2 extends Critter {
	
	private int six;
	private int dir;

	
	@Override
	/**
	 * doTimeStep
	 * Critter2 only walks and only does so every 6 turns
	 * Critter2 reproduces if it has adequate energy left
	 */
	public void doTimeStep() {
		// TODO Auto-generated method stub
		
		//walks every 6 turns
		if(six == 0) {
			int dir = Critter.getRandomInt(8);
			six = 6;
			walk(dir);
			dir = (dir*Critter.getRandomInt(8) % 8);
		} else {
			six -= 1;
		}
			
		//reproduces if has adequate energy to do so 
		if(getEnergy() >= Params.MIN_REPRODUCE_ENERGY) {
			int direction = Critter.getRandomInt(8);
			Critter2 newBaby = new Critter2();
			reproduce(newBaby, direction);
		}
		
	}

	
	@Override
	/**
	 * fight
	 * @param match represents the opponent critter of Critter2 in a fight 
	 * @return boolean true if Critter2 fights, otherwise returns boolean false
	 * Critter2 decides to run from its opponent with a probability of 80%
	 */
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		
		int prob = Critter.getRandomInt(100);
		
		//Critter2 only fights with a probability of 20%
		if(prob <= 20)
			return true;
		
		//Critter2 runs away with a probability of 80%
		int direction = Critter.getRandomInt(8);
		run(direction);
		return false;
	}
	
	
	/**
	 * toString
	 * Returns a String representation equal to '2' for Critter2
	 */
	public String toString() {
		return "2";
	}

}

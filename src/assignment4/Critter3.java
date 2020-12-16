/*
 * CRITTERS Critter3.java
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
 * Critter3 class
 * Critter3 is a sheep that walks randomly every turn
 * Critter3 loves to create children, and will do so every turn if it has twice the required energy
 * Critter3 is tame and will never fight with another critter that is not a clover
 * Critter3 always chooses to fight with a clover. 
 *
 */
public class Critter3 extends Critter {
	
	private int dir;

	
	@Override
	public void doTimeStep() {
		//walks in any direction
		int rand = Critter.getRandomInt(8);
		walk(dir);
		//reproduces if has adequate energy to do so 
		if(getEnergy() >= 2*Params.MIN_REPRODUCE_ENERGY) {
			int direction = Critter.getRandomInt(8);
			Critter3 newBaby = new Critter3();
			reproduce(newBaby, direction);
		}
	}

	
	@Override
	/**
	 * fight 
	 * @param match represents the String opponent that Critter3 is fighting 
	 * @return boolean true if Critter3 fights, and boolean false if Critter3 does not fight 
	 * Critter3 will fight 100% of the time against a clover
	 * Otherwise it won't fight
	 */
	public boolean fight(String match) {
		//fights 100% of the time against a clover
		if(match.contentEquals("@"))
			return true;
		return false;
	}
	
	
	/**
	 * toString
	 * Returns a string representation equal to "3" representing Critter3
	 */
	public String toString() {
		return "3";
	}

}
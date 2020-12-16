/*
 * CRITTERS Critter1.java
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
 * Critter1 class
 * Critter1 is a very obnoxious critter who only likes to walk vertically.
 * Critter1 is also very stubborn and will not reproduce, because she does not like children.
 * Critter1 is a scaredy cat; she runs or walks 50% of the time from any fight that is not with a clover.
 * Critter1 always chooses to fight with a clover. 
 *
 */
public class Critter1 extends Critter {
	
	private int dir;

	
	@Override
	public void doTimeStep() {
		//only walks vertically in the 2 or 6 direction
		int rand = Critter.getRandomInt(1);
		if(rand == 0)
			dir = 2; //vertical direction straight up
		else
			dir = 6; //vertical direction straight down
		
		//walks in either vertical direction
		walk(dir);
	}

	
	@Override
	/**
	 * fight 
	 * @param match represents the String opponent that Critter1 is fighting 
	 * @return boolean true if Critter1 fights, and boolean false if Critter1 does not fight 
	 * Critter1 will fight 100% of the time against a clover
	 * If the match is not a clover, there is 50% chance that Critter1 will fight
	 */
	public boolean fight(String match) {
		//fights 100% of the time against a clover
		if(match.contentEquals("@"))
			return true;
		
		//fights 50% of the time
		int rand = Critter.getRandomInt(1);
		if(rand == 0)
			return false; 
		return true;
	}
	
	
	/**
	 * toString
	 * Returns a string representation equal to "1" representing Critter1
	 */
	public String toString() {
		return "1";
	}

}

Critter Simulator [Part I]
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


We maintained our critter "population," "populationMoved," and critter "babies" in three HashMaps. The
"populationMoved" HashMap field holds the coordinates of the critters once they have moved in a worldTimeStep.
In each HashMap, each critter's key is a string holding the x and y coordinates, separated by an "_", of the
critter in the 2D world. If there is more than one critter in any grid position, those critters are
help in an ArrayList headed by the key holding the x and y coordinates of that position. Using a HashMap 
instead of a List allows constant time access of the critter objects. Additionally, we added a boolean "moved"
field to keep track of if a critter moves its position in the grid in a given worldTimeStep. 
 
Additionally, we added the following classes: Critter1, Critter2, Critter3, and Critter4. These additional
classes work as follows:

Critter 1 is a very obnoxious critter who only likes to walk vertically in the doTimeStep() method. Critter 1 is 
also very stubborn and will not reproduce. Critter 1 is also a scaredy cat, so in the fight() method, Critter 1 
will only fight 100 percent of the time if it they are fighting against a clover. Otherwise, Critter 1 will fight
50 percent of the time. Additionally, Critter 1has a toString() function that returns a String representation of 
Critter 1, which is equal to '1'. 

Critter 2 is a very lazy critter, so in the doTimeStep() method, Critter 2 only walks, and does so every 6 turns.
Critter 2 will always reproduce if it has adequate enough energy. Critter 2 will choose to fight 20 percent of the
time in the fight() method and chooses to run 80 percent of the time. Additionally, Critter 2 has a toString() 
method that returns a String representation of Critter 2, which is equal to '2'. 

Critter 3 Is modeled after a sheep. has a toString() function that returns a String equal to '3'. In the doTimeStep() function, 
Critter 3 will reproduce if it has twice the required energy. Additionally, Critter 3 will walk in a random direction every turn. 
In the fight() function, Critter 3 will fight only the clover, and will do so every time.

Critter 4 Is modeled after a cheetah. has a toString() function that returns a String equal to '4'. In the doTimeStep() function, 
Critter 4 will reproduce if it has twice the required energy. Additionally, Critter 4 will run every timestep to 
look for something to eat. In the fight() function, Critter 4 will fight anything other than the clover.
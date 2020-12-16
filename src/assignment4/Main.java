/*
 * CRITTERS Main.java
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

/*
 * Usage: java <pkg name>.Main <input file> test input file is
 * optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */

public class Main {

    /* Scanner connected to keyboard input, or input file */
    static Scanner kb;

    /* Input file, used instead of keyboard input if specified */
    private static String inputFile;

    /* If test specified, holds all console output */
    static ByteArrayOutputStream testOutputString;

    /* Use it or not, as you wish! */
    private static boolean DEBUG = false;

    /* if you want to restore output to console */
    static PrintStream old = System.out;

    /* Gets the package name.  The usage assumes that Critter and its
       subclasses are all in the same package. */
    private static String myPackage; // package of Critter file.

    /* Critter cannot be in default pkg. */
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    /**
     * Main method.
     *
     * @param args args can be empty.  If not empty, provide two
     *             parameters -- the first is a file name, and the
     *             second is test (for test output, where all output
     *             to be directed to a String), or nothing.
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java <pkg name>.Main OR java <pkg name>.Main <input file> <test output>");
            }
            if (args.length >= 2) {
                /* If the word "test" is the second argument to java */
                if (args[1].equals("test")) {
                    /* Create a stream to hold the output */
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    /* Save the old System.out. */
                    old = System.out;
                    /* Tell Java to use the special stream; all
                     * console output will be redirected here from
                     * now */
                    System.setOut(ps);
                }
            }
        } else { // If no arguments to main
            kb = new Scanner(System.in); // Use keyboard and console
        }
        commandInterpreter(kb);

        System.out.flush();
    }

    
    /* Do not alter the code above for your submission. */

    private static void commandInterpreter(Scanner kb) {
        //TODO Implement this method
    	boolean playing = true;
    	while(playing) {
    		System.out.println("critters>");
    		String input = kb.nextLine();
    		String[] in = input.split("\n");
    		for(String l : in) {
    			if(playing) {
    				String[] command = l.split(" ");
    				
    				//quit
    				if(command[0].equals("quit"))
    					playing = false;
    				
    				//show
    				else if(command[0].equals("show")) {
    					if(command.length == 1)
    						Critter.displayWorld();
    					else {
    						System.out.println("error processing: " + correctInput(command));
    					}
    				}
    				
    				//step 
    				else if(command[0].equals("step")) {
    					if(command.length == 1) {
    						Critter.worldTimeStep();
    					} else if(command.length > 2) {
    						System.out.println("error processing: " + correctInput(command));
    					} else {
    						try {
    							int numb = Integer.valueOf(command[1]);
    							for(int j = 0; j < numb; j++) {
    								Critter.worldTimeStep();
    							}
    						}
    						catch(Exception e) {
    							System.out.println("error processing: " + correctInput(command));
    						}
    						
    					}
    				}
    				
    				//seed
    				else if(command[0].equals("seed")) {
    					if(command.length == 2) {
    						try {
    							int value = Integer.valueOf(command[1]);
    							Critter.setSeed(value);
    						}
    						catch(Exception e) {
    							System.out.println("error processing: " + correctInput(command));
    						}
    					} else {
    						System.out.println("error processing: " + correctInput(command));
    					}
    				}
    				
    				//create
    				else if(command[0].equals("create")) {
    					if(command.length == 2 || command.length == 3) {
    						try {
    							String n = command[1];
    							int num = 1;
    							if(command.length > 2)
    								num = Integer.valueOf(command[2]);
    							for(int j = 0; j < num; j++)
    								Critter.createCritter(n);
    						}
    						catch(Exception e) {
    							System.out.println("error processing: " + correctInput(command));
    						}
    					} else {
    						System.out.println("error processing: " + correctInput(command));
    					}
    				}
    				
    				//stats
    				else if(command[0].equals("stats")) {
    					if(command.length == 2) {
    						try {
    							String n = command[1];
    							if(n.equals("Critter"))
    								throw new InvalidCritterException(n);
    							
    							String copy = myPackage + "." + n;
    							Class critterClass = Class.forName(copy);
    							Object critterObject = critterClass.newInstance();
    							
    							Method critterMethod = critterClass.getMethod("runStats", List.class);
    							
    							List<Critter> critts = Critter.getInstances(n);
    							critterMethod.invoke(critterObject, critts);
    						}
    						catch(NoSuchMethodException e) {
    							try {
    								Critter.runStats(Critter.getInstances(command[1]));
    							}
    							catch(InvalidCritterException y) {
    								System.out.println("error processing: " + correctInput(command));
    							}
    						}
    						catch(Exception e) {
    							System.out.println("error processing: " + correctInput(command));
    						}
    					} else { 
    						System.out.println("error processing: " + correctInput(command));
    					}
    				}
    				
    				//clear
    				else if(command[0].equals("clear")) {
    					if(command.length == 1)
    						Critter.clearWorld();
    					else {
    						System.out.println("error processing: " + correctInput(command));
    					}
    				}
    				
    				//otherwise
    				else {
    					System.out.println("invalid command: " + correctInput(command));
    				}
    			}
    		}
    	}
    }
    
    
    /**
     * ADDED!!
     * correctInput
     * @param input String of the command input
     * @return String to be outputted to the console
     */
    private static String correctInput(String[] input) {
    	String in = "";
    	for(int j = 0; j < input.length - 1; j++) {
    		in = in + input[j] + " ";
    	}
    	in = in + input[input.length - 1];
    	return in;
    }
}

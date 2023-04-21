
package com.nischal.assignment1v1;
import java.util.Random;

/**
 * 
 * @author nischalniroula
 * 
 *This abstract class represents the event in the simulation.
 * 
*/

public abstract class Event {
    
    //Variables for time and static random generator to generate random numbers for simulation
    private int time;
    private static Random generator = new Random(1);
    
    
    /**
     * 
     * Constructs an event with the given time.
     *
     * @param time: the time of the event
     * 
     */
    public Event (int time){
        this.time=time;
    } 
    
    
    /**
     * 
     * Getter method for time
     *
     * @return time: the time of the event
     * 
     */
    public int getTime(){
        return time;
    }
    
    /**
     * 
     * Getter method to get generated random numbers
     *
     * @return generator: the random number generator used by events
     * 
     */
    public static Random getGenerator() {
    return generator;
    }
    
    /**
     * 
     * Processes this event in the given shop model and scheduler.
     *
     * @param sm: the shop model to process events
     * @param s:  the scheduler to schedule new events
     * 
     */
    
    public abstract void process( ShopModel sm, IScheduler s );
}

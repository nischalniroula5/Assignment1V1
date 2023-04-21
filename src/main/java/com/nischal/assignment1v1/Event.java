
package com.nischal.assignment1v1;

/**
 * 
 * @author nischalniroula
 * 
 *This abstract class represents the event in the simulation.
 * 
*/

public abstract class Event {
    
    //Variables for time 
    private int time;
    
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
     * Processes this event in the given shop model and scheduler.
     *
     * @param sm: the shop model to process events
     * @param s:  the scheduler to schedule new events
     * 
     */
    public abstract void process( ShopModel sm, IScheduler s );
}

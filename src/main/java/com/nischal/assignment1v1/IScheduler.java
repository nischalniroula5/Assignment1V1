
package com.nischal.assignment1v1;
/**
 * 
 * @author nischalniroula
 * 
 *This interface defines scheduler that schedules next event in a simulation
 * 
*/

public interface IScheduler {
    /**
     * 
     * Schedules an event in the simulation.
     * 
     * @param e: the event to be scheduled
     * 
     */
    public void schedule( Event e );
}
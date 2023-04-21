
package com.nischal.assignment1v1;
import java.util.ArrayList;
/**
 *
 * @author nischalniroula
 * 
 * This class is responsible for running the simulation
 * It implements the `IScheduler` interface to schedule events.
 * 
 */
public class Simulator implements IScheduler {
    
    // The list of events to be scheduled
    private ArrayList<Event> events; 
    
    // The current time of the simulation
    private int clock;
    
    // The `ShopModel` object representing the shop being simulated
    private ShopModel model;
    
    /**
     * 
     * The constructor for the `Simulator` class.
     * @param model: The `ShopModel` object representing the shop being simulated.
     * 
     */
    public Simulator(ShopModel model) {
        this.model = model;
    }
    
    /**
     * 
     * Initializes the `Simulator` object with the list of events to be scheduled.
     * @param events: The list of events to be scheduled.
     * 
     */
    public void initialize(ArrayList<Event> events) {
        this.events = events;
    }

    /**
     * Runs the simulation until the given stop time is reached.
     * 
     * @param stopTime: The time at which the simulation should stop.
     * 
     */
    public void run(int stopTime) {     
        if ((events == null)|| events.isEmpty() )
           return;
        
        Event e = events.remove(0);
        clock = e.getTime();
        // events queue will never become empty as after the first event is 
        // added, every arrival event will generate a new arrival event 
        // (which may be greater than the stop time)
        while (clock <= stopTime) {
            e.process(model, this);// the this argument means that we are   
                                        // passing a reference to this simulator 
                                        // object to the event’s process method.
            e = events.remove(0);
            clock = e.getTime();
        }
    }

    /**
     * 
     * Adds the given event to the list of events to be scheduled in the correct order.
     * 
     * @param e: The event to be scheduled.
     */
    
    @Override
    public void schedule(Event e) {
        int i=0;
        for (;i<events.size();i++){
            if(e.getTime()<events.get(i).getTime()){
                break;
            }
        }
        events.add(i,e);
    }

       
}

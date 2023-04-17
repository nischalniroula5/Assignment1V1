
package com.nischal.assignment1v1;
import java.util.ArrayList;
/**
 *
 * @author nischalniroula
 */
public class Simulator implements IScheduler {
    private ArrayList<Event> events; 
    private int clock;
    private ShopModel model;
    
    //The Constructor
    public Simulator(ShopModel model) {
        this.model = model;
    }
    
    //The initialize() Method
    public void initialize(ArrayList<Event> events) {
        this.events = events;
    }

    //The run method copied from the assignment specification
    public void run(int stopTime) {     
        if ((events == null)|| events.isEmpty() )
        {
           return;
        }
        
        Event e = events.remove(0);
        clock = e.getTime();
        
        
        // events queue will never become empty as after the first event is 
        // added, every arrival event will generate a new arrival event 
        // (which may be greater than the stop time)
        while (clock <= stopTime) {
            e.process(model, this);
        // the this argument means that we are   
        // passing a reference to this simulator 
        // object to the event’s process method.
            e = events.remove(0);
            clock = e.getTime();
        }
    }

    
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

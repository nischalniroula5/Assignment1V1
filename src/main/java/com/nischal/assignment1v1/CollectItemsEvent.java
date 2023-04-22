
package com.nischal.assignment1v1;

/**
 * 
 * @author nischalniroula
 * 
 * This class is a subclass of Event Class and represents CollectItemsEvent event
 * This class represents an event where a customer group collects items.
 * 
*/
public class CollectItemsEvent extends Event {
    private CustomerGroup group;

    /**
     * 
     * Constructs a new CollectItemsEvent object with the specified time and customer group.
     * 
     * @param time: The time at which the event occurs.
     * @param group: The customer group that is collecting items.
     * 
     */
     
    public CollectItemsEvent(int time, CustomerGroup group) {
        super(time);
        this.group=group;
    }
    
    /**
     * 
     * Executes the process of the collect items event, which involves collecting items
     * Schedules the next event i.e PayEvent
     * 
     * @param sm: ShopModel to process the ArrivalEvent
     * @param s: IScheduler to schedule new events
     * 
     */
    
    @Override
    public void process(ShopModel sm, IScheduler s) {
        // Collects items for the customer group at the current time
        sm.collectItems(getTime(), group);
        
        // Schedule the PayEvent for the same customer group which is after 4 time units
        PayEvent nextPayEvent = new PayEvent(getTime() + 4, group);
        s.schedule(nextPayEvent);
    }
}

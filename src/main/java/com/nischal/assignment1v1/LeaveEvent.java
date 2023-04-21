package com.nischal.assignment1v1;
/**
 * 
 * @author nischalniroula
 * 
 * This class is a subclass of Event Class and represents LeaveEvent event
 * This class represents an event where a customer group leaves the shop.
 * 
*/
public class LeaveEvent extends Event {
    private CustomerGroup group;
    
    /**
     * 
     * Constructs a new LeaveEvent with the specified time and CustomerGroup.
     * 
     * @param time: The time at which the LeaveEvent occurs.
     * @param group: The CustomerGroup associated with the LeaveEvent.
     * 
     */
    
    public LeaveEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
    /**
     * 
     * Processes the LeaveEvent by removing the associated CustomerGroup from the shop and updating the statistics.
     * 
     * @param sm: The ShopModel instance used to simulate the shop.
     * @param s: The IScheduler instance used to schedule events.
     * 
     */
    
    @Override
    public void process(ShopModel sm, IScheduler s) {
        
        //Call ShopModel's leave method
        sm.leave(getTime(), group);
    }
}
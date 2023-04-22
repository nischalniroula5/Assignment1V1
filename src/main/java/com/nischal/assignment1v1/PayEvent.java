package com.nischal.assignment1v1;

/**
 * 
 * @author nischalniroula
 * 
 * This class is a subclass of Event Class and represents PayEvent event
 * This class represents an event where a customer pays for collected items.
 * 
*/

public class PayEvent extends Event {
    private CustomerGroup group;
    
    /**
     * 
     * Constructor for PayEvent class.
     *
     * @param time: the time at which the event occurs
     * @param group: the customer group paying for their items
     * 
     */

    public PayEvent(int time, CustomerGroup group) {
        super(time);
        this.group=group;
    }
    
    /**
     * 
     * The process method for the PayEvent class, which simulates the event of customers paying for their items.
     *
     * @param sm: The ShopModel instance used to simulate the shop.
     * @param s: The IScheduler instance used to schedule events.
     * 
     */
    @Override
    public void process(ShopModel sm, IScheduler s) {
        
        // Call the ShopModel's pay method
        sm.pay(getTime(), group);
        
        // Schedule a LeaveEvent after one time unit
        LeaveEvent nextLeaveEvent = new LeaveEvent(getTime() + 1, group);
        s.schedule(nextLeaveEvent);
    }
}

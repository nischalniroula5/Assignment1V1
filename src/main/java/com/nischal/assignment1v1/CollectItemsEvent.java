
package com.nischal.assignment1v1;

/**
 *
 * @author nischalniroula
 */
public class CollectItemsEvent extends Event {
    private CustomerGroup group;

    public CollectItemsEvent(int time, CustomerGroup group) {
        super(time);
        this.group=group;
    }
    
    
    @Override
    public void process(ShopModel sm, IScheduler s) {
        sm.collectItems(getTime(), group);
    }
}

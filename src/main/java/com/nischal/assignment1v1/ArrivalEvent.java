
package com.nischal.assignment1v1;

//NOT COMPLETED YET

public class ArrivalEvent extends Event{
    
    public ArrivalEvent(int time) {
        super(time);
    }

    
    //Process Method 
   @Override
    public void process(ShopModel sm, IScheduler s) {
        //Initiating group size as 2 as per stated in the question
        int groupSize = 2;
        int groupId = sm.getNextId();
        CustomerGroup group = new CustomerGroup(groupId, groupSize, getTime());
        sm.logGroup(group);
        sm.addGroup(group);
        sm.showGroups();
        System.out.println(group.toString());
        s.schedule(new ArrivalEvent(getTime() + 2));
    }
}

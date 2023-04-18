
package com.nischal.assignment1v1;

public class ArrivalEvent extends Event{
    
    public ArrivalEvent(int time) {
        super(time);
    }

    
    //Process Method 
   @Override
    public void process(ShopModel sm, IScheduler s) {
        //Initiating group size as 2 as per stated in assignment specification
        int groupSize = 2;
        int groupId = sm.getNextId();
        CustomerGroup group = new CustomerGroup(groupId, groupSize, getTime());
        
        if(sm.canEnter(group.getArrivalTime(), group)){
             System.out.println("t = " + group.getArrivalTime() + " : Group " + group.getID() + " (" + group.getNumberInGroup() + ") enter the shop");
             sm.logGroup(group);
             sm.addGroup(group);
             CollectItemsEvent collectItemsEvent = new CollectItemsEvent(getTime()+6, group);
             s.schedule(collectItemsEvent);
             ArrivalEvent nextArrival = new ArrivalEvent(getTime());
            s.schedule(nextArrival);
        
        }
        else{
             System.out.println("t = " + group.getArrivalTime() + " : Group " + group.getID() + " leaves as there is insufficient room for the group");
            sm.addLostBusiness(group.getNumberInGroup());
            ArrivalEvent nextArrival = new ArrivalEvent(getTime());
            s.schedule(nextArrival);
        
        }
            
       
    }
}

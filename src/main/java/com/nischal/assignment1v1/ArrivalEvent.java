
package com.nischal.assignment1v1;

public class ArrivalEvent extends Event{
    private int groupLowerBound=1;
    private int groupGeneratorBound=3;
    private int collectTimeLowerBound =3;
    private int collectTimeGeneratorBound =8;
    
    public ArrivalEvent(int time) {
        super(time);
    }

    
    //Process Method 
   @Override
    public void process(ShopModel sm, IScheduler s) {
        
        int groupSize = getGenerator().nextInt(groupGeneratorBound) + groupLowerBound; 
        int groupId = sm.getNextId();
        CustomerGroup group = new CustomerGroup(groupId, groupSize, getTime());
        sm.logGroup(group);
        System.out.println(String.format("t = %d: Group %d <%d people> arrived", group.getArrivalTime(), group.getID(), group.getNumberInGroup()));
        
        if(sm.canEnter(group.getArrivalTime(), group)){
             System.out.println(String.format("t = %d: Group %d <%d people> entered", group.getArrivalTime(), group.getID(), group.getNumberInGroup()));
             sm.addGroup(group);
             
             CollectItemsEvent collectItemsEvent = new CollectItemsEvent(group.getArrivalTime()+getGenerator().nextInt(collectTimeGeneratorBound) + collectTimeLowerBound, group);
             s.schedule(collectItemsEvent);
             
        
        }
        else{
             System.out.println(String.format("t = %d : Group %d leaves as there is insufficient room for the group", group.getArrivalTime(), group.getID()));
            sm.addLostBusiness(group.getNumberInGroup());

        }
        ArrivalEvent nextArrival = new ArrivalEvent(getTime()+2);
         s.schedule(nextArrival);
            
       
    }
}

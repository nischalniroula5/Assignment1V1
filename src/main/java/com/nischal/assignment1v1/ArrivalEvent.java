package com.nischal.assignment1v1;

/**
 * 
 * @author nischalniroula
 * 
 *This class represents an ArrivalEvent which is a subclass of Event.
 *An ArrivalEvent occurs when a new group of customers arrive at the shop.
 *It generates a new group and checks if the group can enter the shop based on the number of customers in group and spaces available.
 *If available space is enough for group members, it adds the group to the shop and schedules a new CollectItemsEvent.
 *Otherwise, it logs the group and prints a message indicating that the group cannot enter the shop.
 * 
*/

public class ArrivalEvent extends Event{
    
    //Constants for generating the size of group and time for event of collecting items
    private int groupLowerBound=1;
    private int groupGeneratorBound=3;
    private int collectTimeLowerBound =3;
    private int collectTimeGeneratorBound =8;
    
    /**
     * 
     * Constructor for ArrivalEvent
     * 
     * @param time : The time when ArrivalEvent Occurs 
     * 
     */
    public ArrivalEvent(int time) {
        super(time);
    }

    
    /**
     * 
     * This method processes the ArrivalEvent.
     * It generates a new group and checks if the group can enter the shop. 
     * If the group can enter, it adds the group to the shop and schedules a new CollectItemsEvent.
     * If the group cannot enter, it logs the group and prints a message indicating that the group cannot enter the shop.
     * 
     * @param sm: ShopModel to process the ArrivalEvent
     * @param s: IScheduler to schedule new events
     * 
     */
   @Override
    public void process(ShopModel sm, IScheduler s) {
        
        //Generate a new group
        int groupSize = getGenerator().nextInt(groupGeneratorBound) + groupLowerBound; 
        int groupId = sm.getNextId();
        CustomerGroup group = new CustomerGroup(groupId, groupSize, getTime());
        
        //Log the group and print the arrival message
        sm.logGroup(group);
        System.out.println(String.format("t = %d: Group %d <%d people> arrived", group.getArrivalTime(), group.getID(), group.getNumberInGroup()));
        
        //Check if group can enter the shop
        if(sm.canEnter(group.getArrivalTime(), group)){
            //If the group can enter the shop, add it to the shop and schedule a CollectItemsEvent
             System.out.println(String.format("t = %d: Group %d <%d people> entered", group.getArrivalTime(), group.getID(), group.getNumberInGroup()));
             sm.addGroup(group);
             
             CollectItemsEvent collectItemsEvent = new CollectItemsEvent(group.getArrivalTime()+getGenerator().nextInt(collectTimeGeneratorBound) + collectTimeLowerBound, group);
             s.schedule(collectItemsEvent);
             
        
        }
        else{
            //If the group cannot enter the shop, print the appropriate message
             System.out.println(String.format("t = %d: Group %d leaves as there is insufficient room for the group", group.getArrivalTime(), group.getID()));
            
        }
        
        //Schedules the ArrivalEvent for next arrival time
        ArrivalEvent nextArrival = new ArrivalEvent(getTime()+2);
         s.schedule(nextArrival);
            
       
    }
}

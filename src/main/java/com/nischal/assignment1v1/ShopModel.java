
package com.nischal.assignment1v1;

import java.util.ArrayList;

public class ShopModel {
    //Initializing instances 
    private int nextIdentifier = 0;
    private int numGroups = 0;
    
    //Initializing arraylist fpr groups and history
    private ArrayList<CustomerGroup> groups = new ArrayList<>();
    private ArrayList<CustomerGroup> history = new ArrayList<>();
    
    //Assigning and incrementing theidentifier
    public int getNextId() {
        return nextIdentifier++;
    }
    
    //Creating collectItems method 
    public void collectItems(int time,  CustomerGroup g){
        System.out.println(String.format("t = %d: Purchases collected by Group %d", time, g.getID()));
    }
    
    //Methods for addGroup and logGroup
    public void addGroup(CustomerGroup g) {
        groups.add(g);
        numGroups++;
    }
    public void logGroup(CustomerGroup g) {
        history.add(g);
    }

    //Getter for groups in shop
    public int getNumGroups() {
        return numGroups;
    }
    
    //Instantiated Pay Method
    public void pay(int time, CustomerGroup group) {
    System.out.println("t = " + time + ": Group " + group.getID() + " customer has paid");
}
    
    //Instantiated Leave Method
    public void leave(int time, CustomerGroup group) {
    System.out.println("t = " + time + ": Group " + group.getID() + " leaves the shop");
    groups.remove(group);
    numGroups--;
}

    //ShowGroups method to show Simulation Trace
    public void showGroups() {
    for (CustomerGroup group : groups) {
        String output = String.format("Group %d (%d people) arrived at t = %d",
                                      group.getID(), group.getNumberInGroup(), group.getArrivalTime());
        System.out.println(output);
    }
}
    
    //ShowLog method to show 
    public void showLog(){
        for (CustomerGroup group : history) {
         String output = String.format("Group %d (%d people) arrived at t = %d",
                                      group.getID(), group.getNumberInGroup(), group.getArrivalTime());
        System.out.println(output);
    }
    }
   
}


package com.nischal.assignment1v1;

import java.util.ArrayList;

public class ShopModel {
    //Initializing instances 
    private int nextId = 0;
    private int numGroups = 0;
    private int max;
    private int spaceAvailable;
    private int lostCustomers = 0;
    private int numServed =0;
    private int lostBusiness = 0;

    //Initializing arraylist fpr groups and history
    private ArrayList<CustomerGroup> groups = new ArrayList<>();
    private ArrayList<CustomerGroup> history = new ArrayList<>();
    
    //Constructor for shopmodel
    public ShopModel(int max) {
        this.max=max;
        this.spaceAvailable = max;
    }
    
    public int getSpaceAvailable(){
        return spaceAvailable;
    }
    
    
    
    //Assigning and incrementing theidentifier
    public int getNextId() {
        return nextId++;
    }
     
    //Creating collectItems method 
    public void collectItems(int time,  CustomerGroup g){
        System.out.println(String.format("t = %d: Purchases collected by Group %d", time, g.getID()));
    }
    
    //Methods for addGroup and logGroup
    public void addGroup(CustomerGroup g) {
            groups.add(g);
            numGroups++;
            spaceAvailable -= g.getNumberInGroup();
    }
    public void logGroup(CustomerGroup g) {
        history.add(g);
    }

    public void addLostCustomers(int numCustomers){
        lostCustomers +=numCustomers;
    }
    //Getter for groups in shop
    public int getNumGroups() {
        return numGroups;
    }
    
    public int getNumServed(){
        return numServed;
    }
    
    public int getLostBusiness(){
        return lostBusiness;
    }
    
    
    public boolean canEnter(int time, CustomerGroup group){
        return group.getNumberInGroup() <= spaceAvailable;
    }
    
    //Instantiated Pay Method
    public void pay(int time, CustomerGroup group) {
    System.out.println("t = " + time + ": Group " + group.getID() + " customer has paid");
    numServed += group.getNumberInGroup();
}
    
    //Instantiated Leave Method
    public void leave(int time, CustomerGroup group) {
    System.out.println("t = " + time + ": Group " + group.getID() + " leaves the shop");
    groups.remove(group);
    numGroups--;
    spaceAvailable += group.getNumberInGroup();
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

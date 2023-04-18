
package com.nischal.assignment1v1;
import java.util.Formatter;
import java.util.ArrayList;

public class ShopModel {
    //Initializing instances 
    private int nextId = 0;
    private int numGroups = 0;
    private int spaceAvailable;
    private int lostBusiness=0;
    private int numServed=0 ;

    //Initializing arraylist fpr groups and history
    private ArrayList<CustomerGroup> groups = new ArrayList<>();
    private ArrayList<CustomerGroup> history = new ArrayList<>();
    
    //Constructor for shopmodel
    public ShopModel(int max) {
        this.spaceAvailable=max;
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
    
    protected void addLostBusiness(int numCustomers){
        lostBusiness +=numCustomers;
    }

    public int getLostBusiness(){
        return lostBusiness;
    }
    //Getter for groups in shop
    public int getNumGroups() {
        return numGroups;
    }
    
    public int getNumServed(){
        return numServed;
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

    //ShowGroups method to show 
    public void showGroups(Formatter formatter) {
        formatter.format("\nThe following groups are in the shop:%n");
        formatter.format("==============================%n");
        for (CustomerGroup group : groups) {
        formatter.format("Group %d (%d people) arrived at t = %d%n", group.getID(), group.getNumberInGroup(), group.getArrivalTime());
    }
}
    
    //ShowLog method to show 
    public void showLog(Formatter formatter){
        formatter.format("\nThe following groups are in the history/log:%n");
        formatter.format("============================================%n");
        for (CustomerGroup group : history) {
         formatter.format("Group %d (%d people) arrived at t = %d%n", group.getID(), group.getNumberInGroup(), group.getArrivalTime());
    }
    }
   
}

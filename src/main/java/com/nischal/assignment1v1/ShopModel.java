
package com.nischal.assignment1v1;
import java.util.Formatter;
import java.util.ArrayList;

/**
 * 
 * @author nischalniroula
 * 
 * This class represents the model of the shop where customers arrive, 
 * make purchases, and leave the shop. It keeps track of the groups currently 
 * in the shop, as well as the groups that have left.
 * 
 * It also keeps track of the maximum space available in the shop, the number 
 * of groups that have been served, and the number of groups that have been 
 * turned away due to lack of space.
 * 
 */

public class ShopModel {
    
    //Initializes arraylist fpr groups and history
    private ArrayList<CustomerGroup> groups = new ArrayList<>();
    private ArrayList<CustomerGroup> history = new ArrayList<>();
    
    //Initializes instances variables to store various statistics
    private int nextId = 0;
    private int numGroups = 0;
    private int spaceAvailable;
    private int lostBusiness=0;
    private int numServed=0 ;

    /**
     * 
     * Constructs a new ShopModel object with the given maximum space available
     *
     * @param max: the maximum space available for customer groups
     * 
     */
    public ShopModel(int max) {
        this.spaceAvailable=max;
    }
    
    /**
     * Adds the given customer group to the shop.
     * Increases number of groups and decreases spaces available accordingly
     *
     * @param g: the customer group to add to the shop
     */
    public void addGroup(CustomerGroup g) {
        
        //Adds the group to "groups" arraylist
        groups.add(g);
        
        //Increases number of groups in the shop
        numGroups++;
        
        //Decreases the space available in respect to the group size
        spaceAvailable -= g.getNumberInGroup();
    }
    
    /**
     * 
     * Logs the given customer group as having left the shop.
     *
     * @param g: the customer group to log
     * 
     */
    public void logGroup(CustomerGroup g) {
        history.add(g);
    }
    
    /**
     * Getter for next available identifier for a customer group
     *
     * @return the next available identifier for a customer group
     */
    
    public int getNextId() {
        return nextId++;
    }
     
    /**
     * 
     * Shows the current groups in the shop
     *
     * @param formatter: the formatter to use for displaying the groups
     * 
     */
    
    public void showGroups(Formatter formatter) {
        formatter.format("\nThe following groups are in the shop:%n");
        formatter.format("==============================%n");
        
        // Loop through each group in the "groups" ArrayList and display their information
        for (CustomerGroup group : groups) {
            formatter.format("Group %d (%d people) arrived at t = %d%n", group.getID(), group.getNumberInGroup(), group.getArrivalTime());
        }
    }
    
    /**
     * 
     * Shows the groups in the log/history
     *
     * @param formatter: the formatter to use for displaying the groups
     * 
     */
    public void showLog(Formatter formatter){
        formatter.format("\nThe following groups are in the history/log:%n");
        formatter.format("============================================%n");
        
        // Loop through each group in the "history" ArrayList and display their information
        for (CustomerGroup group : history) {
            formatter.format("Group %d (%d people) arrived at t = %d%n", group.getID(), group.getNumberInGroup(), group.getArrivalTime());
        }
    }
    
    /**
     * 
     * Checks whether the customer can enter the shop or not
     *
     * @param time: the time the customer group wants to enter the shop
     * @param group: the customer group to check
     * @return true if the customer group can enter the shop, false otherwise
     * 
     */
    public boolean canEnter(int time, CustomerGroup group){
        
      //Checks if the group size is less than the space available in the shop  
      if(group.getNumberInGroup() <= spaceAvailable) {
        return true;
      } 
      else {
        
        //Increases the number of lost business by the group size
        lostBusiness += group.getNumberInGroup();
        return false;
      }   
    }
    
    /**
     * 
     * Displays a message indicating that the given customer group has collected items for their purchases.
     *
     * @param time: the time the customer group took to collect items
     * @param g: the customer group that collected items
     * 
     */ 
    public void collectItems(int time,  CustomerGroup g){
        System.out.println(String.format("t = %d: Purchases collected by Group %d", time, g.getID()));
    }
    
    /**
     * 
     * Displays a message indicating that the given customer group has paid for their purchases.
     * 
     * Updates the number of served customers.
     * @param time: the current simulation time
     * @param group: the customer group that has paid
     * 
    */
    public void pay(int time, CustomerGroup group) {
    System.out.println(String.format("t = %d: Group %d customer has paid", time, group.getID()));
    
    //Increases the number of people served by the group size 
    numServed += group.getNumberInGroup();
    }
    
    /**
     * 
     * Displays a message indicating that the given customer group has left the store.
     * Removes the group from the list of active groups, updates the number of groups, 
     * and increases the available space in the store.
     * 
     * @param time: the current simulation time
     * @param group: the customer group that has left
     * 
    */
    public void leave(int time, CustomerGroup group) {
    System.out.println(String.format("t = %d: Group %d leaves", time, group.getID()));
    
    //Removes the group from "groups" arraylist
    groups.remove(group);
    
    //Decreases the number of groups in the shop
    numGroups--;
    
    //Increases the space available
    spaceAvailable += group.getNumberInGroup();
    }

    /**
     * 
     * Getter for the number of customer groups that have been served.
     * 
     * @return the number of served customer groups
     * 
    */
    public int getNumServed(){
        return numServed;
    }
    
     /**
     * 
     * Getter for the number of customer groups that left because of insufficient space or lost business.
     * 
     * @return the number of served customer groups
     * 
    */
    
    public int getLostBusiness(){
        return lostBusiness;
    }
}

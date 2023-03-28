
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
    
    
    //Methods for addGroup and logGroup
    public void addGroup(CustomerGroup group) {
        groups.add(group);
        numGroups++;
    }

    public void logGroup(CustomerGroup group) {
        history.add(group);
    }

    public void showGroups(){
        
    }
    
    public void showLog(){
        
    }
    
    //Getter for groups in shop
    public int getNumGroups() {
        return numGroups;
    }

}

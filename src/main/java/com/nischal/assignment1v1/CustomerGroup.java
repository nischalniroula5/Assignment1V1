package com.nischal.assignment1v1;

/**
 * 
 * @author nischalniroula
 * 
 *This class represents the group of customers.
 * 
*/

public class CustomerGroup {
    
    //Variables for customer group indicating id, size of group, and arrival time
    private int id;
    private int numberInGroup;
    private int arrivalTime;
    
    /**
     * 
     * Initializes a new instance of the CustomerGroup class.
     *
     * @param id: The ID of the group.
     * @param numberInGroup: The number of people in the group.
     * @param arrivalTime: The time at which the group arrives.
     * 
     */
    public CustomerGroup(int id, int numberInGroup, int arrivalTime ){
        this.id=id;
        this.numberInGroup = numberInGroup;
        this.arrivalTime = arrivalTime;
    }
    
    /**
     * 
     * Getter method for id
     *
     * @return id: The ID of the group.
     * 
     */
    public int getID(){
        return id;
    }
    
    /**
     * 
     * Getter method for numberInGroup
     *
     * @return numberInGroup: The size of the group.
     * 
     */
    public int getNumberInGroup (){
        return numberInGroup;
    }
    
    
    /**
     * 
     * Getter method for arrivalTime
     *
     * @return arrivalTime: The arrival time of the group.
     * 
     */
    public int getArrivalTime (){
        return arrivalTime;
    }
    
    /**
     * 
     * toString method to return message 
     *
     * @return A string representation of the customer group including id, time and size of the group.
     */
    @Override
    public String toString() {
        return String.format("t = %d: Group %d <%d people> arrived", getArrivalTime(), getID(), getNumberInGroup());
    }

}

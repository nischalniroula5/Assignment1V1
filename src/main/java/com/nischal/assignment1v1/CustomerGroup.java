
package com.nischal.assignment1v1;

public class CustomerGroup {
    private int id;
    private int numberInGroup;
    private int arrivalTime;
    
    
    public CustomerGroup(int id, int numberInGroup, int arrivalTime ){
        this.id=id;
        this.numberInGroup = numberInGroup;
        this.arrivalTime = arrivalTime;
    }
    
    
    //Initializing Getters 
    public int getID(int id){
        return id;
    }
    
    public int getNumberInGroup (int numberInGroup){
        return numberInGroup;
    }
    
    public int getArrivalTime (int arrivalTime){
        return arrivalTime;
    }
    
    
    @Override
    public String toString() {
        //have to add title and seperator
        return "Customer group " + id + " with " + numberInGroup + " people arrived at time " + arrivalTime;
    }

}

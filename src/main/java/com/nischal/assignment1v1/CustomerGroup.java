
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
    public int getID(){
        return id;
    }
    
    public int getNumberInGroup (){
        return numberInGroup;
    }
    
    public int getArrivalTime (){
        return arrivalTime;
    }
    
    
    @Override
    public String toString() {
        return "t = " +getArrivalTime()+ ": Group "+getID()+" <"+getNumberInGroup()+"people> arrived";
    }

}

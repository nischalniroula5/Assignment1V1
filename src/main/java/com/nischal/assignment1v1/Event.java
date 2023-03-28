
package com.nischal.assignment1v1;


public abstract class Event {
    
    private int time;
    
    
    //Created constructor
    public Event (int time){
        this.time=time;
    } 
    
    //Initializing Getter
    public int getTime(){
        return time;
    }
    
    public abstract void process( ShopModel sm, IScheduler s );
}

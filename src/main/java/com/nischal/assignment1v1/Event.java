
package com.nischal.assignment1v1;
import java.util.Random;


public abstract class Event {
    
    private int time;
    private static Random generator = new Random(1);
    
    public static Random getGenerator() {
    return generator;
}
    
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

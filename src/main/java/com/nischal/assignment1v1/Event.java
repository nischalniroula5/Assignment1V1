/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nischal.assignment1v1;


public abstract class Event {
    
    private int time;
    
    
    //Created constructor
    public Event (int time){
        this.time=time;
    } 
    
    //Creating new object
    ShopModel shopModel = new ShopModel();
    IScheduler scheduler = new IScheduler();
    
    
    
    //Initializing Event
    public void Event (int time){
        
    }
    
    
    //Initializing Getter
    public int getTime(int time){
        return time;
    }
}

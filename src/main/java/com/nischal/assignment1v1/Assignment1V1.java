
package com.nischal.assignment1v1;
import java.util.ArrayList;

public class Assignment1V1 {

    //The Main method
    public static void main(String[] args) {
        
        //The instance of ShopModel
        ShopModel model = new ShopModel();
        
        //The instance of the simulator and passing it a reference of new instance of ShopModel
        Simulator sim = new Simulator(model);
        
        //Creating a ArrayList of Events
        ArrayList<Event> eventQueue = new ArrayList<>();
        
        //creating and adding the ArrivalEvent to event queue 
       eventQueue.add(new ArrivalEvent(0));
       
       //Invoking the simulator initializing method and passing the ArrayList to the simulator
       sim.initialize(eventQueue);
       
       
       
       //Invoking the simulator's run method
       System.out.println("\nthe following groups are in the history/log:");
       System.out.println("===================================");
       int numOfTimeSteps = 20;
       sim.run(numOfTimeSteps);
       
       // Display simulation trace
       System.out.println("Simulation Trace:");
       System.out.println("==============");
       model.showGroups();
       
       // Display groups in shop
       System.out.println("\nthe following groups are in the shop:");
       System.out.println("==============================");
       model.showLog();
       
      
        
    }
}

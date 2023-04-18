
package com.nischal.assignment1v1;
import java.util.ArrayList;

public class Assignment1V1 {

    //private int max =8;
    //The Main method
    public static void main(String[] args) {
        
       //The instance of ShopModel and passing 8 as maximum number of parameters
       ShopModel model = new ShopModel(8);
        
       //The instance of the simulator and passing it a reference of new instance of ShopModel
       Simulator sim = new Simulator(model);
        
       //Creating a ArrayList of Events
       ArrayList<Event> eventQueue = new ArrayList<>();
        
        //creating and adding the ArrivalEvent to event queue 
       eventQueue.add(new ArrivalEvent(0));
       
       //Invoking the simulator initializing method and passing the ArrayList to the simulator
       sim.initialize(eventQueue);
       
       
       //Displaying number of 
       
       //Displaying the Simulation Trace
       System.out.println("\nSimulation Trace:");
       System.out.println("==============");
       int numOfTimeSteps = 20;
       sim.run(numOfTimeSteps);
       
       // Displaying the groups currently in the shop
       System.out.println("\nthe following groups are in the shop:");
       System.out.println("==============================");
       model.showGroups();
       
       // Display groups in shop
       System.out.println("\nthe following groups are in the history/log:");
       System.out.println("==============================");
       model.showLog();
       
       //Displaying number of Customer Served
        System.out.println("\n Number of Customers Served: " + model.getNumServed());
        
        //Displaying number of Lost Business
        System.out.println("\n Number of Lost Business: " + model.getLostBusiness());
    }
}

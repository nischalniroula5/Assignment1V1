
package com.nischal.assignment1v1;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.*;

public class Assignment1V1 {

    //The Main method
    public static void main(String[] args) throws IOException {
        
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
       
       
       //Displaying the Simulation Trace
       System.out.println("\nSimulation Trace:");
       System.out.println("==============");
       int numOfTimeSteps = 20;
       sim.run(numOfTimeSteps);
    
        
        try (Formatter formatter = new Formatter("statistics.txt")){
            // Write simulation statistics to the file
        formatter.format("Statistics%n==========%n");
        formatter.format("The number of people served = %d%n", model.getNumServed());
        formatter.format("The lost business = %d people%n%n", model.getLostBusiness());
        
        model.showGroups(formatter); // pass the formatter object to the showGroups method
        model.showLog(formatter); // pass the formatter object to the showLog method
        }
        catch(FileNotFoundException e){
            System.exit(1);
        }
        
    }
    

}
    
    

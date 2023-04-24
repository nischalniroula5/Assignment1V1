
package com.nischal.assignment1v1;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.*;

/**
 * 
 * @author nischalniroula
 * 
 *This class contains the main method that runs the simulation.
 * 
 * Implemented phase6
 * 
*/

public class Assignment1V1 {
    /**
     * 
     * The main method that initializes the simulation and runs it for a specified number of time steps.For the simulation, we choose 20 time steps as per assignment specifications.
     * For the simulation, we choose 8 as the maximum space available in a shop at a time.
     * 
     * @param args: Default array of command line arguments
     * @throws java.io.IOException
     * @throws IOException: If there is an error while writing to the output file.
     * 
 */

    public static void main(String[] args) throws IOException {
        
       // Create an instance of ShopModel with maximum capacity of 8 (as per assignment specification)
       ShopModel model = new ShopModel(8);
        
       // Create an instance of Simulator and pass a reference to the ShopModel instance
       Simulator sim = new Simulator(model);
        
       // Create an ArrayList to hold the events
       ArrayList<Event> eventQueue = new ArrayList<>();
        
       // Add the first ArrivalEvent to the event queue with time 0
       eventQueue.add(new ArrivalEvent(0));
       
       // Initialize the simulator with the event queue
       sim.initialize(eventQueue);
       
       
       // Display and run the simulation for 20 time steps (as per assignment specification)
       System.out.println("\nSimulation Trace:");
       System.out.println("==============");
       int numOfTimeSteps = 20;
       sim.run(numOfTimeSteps);
    
       // Write the simulation statistics to a file named "statistics.txt" 
       try (Formatter formatter = new Formatter("statistics.txt")){
       formatter.format("Statistics%n==========%n");
       formatter.format("The number of people served = %d%n", model.getNumServed());
       formatter.format("The lost business = %d people%n%n", model.getLostBusiness());
       
       // Pass the formatter object to the ShopModel's showGroups method to display the customer groups
       model.showGroups(formatter); 
       
       // Pass the formatter object to the ShopModel's showlog method to display the log/history
       model.showLog(formatter); 
        }
        catch(FileNotFoundException e){
            System.exit(1);
        }
        
    }
    

}
    
    

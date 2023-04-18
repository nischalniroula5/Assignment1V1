
package com.nischal.assignment1v1;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.*;

public class Assignment1V1 {

    int max =8;
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
       /*
       
       // Displaying the groups currently in the shop
       System.out.println("\nthe following groups are in the shop:");
       System.out.println("==============================");
       //model.showGroups();
       model.showGroups(new Formatter(System.out));
       
       // Display groups in shop
       System.out.println("\nthe following groups are in the history/log:");
       System.out.println("==============================");
       //model.showLog();
       model.showGroups(new Formatter(System.out));
       */
       
       /*
       //Displaying number of Customer Served
        System.out.println("\n Number of Customers Served: " + model.getNumServed());
        
        //Displaying number of Lost Business
        System.out.println("\n Number of Lost Business: " + model.getLostBusiness());
        */
       /*
        //Formatter
        try {
            Formatter statisticsFormatter = new Formatter("statistics.txt");
            statisticsFormatter.format("Number of Customers Served: %d%n", model.getNumServed());
            statisticsFormatter.format("Number of Lost Business: %d%n", model.getLostBusiness());
            statisticsFormatter.format("%nThe following groups are in the shop:%n");
            model.showGroups(statisticsFormatter);
            statisticsFormatter.format("%nThe following groups are in the history/log:%n");
            model.showLog(statisticsFormatter);
            statisticsFormatter.close();
            System.out.println("\nStatistics written to file: statistics.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Error writing statistics to file!");
        }
        */

        Formatter formatter = null;
        try{
        formatter = new Formatter(new File("statistics.txt"));
        // Write simulation statistics to the file
        formatter.format("Statistics%n==========%n");
        formatter.format("The number of people served = %d%n", model.getNumServed());
        formatter.format("The lost business = %d people%n%n", model.getLostBusiness());
        
        model.showGroups(formatter); // pass the formatter object to the showGroups method
        model.showLog(formatter); // pass the formatter object to the showLog method
        formatter.close();
        }
        catch (FileNotFoundException e) {
        System.out.println("Error! File not found");
        }
        
        
    }
    

}
    
    

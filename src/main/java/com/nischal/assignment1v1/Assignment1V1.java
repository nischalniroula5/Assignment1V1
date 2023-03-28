
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
        
        //creating and adding the ArrivalEvent to even queue 
       eventQueue.add(new ArrivalEvent(0));
       
       //Invoking the simulator initializing method and passing the ArrayList to the simulator
       sim.initialize(eventQueue);
       
       //Invokinh the simulator's run method
       int numOfTimeSteps = 20;
       sim.run(numOfTimeSteps);
       
       //Using the showGroups method ShopModel
       model.showGroups();
       
       //Using the showLog method from ShopModel
       model.showLog();
        
    }
}

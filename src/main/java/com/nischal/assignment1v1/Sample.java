/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nischal.assignment1v1;

/**
 *
 * @author nischalniroula
 */
public class Sample {
    
}

/*
import java.util.PriorityQueue;

public class ShopModel {
    private int currentTime;
    private PriorityQueue<Event> eventQueue;
    
    public ShopModel() {
        currentTime = 0;
        eventQueue = new PriorityQueue<>();
    }
    
    public void run() {
        while (!eventQueue.isEmpty()) {
            Event e = eventQueue.poll();
            currentTime = e.getTime();
            e.process(this);
        }
    }
    
    public void scheduleEvent(Event e) {
        eventQueue.add(e);
    }
    
    public void arrival(int time, CustomerGroup g) {
        System.out.println("t = " + time + ": Group " + g.getID() + " <" + g.getSize() + " people> arrived");
        scheduleEvent(new CollectItemsEvent(time + 6, g));
    }
    
    public void collectItems(int time, CustomerGroup g) {
        System.out.println("t = " + time + ": Purchases collected by Group " + g.getID());
    }
}

abstract class Event implements Comparable<Event> {
    private int time;
    
    public Event(int time) {
        this.time = time;
    }
    
    public int getTime() {
        return time;
    }
    
    public int compareTo(Event other) {
        return Integer.compare(time, other.time);
    }
    
    abstract void process(ShopModel model);
}

class ArrivalEvent extends Event {
    private CustomerGroup group;
    
    public ArrivalEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
    public void process(ShopModel model) {
        model.arrival(getTime(), group);
    }
}

class CollectItemsEvent extends Event {
    private CustomerGroup group;
    
    public CollectItemsEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
    public void process(ShopModel model) {
        model.collectItems(getTime(), group);
    }
}

class CustomerGroup {
    private static int count = 0;
    private int id;
    private int size;
    
    public CustomerGroup(int size) {
        count++;
        id = count;
        this.size = size;
    }
    
    public int getID() {
        return id;
    }
    
    public int getSize() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        ShopModel model = new ShopModel();
        model.scheduleEvent(new ArrivalEvent(0, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(2, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(4, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(6, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(8, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(10, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(12, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(14, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(16, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(18, new CustomerGroup(2)));
        model.scheduleEvent(new ArrivalEvent(20, new CustomerGroup(2)));
        model.run();
    }
}

*/

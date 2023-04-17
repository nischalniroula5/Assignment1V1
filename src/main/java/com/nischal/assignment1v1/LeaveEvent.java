/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nischal.assignment1v1;

/**
 *
 * @author nischalniroula
 */
public class LeaveEvent extends Event {
    private CustomerGroup group;
    
    public LeaveEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
    @Override
    public void process(ShopModel sm, IScheduler s) {
        sm.leave(getTime(), group);
    }
}
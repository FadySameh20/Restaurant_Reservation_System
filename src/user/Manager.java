/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;

/**
 *
 * @author AMR
 */
public class Manager extends User{
    //ArrayList<Customer> customer=new ArrayList<>();
    //ArrayList<Waiter> waiter=new ArrayList<>();
    //ArrayList<Cook> cook= new ArrayList<>();
    public Manager(String name, String role, String username, String password) {
        super(name, role, username, password);
    }
    public ArrayList<User> getStatistics(ArrayList <Customer> customer,ArrayList<Waiter> waiter,ArrayList<Cook> cook){
        ArrayList<User> arr;
        arr = new ArrayList<>();
        for(int i=0;i<customer.size();i++)
            arr.add(customer.get(i));
        for(int i=0;i<waiter.size();i++)
            arr.add(waiter.get(i));
        for(int i=0;i<cook.size();i++)
            arr.add(cook.get(i));
        return arr;
    }
}

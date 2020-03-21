/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import utensilis.Dish;
import utensilis.Table;

/**
 *
 * @author AMR
 */
public class Customer extends User {
    
    private Order order;
    private Table table;
    private double totalPrice;
    public Customer(String name, String role, String username, String password) {
        super(name, role, username, password);
        
    }
   
    @SuppressWarnings("empty-statement")
    public void setTotalPrice(){
        ArrayList<Dish> temp=order.getDish();;
        for (Dish dish : temp) {
            totalPrice += dish.getPrice();
        }
    }
    
    public double getTotalPrice(){
        return totalPrice;
    }
    public void reserveTable(Table table){
        this.table=table;
        table.setNumberOfSeats(table.getNumberOfSeats());
        table.setSmokingArea(table.isSmokingArea());
        table.setTableNumber(table.getTableNumber());
    }
    /*public int getNumberOfSeats()
    {
        return table.getNumberOfSeats();
    }
     public int getNumberOfTables()
    {
        return table.getTableNumber(); 
    }
      public boolean isSmoking()
    {
        return table.isSmokingArea();
    }*/
    public Table getTable()
    {
        return table;
    }
    public void makeOrder(Order order)
    {
        this.order=order;
    }
}

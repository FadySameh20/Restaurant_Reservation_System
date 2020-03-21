/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utensilis;

/**
 *
 * @author AMR
 */
public class Table {
    
    private int tableNumber;
    private int numberOfSeats;
    private boolean smokingArea;

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
        
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setSmokingArea(boolean smokingArea) {
        this.smokingArea = smokingArea;
    }
    
    public int getTableNumber(){
       return this.tableNumber; 
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public boolean isSmokingArea() {
        return this.smokingArea;
    } 
}

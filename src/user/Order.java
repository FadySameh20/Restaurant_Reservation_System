/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import utensilis.Dish;

/**
 *
 * @author AMR
 */
public class Order {
    private int index=0;
    private Dish dish[];
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Dish[] getDish() {
        return dish;
    }

    public void setDish(Dish d) {
        dish[index++]=d;
    }
    
}

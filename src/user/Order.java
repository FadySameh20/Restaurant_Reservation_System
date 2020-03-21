/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import utensilis.Dish;

/**
 *
 * @author AMR
 */
public class Order {
    private ArrayList<Dish> dish=new ArrayList<>();

    public ArrayList<Dish> getDish() {
        return dish;
    }

    public void setDish(Dish d) {
        dish.add(d);
    }
    
}

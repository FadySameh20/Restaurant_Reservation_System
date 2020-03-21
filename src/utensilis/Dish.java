/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utensilis;

import user.Food;

/**
 *
 * @author AMR
 * @param <X>
 */
public class Dish<X extends Food> {

    private String name;
    private  X type;
    private double price;
    private double tax;
    public Dish(String name,double price){
        this.name=name;
        this.price=price;
    }

    public X getType() {
        return type;
    }

    public final void setType(X type) {
        if (type.equals("appetizer")) {
            tax = 0.02;
        } else if (type.equals("main_course")) {
            tax = 0.015;
        } else {
            tax = 0.01;
        }
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price + price * tax;
        System.out.println(this.price);
    }
}

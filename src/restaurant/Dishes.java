package restaurant;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import utensils.Dish;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)

public class Dishes {

    @XmlElement(name = "dish")
    private ArrayList<Dish> dishes = new ArrayList<>();

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

}

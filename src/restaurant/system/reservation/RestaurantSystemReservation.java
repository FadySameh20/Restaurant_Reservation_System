/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.system.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import user.Appetizers;
import user.Cook;
import user.Customer;
import user.Dessert;
import user.Main_Course;
import user.Order;
import user.User;
import utensilis.Dish;
import utensilis.Table;

/**
 *
 * @author AMR
 */
public class RestaurantSystemReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tests
        /*Customer Steven=new Customer("Steven","customer","Steven123","567");
        Customer Amr=new Customer("Amr","customer","amr123","5637");
        ArrayList<Customer> arr=new ArrayList<>();
        arr.add(Steven);
        arr.add(Amr);
        Table tab=new Table();
        tab.setNumberOfSeats(15);
        tab.setSmokingArea(false);
        tab.setTableNumber(2);
        arr.get(0).reserveTable(tab);
        System.out.println(tab.getTableNumber());
        Table table=new Table();
        table.setNumberOfSeats(5);
        table.setSmokingArea(true);
        table.setTableNumber(3);
        Steven.reserveTable(table);
         Table table2=new Table();
         table2=table;
        System.out.println(table2.getNumberOfSeats());
        Dessert moltencake=new Dessert();
        Dish<Appetizers> Chicken=new Dish("name", moltencake, 5);
       System.out.println( Chicken.getType());
       Cook cooker=new Cook("ahmed","cook","cooker23","23423");
       cooker.setHashMap("Chicken", 9);
       cooker.setHashMap("Chickeasdfasn", 2);
       cooker.setHashMap("Chickens", 3);
       cooker.setHashMap("Burger", 92);
       HashMap<String, Integer> h = new HashMap<>();
       h=cooker.getHashMap();
       h.forEach((key,value)->System.out.println(key+ " "+ value));*/
       Dish <Main_Course> fillet=new Dish <>("Fillet",10);
       fillet.setType(new Main_Course());
       Dish <Dessert> moltencake=new Dish <>("moltecake",20);
       moltencake.setType(new Dessert());
       Order order=new Order();
       order.setDish(fillet);
       order.setDish(moltencake);
       Table table=new Table();
       table.setNumberOfSeats(5);
       table.setSmokingArea(true);
       table.setTableNumber(3);
       Customer Amr=new Customer("Amr","customer","amr123","5637");
       Amr.reserveTable(table);
       Amr.makeOrder(order);
       Amr.setTotalPrice();
       System.out.println(Amr.getTotalPrice());
       
    }
    
}

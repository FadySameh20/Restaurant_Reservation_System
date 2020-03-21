/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author AMR
 */
public class Cook extends User{

   //private ArrayList<String> meals = new ArrayList<>();
   //private ArrayList<Integer> tableNumber = new ArrayList<>();
    HashMap<String, Integer> h = new HashMap<>();
    int index=0;
    public Cook(String name, String role, String username, String password) {
        super(name, role, username, password);
    }
   void setHashMap (ArrayList <String> meals, ArrayList <Integer> tableNumber){
        for(int i = 0; i < meals.size(); i++){
            h.put(meals.get(i), tableNumber.get(i));
        }   
    }
   
    public HashMap<String, Integer> getHashMap(){
        return h;
    }
}

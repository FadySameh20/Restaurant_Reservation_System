/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.HashMap;
import utensilis.Table;

/**
 *
 * @author AMR
 */
public class Waiter extends User {
    
    //ArrayList<Customer> customers = new ArrayList<>();
    //ArrayList<Table> tableNumber = new ArrayList<>();
    HashMap<String, Integer> hm = new HashMap<>();
    
    public Waiter(String name, String role, String username, String password) {
        super(name, role, username, password);
    }
    
    void setHashMap (ArrayList <Customer> name,ArrayList <Table> tableNumber){
        for(int i = 0; i < name.size(); i++){
            hm.put(name.get(i).getName(), tableNumber.get(i).getTableNumber());
        }   
    } 
    void setHashMap (String name,int tableNumber){
            hm.put(name, tableNumber);
    }
    
    public HashMap<String, Integer> getHashMap(){
    return hm;
    }
}

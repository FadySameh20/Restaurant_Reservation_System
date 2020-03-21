/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

public abstract class User {
    String name;
    String role;
    String username;
    String password;

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    User(String name, String role, String username, String password){
        this.name = name;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
   
}

package restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {

    @XmlElement(name = "users")
    private Users users = null;

    @XmlElement(name = "dishes")
    private Dishes dishes = null;

    @XmlElement(name = "tables")
    private Tables tables = null;

    @XmlElement(name = "customers")
    private Customers customers = null;

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}

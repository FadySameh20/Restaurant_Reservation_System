package restaurant;

import users.Customer;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers {

    @XmlElement(name = "customer")
    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}

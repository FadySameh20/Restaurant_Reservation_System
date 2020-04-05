package users;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import utensils.Dish;
import utensils.Table;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)

public class Customer extends User {

    @XmlElement(name = "table")
    private Table table;

    @XmlElement(name = "dish")
    private ArrayList<Dish> dish = new ArrayList<Dish>();

    @XmlElement(name = "mode")
    private String mode;

    @XmlElement(name = "totalprice")
    private double totalPrice = 0;

    @XmlElement(name = "orderNum")
    private int orderNum;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ArrayList<Dish> getDish() {
        return dish;
    }

    public void setDish(Dish d) {
        dish.add(d);
        totalPrice += d.getReceipt();
    }
}

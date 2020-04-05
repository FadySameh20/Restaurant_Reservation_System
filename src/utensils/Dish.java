package utensils;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Dish {

    private String name;
    private String type;
    private int price;
    private double tax;
    private int quantity;
    private double receipt;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getPrice() {
        return price;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        switch (type) {
            case "appetizer":
                tax = 0.1;
                break;
            case "main_course":
                tax = 0.15;
                break;
            case "desert":
                tax = 0.2;
                break;
            default:
                System.out.println("Incorrect Food type");
                System.exit(-1);
                break;
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getReceipt() {
        return receipt;
    }

    @XmlElement
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.receipt = (this.price + this.price * tax) * quantity;
    }

}

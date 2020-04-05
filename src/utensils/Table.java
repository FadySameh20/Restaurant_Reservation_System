package utensils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

    @XmlElement(name = "number")
    private int tableNumber;

    @XmlElement(name = "number_of_seats")
    private int numberOfSeats;

    @XmlElement(name = "smoking")
    private boolean smokingArea;

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;

    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setSmokingArea(boolean smokingArea) {
        this.smokingArea = smokingArea;
    }

    public int getTableNumber() {
        return this.tableNumber;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public boolean isSmokingArea() {
        return this.smokingArea;
    }
}

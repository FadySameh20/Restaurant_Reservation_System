package restaurant;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import utensils.Table;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tables {

    @XmlElement(name = "table")
    private ArrayList<Table> tables = new ArrayList<>();

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

}

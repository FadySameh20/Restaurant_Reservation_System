package restaurant;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "user")
    private ArrayList<UserXML> users = new ArrayList<>();

    public ArrayList<UserXML> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserXML> users) {
        this.users = users;
    }

}

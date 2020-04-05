package users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class User {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "role")
    private String role;

    @XmlElement(name = "username")
    private String username;

    @XmlElement(name = "password")
    private String password;

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

    public void setAll(String name, String role, String username, String password) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.role = role;
    }
}

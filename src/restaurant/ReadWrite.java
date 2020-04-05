package restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import users.Customer;
import utensils.Dish;
import utensils.Table;

public class ReadWrite {

    private static ReadWrite instance;
    private ArrayList<UserXML> users = new ArrayList<>();
    private ArrayList<Dish> dishes = new ArrayList<>();
    private ArrayList<Table> tables = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Document doc1, doc2;

    private ReadWrite() {

    }

    public static ReadWrite getInstance() {
        if (instance == null) {
            return instance = new ReadWrite();
        } else {
            instance.getUsers().clear();
            instance.getCustomers().clear();
            instance.getDishes().clear();
            instance.getTables().clear();
            return instance;
        }
    }

    public ReadWrite readFromXmlFile() throws JAXBException, SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException {

        ReadWrite temp = ReadWrite.getInstance();
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File fp = new File("todayData.xml");
        FileReader fr = new FileReader(fp);
        if (fr.read() == -1) {
            JOptionPane.showMessageDialog(null, "File is empty !");
            System.exit(-1);
        }
        if (!fp.exists()) {
            JOptionPane.showMessageDialog(null, "File doesn't exist !");
            System.exit(-1);
        }
        Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(fp);
        restaurant.getUsers().getUsers().forEach((userXML) -> {
            temp.setUsers(userXML);
        });

        restaurant.getTables().getTables().forEach((table) -> {
            temp.setTables(table);
        });

        restaurant.getDishes().getDishes().forEach((dish) -> {
            temp.setDishes(dish);
        });
        String lastModified = String.valueOf(new java.sql.Date(fp.lastModified()));
        String currentTime = String.valueOf(new java.sql.Date(System.currentTimeMillis()));
        if (lastModified.equals(currentTime)) { //the file will reset at the begining of a new day (12 AM)
            try {
                int i = 1;
                for (Customer customer : restaurant.getCustomers().getCustomers()) {
                    temp.setCustomers(customer);
                    customer.setOrderNum(i);
                    i++;
                }
            } catch (NullPointerException e) {

            }
        } else {

            ArrayList<Customer> c = new ArrayList<>();
            try {
                int i = 1;
                for (Customer customer : restaurant.getCustomers().getCustomers()) {
                    c.add(customer);
                    customer.setOrderNum(i);
                    i++;
                }
            } catch (NullPointerException e) {

            }
            if (!c.isEmpty()) {
                try {
                    File xmlFile = new File("historyData.xml");
                    if (!xmlFile.exists()) {
                        JOptionPane.showMessageDialog(null, "File doesn't exist !");
                        System.exit(-1);
                    }
                    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    Element root;
                    int flag;
                    if (xmlFile.length() < 60) {  //due to the first line in the xml file
                        doc1 = documentBuilder.newDocument();
                        root = doc1.createElement("customers");
                        flag = 1;
                    } else {
                        doc1 = documentBuilder.parse(xmlFile);
                        root = doc1.getDocumentElement();
                        flag = 0;
                    }
                    Element date = doc1.createElement("Date");
                    Text datetElement = doc1.createTextNode(String.valueOf(new java.sql.Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)));
                    date.appendChild(datetElement);
                    root.appendChild(date);
                    customerDetails(root, c, 0);
                    if (flag == 1) {
                        doc1.appendChild(root);
                    }
                    fileFormatter(xmlFile, 0);
                } catch (SAXException | IOException | ParserConfigurationException ex) {
                    JOptionPane.showMessageDialog(null, "Error in System");
                    System.exit(-1);
                }
            }
        }
        return temp;
    }

    public void writeToXmlFile(ReadWrite temp) throws JAXBException, ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        doc2 = builder.newDocument();
        Element root = doc2.createElement("restaurant");
        Element usersElement = doc2.createElement("users");
        for (int i = 0; i < temp.getUsers().size(); i++) {
            Element user = doc2.createElement("user");
            Element name = doc2.createElement("name");
            Text nText = doc2.createTextNode(temp.getUsers().get(i).getName());
            name.appendChild(nText);
            Element role = doc2.createElement("role");
            Text rText = doc2.createTextNode(temp.getUsers().get(i).getRole());
            role.appendChild(rText);
            Element username = doc2.createElement("username");
            Text uText = doc2.createTextNode(temp.getUsers().get(i).getUsername());
            username.appendChild(uText);
            Element password = doc2.createElement("password");
            Text pText = doc2.createTextNode(temp.getUsers().get(i).getPassword());
            password.appendChild(pText);
            user.appendChild(name);
            user.appendChild(role);
            user.appendChild(username);
            user.appendChild(password);
            usersElement.appendChild(user);
        }
        root.appendChild(usersElement);
        temp.tables = temp.sortTable(temp.getTables());
        Element tablesElement = doc2.createElement("tables");
        for (int i = 0; i < temp.getTables().size(); i++) {
            Element table = doc2.createElement("table");
            Element tablenum = doc2.createElement("number");
            Text numText = doc2.createTextNode(String.valueOf(temp.getTables().get(i).getTableNumber()));
            tablenum.appendChild(numText);
            Element tableseats = doc2.createElement("number_of_seats");
            Text seatText = doc2.createTextNode(String.valueOf(temp.getTables().get(i).getNumberOfSeats()));
            tableseats.appendChild(seatText);
            Element smoking = doc2.createElement("smoking");
            Text smokeText = doc2.createTextNode(String.valueOf(temp.getTables().get(i).isSmokingArea()));
            smoking.appendChild(smokeText);
            table.appendChild(tablenum);
            table.appendChild(tableseats);
            table.appendChild(smoking);
            tablesElement.appendChild(table);
        }
        root.appendChild(tablesElement);
        Element dishesElement = doc2.createElement("dishes");
        for (int i = 0; i < temp.getDishes().size(); i++) {
            Element dishElement = doc2.createElement("dish");
            Element dishname = doc2.createElement("name");
            Text dishText = doc2.createTextNode(temp.getDishes().get(i).getName());
            dishname.appendChild(dishText);
            Element dishprice = doc2.createElement("price");
            Text dishpriceText = doc2.createTextNode(String.valueOf(temp.getDishes().get(i).getPrice()));
            dishprice.appendChild(dishpriceText);
            Element dishtype = doc2.createElement("type");
            Text dishtypeText = doc2.createTextNode(temp.getDishes().get(i).getType());
            dishtype.appendChild(dishtypeText);
            dishElement.appendChild(dishname);
            dishElement.appendChild(dishprice);
            dishElement.appendChild(dishtype);
            dishesElement.appendChild(dishElement);
        }
        root.appendChild(dishesElement);
        if (customers.size() > 0) {
            Element customersElement = doc2.createElement("customers");
            customerDetails(customersElement, temp.getCustomers(), 1);
            root.appendChild(customersElement);
        }

        doc2.appendChild(root);
        File fp = new File("todayData.xml");
        if (!fp.exists()) {
            JOptionPane.showMessageDialog(null, "File doesn't exist !");
            System.exit(-1);
        }
        fileFormatter(fp, 1);

    }

    private void customerDetails(Element root, ArrayList<Customer> c, int flag) {
        Document doc;
        if (flag == 0) {
            doc = doc1;
        } else {
            doc = doc2;
        }
        for (int i = 0; i < c.size(); i++) {
            Element customerElement = doc.createElement("customer");
            Element order = doc.createElement("order_number");
            Text orderText = doc.createTextNode(String.valueOf(c.get(i).getOrderNum()));
            order.appendChild(orderText);
            Element name = doc.createElement("name");
            Text nText = doc.createTextNode(c.get(i).getName());
            name.appendChild(nText);
            Element role = doc.createElement("role");
            Text rText = doc.createTextNode(c.get(i).getRole());
            role.appendChild(rText);
            Element username = doc.createElement("username");
            Text uText = doc.createTextNode(c.get(i).getUsername());
            username.appendChild(uText);
            Element password = doc.createElement("password");
            Text pText = doc.createTextNode(c.get(i).getPassword());
            password.appendChild(pText);
            customerElement.appendChild(order);
            customerElement.appendChild(name);
            customerElement.appendChild(role);
            customerElement.appendChild(username);
            customerElement.appendChild(password);

            Element table = doc.createElement("table");
            Element tablenum = doc.createElement("number");
            Text numText = doc.createTextNode(String.valueOf(c.get(i).getTable().getTableNumber()));
            tablenum.appendChild(numText);
            Element tableseats = doc.createElement("number_of_seats");
            Text seatText = doc.createTextNode(String.valueOf(c.get(i).getTable().getNumberOfSeats()));
            tableseats.appendChild(seatText);
            Element smoking = doc.createElement("smoking");
            Text smokeText = doc.createTextNode(String.valueOf(c.get(i).getTable().isSmokingArea()));
            smoking.appendChild(smokeText);
            table.appendChild(tablenum);
            table.appendChild(tableseats);
            table.appendChild(smoking);
            customerElement.appendChild(table);

            for (int j = 0; j < c.get(i).getDish().size(); j++) {
                Element dishElement = doc.createElement("dish");
                Element dishname = doc.createElement("name");
                Text dishText = doc.createTextNode(c.get(i).getDish().get(j).getName());
                dishname.appendChild(dishText);
                Element dishprice = doc.createElement("price");
                Text dishpriceText = doc.createTextNode(String.valueOf(c.get(i).getDish().get(j).getPrice()));
                dishprice.appendChild(dishpriceText);
                Element dishtype = doc.createElement("type");
                Text dishtypeText = doc.createTextNode(c.get(i).getDish().get(j).getType());
                dishtype.appendChild(dishtypeText);
                Element dishquantity = doc.createElement("quantity");
                Text quantity = doc.createTextNode(String.valueOf(c.get(i).getDish().get(j).getQuantity()));
                dishquantity.appendChild(quantity);
                dishElement.appendChild(dishname);
                dishElement.appendChild(dishprice);
                dishElement.appendChild(dishquantity);
                dishElement.appendChild(dishtype);
                customerElement.appendChild(dishElement);
            }
            if (flag == 1) {
                Element mode = doc.createElement("mode");
                Text mText = doc.createTextNode(c.get(i).getMode());
                mode.appendChild(mText);
                customerElement.appendChild(mode);
            }
            Element totalPrice = doc.createElement("totalprice");
            Text tText = doc.createTextNode(String.valueOf(c.get(i).getTotalPrice()));
            totalPrice.appendChild(tText);
            customerElement.appendChild(totalPrice);
            root.appendChild(customerElement);
        }

    }

    private void fileFormatter(File fp, int flag) throws TransformerConfigurationException, TransformerException {
        Document doc;
        if (flag == 0) {
            doc = doc1;
        } else {
            doc = doc2;
        }
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(fp);
        transformer.transform(source, result);
    }

    public ArrayList<UserXML> getUsers() {
        return users;
    }

    public void setUsers(UserXML user) {
        this.users.add(user);
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Dish dish) {
        this.dishes.add(dish);
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(Table table) {
        this.tables.add(table);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customer) {
        this.customers.add(customer);
    }

    public void setCustomers(ArrayList<Customer> customer) {
        this.customers = customer;
    }

    public ArrayList<Table> sortTable(ArrayList<Table> table) {
        Collections.sort(table, new Comparator<Table>() {
            @Override
            public int compare(Table a, Table b) {

                return a.getTableNumber() - b.getTableNumber();
            }
        });
        return table;
    }
}

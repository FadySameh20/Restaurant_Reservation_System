package gui;

import java.awt.Color;
import java.io.IOException;
import restaurant.ReadWrite;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import users.Customer;
import utensils.Dish;
import utensils.Table;

public class CustomerWindow extends javax.swing.JFrame {

    Customer customer;
    ArrayList<Table> tables;
    ReadWrite temp;
    private int dishPrice = 0;

    public CustomerWindow(Customer customer, ReadWrite temp) throws JAXBException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.customer = customer;
        this.temp = temp;
        this.tables = temp.sortTable(temp.getTables());
        jTextAreaMenu.setBackground(new Color(0, 0, 0, 0));
        jTextAreaReceipt.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jComboBoxTableNum.addItem("");
        jComboBoxDishName.addItem("");
        int flag = 0;
        for (int i = 0; i < temp.getCustomers().size(); i++) {
            if (temp.getCustomers().get(i).getName().equals(customer.getName()) && !temp.getCustomers().get(i).getMode().equals("delivered")) {
                btnReserveTable.setEnabled(false);
                btnAddItems.setEnabled(true);
                flag = 1;
                JOptionPane.showMessageDialog(null, "You already reserved a table. Please choose your meals!");
                customer.setTable(temp.getCustomers().get(i).getTable());
                break;
            }
        }
        if (flag == 0) {
            for (int i = 0; i < tables.size(); i++) {
                jComboBoxTableNum.addItem(String.valueOf(tables.get(i).getTableNumber()));
                jTextAreaMenu.append(" Table Number :");
                jTextAreaMenu.append(tables.get(i).getTableNumber() + "\n");
                jTextAreaMenu.append(" Table Seats :");
                jTextAreaMenu.append(tables.get(i).getNumberOfSeats() + "\n");
                jTextAreaMenu.append(" Smoking :");
                jTextAreaMenu.append(tables.get(i).isSmokingArea() + "\n");
                jTextAreaMenu.append("-------------------------------\n");
            }
        } else {
            setMenu();
        }
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("appetizer")) {
                jComboBoxDishName.addItem(temp.getDishes().get(i).getName());
            }
        }
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("main_course")) {
                jComboBoxDishName.addItem(temp.getDishes().get(i).getName());
            }
        }
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("desert")) {
                jComboBoxDishName.addItem(temp.getDishes().get(i).getName());
            }
        }
        ((DefaultEditor) jSpinnerDishQuantity.getEditor()).getTextField().setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxTableNum = new javax.swing.JComboBox<>();
        jLabelTableNum = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMenu = new javax.swing.JTextArea();
        jLabelDish = new javax.swing.JLabel();
        jComboBoxDishName = new javax.swing.JComboBox<>();
        jLabelQuantity = new javax.swing.JLabel();
        jSpinnerDishQuantity = new javax.swing.JSpinner();
        btnReserveTable = new javax.swing.JButton();
        btnAddItems = new javax.swing.JButton();
        btnGetPrice = new javax.swing.JButton();
        btnMakeOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaReceipt = new javax.swing.JTextArea();
        jBtnLogout = new javax.swing.JButton();
        jLabelDashBoard = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxTableNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jComboBoxTableNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 132, -1));

        jLabelTableNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTableNum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTableNum.setText("Table Number");
        getContentPane().add(jLabelTableNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jTextAreaMenu.setEditable(false);
        jTextAreaMenu.setColumns(20);
        jTextAreaMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextAreaMenu.setForeground(new java.awt.Color(255, 255, 0));
        jTextAreaMenu.setRows(5);
        jTextAreaMenu.setOpaque(false);
        jScrollPane2.setViewportView(jTextAreaMenu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 290, 250));

        jLabelDish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDish.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDish.setText("Dish");
        getContentPane().add(jLabelDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        jComboBoxDishName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jComboBoxDishName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 150, -1));

        jLabelQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jLabelQuantity.setText("Quantity");
        getContentPane().add(jLabelQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 20));

        jSpinnerDishQuantity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jSpinnerDishQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        getContentPane().add(jSpinnerDishQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        btnReserveTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReserveTable.setText("Reserve Table");
        btnReserveTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveTableActionPerformed(evt);
            }
        });
        getContentPane().add(btnReserveTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 222, 97));

        btnAddItems.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddItems.setText("Add Item");
        btnAddItems.setEnabled(false);
        btnAddItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemsActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 160, 79));

        btnGetPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGetPrice.setText("Get Price");
        btnGetPrice.setEnabled(false);
        btnGetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetPriceActionPerformed(evt);
            }
        });
        getContentPane().add(btnGetPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 222, 91));

        btnMakeOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMakeOrder.setText("Make Order");
        btnMakeOrder.setEnabled(false);
        btnMakeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnMakeOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 222, 97));

        jTextAreaReceipt.setEditable(false);
        jTextAreaReceipt.setColumns(20);
        jTextAreaReceipt.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jTextAreaReceipt.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaReceipt.setRows(5);
        jTextAreaReceipt.setOpaque(false);
        jScrollPane1.setViewportView(jTextAreaReceipt);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 311, 205));

        jBtnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnLogout.setText("Logout");
        jBtnLogout.setEnabled(false);
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 530, 222, 97));

        jLabelDashBoard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDashBoard.setText("Customer DashBoard");
        getContentPane().add(jLabelDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        jLabelImg.setForeground(new java.awt.Color(255, 255, 255));
        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Customer.jpg"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 800, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setMenu() {
        jTextAreaMenu.append("Appetizers:\n");
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("appetizer")) {
                jTextAreaMenu.append(temp.getDishes().get(i).getName() + "  " + temp.getDishes().get(i).getPrice() + "\n");
            }
        }
        jTextAreaMenu.append("\n\nMain Course:\n");
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("main_course")) {
                jTextAreaMenu.append(temp.getDishes().get(i).getName() + "  " + temp.getDishes().get(i).getPrice() + "\n");
            }
        }
        jTextAreaMenu.append("\n\nDesserts:\n");
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (temp.getDishes().get(i).getType().equals("desert")) {
                jTextAreaMenu.append(temp.getDishes().get(i).getName() + "  " + temp.getDishes().get(i).getPrice() + "\n");
            }
        }
        ((DefaultEditor) jSpinnerDishQuantity.getEditor()).getTextField().setEditable(false);
    }

    private void btnReserveTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveTableActionPerformed
        if (jComboBoxTableNum.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a table !!");
        } else {
            int num = Integer.parseInt((String) jComboBoxTableNum.getSelectedItem());
            for (int i = 0; i < tables.size(); i++) {
                if (num == tables.get(i).getTableNumber()) {
                    customer.setTable(tables.get(i));
                    tables.remove(i);
                }
            }
            JOptionPane.showMessageDialog(this, "Reserved Successfully");
            btnAddItems.setEnabled(true);
            btnReserveTable.setEnabled(false);
            jComboBoxTableNum.setSelectedItem("");
            jComboBoxTableNum.setEnabled(false);
            jTextAreaMenu.setText("");
            setMenu();
        }
    }//GEN-LAST:event_btnReserveTableActionPerformed

    private void btnAddItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemsActionPerformed
        String str;
        int quantity;
        if (jComboBoxDishName.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a dish");
        } else {
            str = (String) jComboBoxDishName.getSelectedItem();
            quantity = (int) jSpinnerDishQuantity.getValue();
            jTextAreaReceipt.append(str + "         " + jSpinnerDishQuantity.getValue() + "\n");
            for (int i = 0; i < temp.getDishes().size(); i++) {
                if (str.equals(temp.getDishes().get(i).getName())) {
                    Dish dish = new Dish();
                    dish.setName(temp.getDishes().get(i).getName());
                    dish.setType(temp.getDishes().get(i).getType());
                    dish.setPrice(temp.getDishes().get(i).getPrice());
                    dish.setQuantity(quantity);
                    customer.setDish(dish);
                    dishPrice += dish.getPrice() * quantity;
                    JOptionPane.showMessageDialog(this, "Items added Successfully");
                }
            }
            jComboBoxDishName.setSelectedItem("");
            jSpinnerDishQuantity.setValue(1);
            btnAddItems.setEnabled(true);
            btnMakeOrder.setEnabled(true);

        }
    }//GEN-LAST:event_btnAddItemsActionPerformed

    private void btnMakeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeOrderActionPerformed
        btnAddItems.setEnabled(false);
        btnGetPrice.setEnabled(true);
        btnMakeOrder.setEnabled(false);
        if (temp.getCustomers().isEmpty()) {
            customer.setOrderNum(1);
        } else {
            customer.setOrderNum(temp.getCustomers().get(temp.getCustomers().size() - 1).getOrderNum() + 1);
        }
        JOptionPane.showMessageDialog(this, "Order Made Successfully: Order #" + customer.getOrderNum());
    }//GEN-LAST:event_btnMakeOrderActionPerformed

    private void btnGetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetPriceActionPerformed
        jTextAreaReceipt.setText("");
        temp.getCustomers().add(customer);
        temp.setCustomers(temp.getCustomers());
        jTextAreaReceipt.append("Order #" + customer.getOrderNum());
        jTextAreaReceipt.append("\n---------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < customer.getDish().size(); i++) {
            jTextAreaReceipt.append(customer.getDish().get(i).getName() + "     " + Math.round(customer.getDish().get(i).getPrice()) + "     " + customer.getDish().get(i).getQuantity() + "\n");
        }
        jBtnLogout.setEnabled(true);
        jTextAreaReceipt.append("---------------------------------------------------------------------------------------------\n");
        jTextAreaReceipt.append("Taxes : " + (customer.getTotalPrice() - dishPrice) + "\nTotal Price : " + customer.getTotalPrice());
        customer.setMode("preparing");

        btnGetPrice.setEnabled(false);
    }//GEN-LAST:event_btnGetPriceActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        try {
            temp.writeToXmlFile(temp);
            Login gui = new Login();
            gui.setVisible(true);
            this.setVisible(false);
        } catch (JAXBException | ParserConfigurationException | TransformerException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error in System");
            System.exit(-1);
        }
        JOptionPane.showMessageDialog(this, "Saved");

    }//GEN-LAST:event_jBtnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItems;
    private javax.swing.JButton btnGetPrice;
    private javax.swing.JButton btnMakeOrder;
    private javax.swing.JButton btnReserveTable;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JComboBox<String> jComboBoxDishName;
    private javax.swing.JComboBox<String> jComboBoxTableNum;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelDish;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelQuantity;
    private javax.swing.JLabel jLabelTableNum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerDishQuantity;
    private javax.swing.JTextArea jTextAreaMenu;
    private javax.swing.JTextArea jTextAreaReceipt;
    // End of variables declaration//GEN-END:variables
}

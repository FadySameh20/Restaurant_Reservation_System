package gui;

import java.io.IOException;
import restaurant.ReadWrite;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import restaurant.UserXML;
import utensils.Dish;
import utensils.Table;

public class Register extends javax.swing.JFrame {

    ReadWrite temp;

    public Register(ReadWrite temp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.temp = temp;
        jLabelUser.setVisible(false);
        jLabelName.setVisible(false);
        jLabelUsername.setVisible(false);
        jLabelPassword.setVisible(false);
        jLabelDishName.setVisible(false);
        jLabelDishType.setVisible(false);
        jLabelDish.setVisible(false);
        jLabelDishPrice.setVisible(false);
        jLabelTable.setVisible(false);
        jLabelTabelNum.setVisible(false);
        jLabelSeats.setVisible(false);
        jLabelSmoking.setVisible(false);
        jTextFieldName.setVisible(false);
        jTextFieldUsername.setVisible(false);
        jTextFieldDishPrice.setVisible(false);
        jTextFieldDishName.setVisible(false);
        jComboBoxDishType.setVisible(false);
        jComboBoxSmoking.setVisible(false);
        jSpinnerTableNum.setVisible(false);
        jSpinnerSeats.setVisible(false);
        jPasswordField.setVisible(false);
        jBtnAddUser.setVisible(false);
        jBtnAddDish.setVisible(false);
        jBtnAddTable.setVisible(false);
        ((DefaultEditor) jSpinnerTableNum.getEditor()).getTextField().setEditable(false);
        ((DefaultEditor) jSpinnerSeats.getEditor()).getTextField().setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnExit = new javax.swing.JButton();
        jLabelRegistraion = new javax.swing.JLabel();
        jBtnAddUser = new javax.swing.JButton();
        jComboBoxRole = new javax.swing.JComboBox<>();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelRole = new javax.swing.JLabel();
        jBtnAddDish = new javax.swing.JButton();
        jTextFieldDishName = new javax.swing.JTextField();
        jComboBoxDishType = new javax.swing.JComboBox<>();
        jTextFieldDishPrice = new javax.swing.JTextField();
        jLabelDishPrice = new javax.swing.JLabel();
        jLabelDishType = new javax.swing.JLabel();
        jLabelDishName = new javax.swing.JLabel();
        jLabelDish = new javax.swing.JLabel();
        jBtnAddTable = new javax.swing.JButton();
        jSpinnerTableNum = new javax.swing.JSpinner();
        jLabelTabelNum = new javax.swing.JLabel();
        jLabelTable = new javax.swing.JLabel();
        jLabelSeats = new javax.swing.JLabel();
        jSpinnerSeats = new javax.swing.JSpinner();
        jComboBoxSmoking = new javax.swing.JComboBox<>();
        jLabelSmoking = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnExit.setText("Return to login screen");
        jBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExitActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 222, 80));

        jLabelRegistraion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelRegistraion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegistraion.setText("Registration");
        getContentPane().add(jLabelRegistraion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jBtnAddUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnAddUser.setText("Add User");
        jBtnAddUser.setBorder(null);
        jBtnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddUserActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 176, 97));

        jComboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Staff & Utensils", "Client" }));
        jComboBoxRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRoleActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 87, 127, -1));
        getContentPane().add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 125, 127, -1));
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 156, 127, -1));
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 194, 127, -1));

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Password");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 196, -1, -1));

        jLabelUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Username");
        getContentPane().add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 158, -1, -1));

        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelName.setText("Name");
        getContentPane().add(jLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 127, -1, -1));

        jLabelRole.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelRole.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRole.setText("Role");
        getContentPane().add(jLabelRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 92, -1, -1));

        jBtnAddDish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnAddDish.setText("Add Dish");
        jBtnAddDish.setBorder(null);
        jBtnAddDish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddDishActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAddDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 279, 172, 91));
        getContentPane().add(jTextFieldDishName, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 279, 117, -1));

        jComboBoxDishType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "appetizer", "main_course", "desert" }));
        getContentPane().add(jComboBoxDishType, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 310, 117, -1));
        getContentPane().add(jTextFieldDishPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 340, 117, -1));

        jLabelDishPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDishPrice.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDishPrice.setText("Price");
        getContentPane().add(jLabelDishPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 342, -1, -1));

        jLabelDishType.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDishType.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDishType.setText("Type");
        getContentPane().add(jLabelDishType, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 310, -1, -1));

        jLabelDishName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDishName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDishName.setText("Name");
        getContentPane().add(jLabelDishName, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 281, -1, -1));

        jLabelDish.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelDish.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDish.setText("Dish");
        getContentPane().add(jLabelDish, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 249, -1, -1));

        jBtnAddTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnAddTable.setText("Add Table");
        jBtnAddTable.setBorder(null);
        jBtnAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddTableActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAddTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 420, 175, 96));

        jSpinnerTableNum.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        getContentPane().add(jSpinnerTableNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 431, 56, -1));

        jLabelTabelNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTabelNum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTabelNum.setText("Table Number");
        getContentPane().add(jLabelTabelNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 433, -1, -1));

        jLabelTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTable.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTable.setText("Table");
        getContentPane().add(jLabelTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 398, -1, -1));

        jLabelSeats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSeats.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeats.setText("Table Seats");
        getContentPane().add(jLabelSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 471, -1, -1));

        jSpinnerSeats.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        getContentPane().add(jSpinnerSeats, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 469, 56, -1));

        jComboBoxSmoking.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "true", "false" }));
        getContentPane().add(jComboBoxSmoking, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 507, 75, -1));

        jLabelSmoking.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelSmoking.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSmoking.setText("Smoking");
        getContentPane().add(jLabelSmoking, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 509, -1, -1));

        jLabelUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setText("User");
        getContentPane().add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 59, -1, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Register.jpg"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -260, -1, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddDishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddDishActionPerformed

        int flag = 0;
        for (int i = 0; i < temp.getDishes().size(); i++) {
            if (jTextFieldDishName.getText().equalsIgnoreCase(temp.getDishes().get(i).getName())) {
                JOptionPane.showMessageDialog(this, "This Dish already exists!!");
                flag = 1;
            }
        }
        if (jTextFieldDishPrice.getText().equals("") || jComboBoxDishType.getSelectedItem().equals("") || jTextFieldDishName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all data");
            flag = 1;
        }
        if (flag != 1) {
            boolean valid;
            valid = Pattern.matches("^[a-zA-Z\\s]+", jTextFieldDishName.getText());
            if (valid == false) {
                flag = 1;
                JOptionPane.showMessageDialog(this, "Invalid Dish Name");
            }
        }
        try {
            Integer.parseInt(jTextFieldDishPrice.getText());
        } catch (NumberFormatException e) {
            if (flag == 0) {
                JOptionPane.showMessageDialog(this, "Please enter correct price");
            }
            flag = 1;
        }
        if (flag == 0) {
            Dish dish = new Dish();
            dish.setPrice(Integer.parseInt(jTextFieldDishPrice.getText()));
            dish.setName(jTextFieldDishName.getText());
            dish.setType((String) jComboBoxDishType.getSelectedItem());
            temp.setDishes(dish);
            JOptionPane.showMessageDialog(this, "Dish Added Successfully");
            jTextFieldDishName.setText("");
            jTextFieldDishPrice.setText("");
            jComboBoxDishType.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jBtnAddDishActionPerformed

    private void jBtnAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddTableActionPerformed
        int flag = 0;
        int tableNum = (int) jSpinnerTableNum.getValue();
        int seats = (int) jSpinnerSeats.getValue();
        String str = (String) jComboBoxSmoking.getSelectedItem();
        if (str.equals("")) {
            flag = 1;
            JOptionPane.showMessageDialog(this, "Please choose table's type");
        }
        for (int i = 0; i < temp.getTables().size(); i++) {
            if (tableNum == temp.getTables().get(i).getTableNumber()) {
                flag = 1;
            }
        }
        for (int i = 0; i < temp.getCustomers().size(); i++) {
            if (tableNum == temp.getCustomers().get(i).getTable().getTableNumber()) {
                flag = 1;
            }

        }
        if (flag == 1) {
            JOptionPane.showMessageDialog(this, "Table's number already exists!!");
        }

        if (flag == 0) {
            Table table = new Table();
            table.setTableNumber(tableNum);
            table.setNumberOfSeats(seats);
            boolean smoke;
            if (str.equals("true")) {
                smoke = true;
            } else {
                smoke = false;
            }
            table.setSmokingArea(smoke);
            temp.setTables(table);
            JOptionPane.showMessageDialog(this, "Table Added Successfully");
            jComboBoxSmoking.setSelectedIndex(0);
            jSpinnerSeats.setValue(1);
            jSpinnerTableNum.setValue(1);
        }
    }//GEN-LAST:event_jBtnAddTableActionPerformed

    private void jBtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExitActionPerformed
        Login gui;
        try {
            temp.writeToXmlFile(temp);
            gui = new Login();
            gui.setVisible(true);
            this.setVisible(false);
        } catch (JAXBException | SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            JOptionPane.showMessageDialog(this, "Error in System");
            System.exit(-1);
        }
    }//GEN-LAST:event_jBtnExitActionPerformed

    private void jComboBoxRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRoleActionPerformed
        String str = "";
        int flag = 0;
        if (jComboBoxRole.getSelectedItem().equals("")) {
            flag = 1;
        } else {
            str = (String) jComboBoxRole.getSelectedItem();
        }
        if (flag == 0) {
            if (str.equals("Staff & Utensils")) {
                JOptionPane.showMessageDialog(this, "Please Enter Manager's Username and password to proceed");
                jLabelName.setVisible(false);
                jTextFieldName.setVisible(false);
                showLabels();
                jBtnAddUser.setText("Login");
            } else if (str.equals("Client")) {
                jLabelName.setVisible(true);
                jTextFieldName.setVisible(true);
                showLabels();
                jBtnAddUser.setText("Add User");
            }
        }
    }//GEN-LAST:event_jComboBoxRoleActionPerformed

    private void showLabels() {
        jLabelUsername.setVisible(true);
        jLabelPassword.setVisible(true);
        jTextFieldUsername.setVisible(true);
        jPasswordField.setVisible(true);
        jBtnAddUser.setVisible(true);
    }
    private void jBtnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddUserActionPerformed
        String str;
        if (jComboBoxRole.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a role");
        } else {
            str = (String) jComboBoxRole.getSelectedItem();
            if (str.equals("Client") || str.equals("Waiter") || str.equals("Cooker") || str.equals("Manager")) {
                if (jTextFieldName.getText().equals("") || jTextFieldUsername.getText().equals("") || String.valueOf(jPasswordField.getPassword()).equals("")) {
                    JOptionPane.showMessageDialog(this, "Please fill all fields");
                } else {
                    int flag = 0;
                    boolean valid;
                    valid = Pattern.matches("^[a-zA-Z\\s]+", jTextFieldName.getText());
                    if (valid == false) {
                        flag = 1;
                        JOptionPane.showMessageDialog(this, "Invalid Name");
                    }
                    UserXML user = new UserXML();
                    user.setAll(jTextFieldName.getText(), str, jTextFieldUsername.getText(), String.valueOf(jPasswordField.getPassword()));
                    for (int i = 0; i < temp.getUsers().size(); i++) {
                        if (temp.getUsers().get(i).getUsername().equals(user.getUsername())) {
                            JOptionPane.showMessageDialog(this, "Username is already taken");
                            jTextFieldUsername.setText("");
                            flag = 1;
                            break;
                        }
                        if (temp.getUsers().get(i).getPassword().equals(user.getPassword())) {
                            JOptionPane.showMessageDialog(this, "Password is already taken");
                            jPasswordField.setText("");
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        temp.setUsers(user);
                        JOptionPane.showMessageDialog(this, "User Added Successfully");
                        jTextFieldName.setText("");
                        jTextFieldUsername.setText("");
                        jPasswordField.setText("");
                        jComboBoxRole.setSelectedIndex(0);
                        if (str.equals("Client")) {
                            try {
                                temp.writeToXmlFile(temp);
                                Login gui = new Login();
                                gui.setVisible(true);
                                this.setVisible(false);
                            } catch (JAXBException | SAXException | IOException | ParserConfigurationException | TransformerException ex) {
                                JOptionPane.showMessageDialog(null, "Error in System");
                                System.exit(-1);
                            }
                        }
                    }
                }
            } else {
                int flag = 0;
                for (int i = 0; i < temp.getUsers().size(); i++) {
                    if (temp.getUsers().get(i).getRole().equalsIgnoreCase("Manager") && temp.getUsers().get(i).getUsername().equals(jTextFieldUsername.getText()) && temp.getUsers().get(i).getPassword().equals(String.valueOf(jPasswordField.getPassword()))) {
                        JOptionPane.showMessageDialog(this, "Correct !");
                        jLabelUser.setVisible(true);
                        jLabelRole.setVisible(true);
                        jComboBoxRole.addItem("Waiter");
                        jComboBoxRole.addItem("Cooker");
                        jComboBoxRole.addItem("Manager");
                        jComboBoxRole.removeItemAt(1);
                        jComboBoxRole.removeItemAt(1);
                        jTextFieldUsername.setText("");
                        jLabelName.setVisible(true);
                        jLabelRole.setVisible(true);
                        jTextFieldName.setVisible(true);
                        jComboBoxRole.setSelectedItem("");
                        jPasswordField.setText("");
                        jLabelName.setVisible(true);
                        jLabelDishName.setVisible(true);
                        jLabelDishType.setVisible(true);
                        jLabelDish.setVisible(true);
                        jLabelDishPrice.setVisible(true);
                        jLabelTable.setVisible(true);
                        jLabelTabelNum.setVisible(true);
                        jLabelSeats.setVisible(true);
                        jLabelSmoking.setVisible(true);
                        jTextFieldName.setVisible(true);
                        jTextFieldUsername.setVisible(true);
                        jTextFieldDishPrice.setVisible(true);
                        jTextFieldDishName.setVisible(true);
                        jComboBoxDishType.setVisible(true);
                        jComboBoxSmoking.setVisible(true);
                        jSpinnerTableNum.setVisible(true);
                        jSpinnerSeats.setVisible(true);
                        jBtnAddUser.setVisible(true);
                        jBtnAddUser.setText("Add Staff");
                        jBtnAddDish.setVisible(true);
                        jBtnAddTable.setVisible(true);
                        jBtnExit.setVisible(true);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
                }
            }
        }
    }//GEN-LAST:event_jBtnAddUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddDish;
    private javax.swing.JButton jBtnAddTable;
    private javax.swing.JButton jBtnAddUser;
    private javax.swing.JButton jBtnExit;
    private javax.swing.JComboBox<String> jComboBoxDishType;
    private javax.swing.JComboBox<String> jComboBoxRole;
    private javax.swing.JComboBox<String> jComboBoxSmoking;
    private javax.swing.JLabel jLabelDish;
    private javax.swing.JLabel jLabelDishName;
    private javax.swing.JLabel jLabelDishPrice;
    private javax.swing.JLabel jLabelDishType;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRegistraion;
    private javax.swing.JLabel jLabelRole;
    private javax.swing.JLabel jLabelSeats;
    private javax.swing.JLabel jLabelSmoking;
    private javax.swing.JLabel jLabelTabelNum;
    private javax.swing.JLabel jLabelTable;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JSpinner jSpinnerSeats;
    private javax.swing.JSpinner jSpinnerTableNum;
    private javax.swing.JTextField jTextFieldDishName;
    private javax.swing.JTextField jTextFieldDishPrice;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}

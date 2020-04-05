package gui;

import java.io.IOException;
import restaurant.ReadWrite;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import users.Cook;
import users.Customer;
import users.Manager;
import users.User;
import users.Waiter;

public class Login extends javax.swing.JFrame {

    ReadWrite temp;

    public Login() throws JAXBException, SAXException, IOException, ParserConfigurationException, TransformerException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.temp = ReadWrite.getInstance().readFromXmlFile();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jBtnLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jTextFieldUsername = new javax.swing.JTextField();
        jBtnRegister = new javax.swing.JButton();
        jLabelLogin = new javax.swing.JLabel();
        jLabelSystem = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsername.setText("Username");
        getContentPane().add(jLabelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));

        jLabelPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPassword.setText("Password");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jBtnLogin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnLogin.setText("Login");
        jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 112, 52));

        jPasswordField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 104, -1));

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 104, -1));

        jBtnRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnRegister.setText("Register");
        jBtnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 110, 52));

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogin.setText("Login");
        getContentPane().add(jLabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabelSystem.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSystem.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSystem.setText("Restaurant Reservation System");
        getContentPane().add(jLabelSystem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Login.jpg"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 500, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLoginActionPerformed
        String username = jTextFieldUsername.getText();
        String password = String.valueOf(jPasswordField.getPassword());
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill text fields");
        } else {
            int flag = 0;
            int flag1 = 0;
            for (int i = 0; i < temp.getUsers().size(); i++) {
                if (temp.getUsers().get(i).getUsername().equals(username) && temp.getUsers().get(i).getPassword().equals(password)) {
                    flag = 1;
                    if (temp.getUsers().get(i).getRole().equals("Client")) {
                        if (flag1 == 0) {
                            if (temp.getTables().isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Sorry there are no available tables !!");
                            } else {
                                this.setVisible(false);
                                User customer = new Customer();
                                customer.setAll(temp.getUsers().get(i).getName(), temp.getUsers().get(i).getRole(), temp.getUsers().get(i).getUsername(), temp.getUsers().get(i).getPassword());
                                JOptionPane.showMessageDialog(this, "Navigated to Client Dashboard");
                                CustomerWindow gui;
                                try {
                                    gui = new CustomerWindow((Customer) customer, temp);
                                    gui.setVisible(true);
                                } catch (JAXBException ex) {
                                    JOptionPane.showMessageDialog(this, "Error in System");
                                    System.exit(-1);
                                }
                                break;
                            }
                        }
                    } else if (temp.getUsers().get(i).getRole().equals("Manager")) {
                        User manager = new Manager();
                        manager.setAll(temp.getUsers().get(i).getName(), temp.getUsers().get(i).getRole(), temp.getUsers().get(i).getUsername(), temp.getUsers().get(i).getPassword());
                        JOptionPane.showMessageDialog(this, "Navigated to Manager Dashboard");
                        ManagerWindow gui = new ManagerWindow(temp);
                        gui.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    if (temp.getUsers().get(i).getRole().equals("Waiter")) {
                        User waiter = new Waiter();
                        waiter.setAll(temp.getUsers().get(i).getName(), temp.getUsers().get(i).getRole(), temp.getUsers().get(i).getUsername(), temp.getUsers().get(i).getPassword());
                        JOptionPane.showMessageDialog(this, "Navigated to Waiter Dashboard");
                        WaiterWindow gui = new WaiterWindow(temp);
                        gui.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                    if (temp.getUsers().get(i).getRole().equals("Cooker")) {
                        Cook cooker = new Cook();
                        cooker.setAll(temp.getUsers().get(i).getName(), temp.getUsers().get(i).getRole(), temp.getUsers().get(i).getUsername(), temp.getUsers().get(i).getPassword());
                        JOptionPane.showMessageDialog(this, "Navigated to Cook Dashboard");
                        CookWindow gui = new CookWindow(cooker, temp);
                        gui.setVisible(true);
                        this.setVisible(false);
                        break;
                    }
                }
            }
            if (flag == 0) {
                JOptionPane.showMessageDialog(this, "Incorrect Username or Password!!");
            }
        }
    }//GEN-LAST:event_jBtnLoginActionPerformed

    private void jBtnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegisterActionPerformed
        Register register = new Register(temp);
        register.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnRegisterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnLogin;
    private javax.swing.JButton jBtnRegister;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelSystem;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}

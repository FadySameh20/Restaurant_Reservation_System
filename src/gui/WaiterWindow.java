package gui;

import java.io.IOException;
import restaurant.ReadWrite;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class WaiterWindow extends javax.swing.JFrame {

    DefaultTableModel table;
    ReadWrite temp;

    public WaiterWindow(ReadWrite temp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.temp = temp;

        table = (DefaultTableModel) jTableOrders.getModel();
        jTableOrders.setOpaque(false);
        ((DefaultTableCellRenderer) jTableOrders.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jComboBoxOrderNum.setVisible(true);
        jComboBoxOrderNum.addItem("");
        for (int x = 0; x < temp.getCustomers().size(); x++) {
            if (temp.getCustomers().get(x).getMode().equals("ready")) {
                jComboBoxOrderNum.addItem(String.valueOf(temp.getCustomers().get(x).getOrderNum()));
                table.addRow(new Object[]{temp.getCustomers().get(x).getOrderNum(), temp.getCustomers().get(x).getTable().getTableNumber(), temp.getCustomers().get(x).getName()});
                table.addRow(new Object[]{"", "", ""});
            }
        }
        jTableOrders.setRowSelectionAllowed(false);
        jTableOrders.setFocusable(false);
        jComboBoxOrderNum.setToolTipText("Order number");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnDeliver = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrders = new javax.swing.JTable();
        jLabelDashBoard = new javax.swing.JLabel();
        jComboBoxOrderNum = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnDeliver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnDeliver.setText("Deliever");
        jBtnDeliver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeliverActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDeliver, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 168, 97));

        jBtnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 168, 92));

        jTableOrders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orders", "Table Number", "Customer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrders.setOpaque(false);
        jTableOrders.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableOrders);
        if (jTableOrders.getColumnModel().getColumnCount() > 0) {
            jTableOrders.getColumnModel().getColumn(0).setResizable(false);
            jTableOrders.getColumnModel().getColumn(1).setResizable(false);
            jTableOrders.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 81, -1, 297));

        jLabelDashBoard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDashBoard.setText("Waiter DashBoard");
        getContentPane().add(jLabelDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 11, -1, -1));

        getContentPane().add(jComboBoxOrderNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order Number");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Waiter.jpg"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDeliverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeliverActionPerformed

        String str;
        if (jComboBoxOrderNum.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose an order to serve");
        } else {
            str = (String) jComboBoxOrderNum.getSelectedItem();
            int x = Integer.parseInt(str);
            int m = jComboBoxOrderNum.getSelectedIndex();
            JOptionPane.showMessageDialog(this, "Delivered!");
            jComboBoxOrderNum.removeItemAt(m);
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                if (temp.getCustomers().get(i).getOrderNum() == x) {
                    int flag = 0;
                    temp.getCustomers().get(i).setMode("delivered");
                    for (int j = 0; j < temp.getCustomers().size(); j++) {
                        if (!temp.getCustomers().get(j).getMode().equals("delivered") && temp.getCustomers().get(j).getUsername().equals(temp.getCustomers().get(i).getUsername()) && temp.getCustomers().get(j).getPassword().equals(temp.getCustomers().get(i).getPassword()) && temp.getCustomers().get(j).getTable().getTableNumber() == temp.getCustomers().get(i).getTable().getTableNumber()) {
                            //check if the customer has received all his orders(since one customer can make more than one order but with same table) to make his table avaiable 

                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        temp.setTables(temp.getCustomers().get(i).getTable());
                        break;
                    }
                    break;
                }
            }
            table.setRowCount(0);
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                if (temp.getCustomers().get(i).getMode().equals("ready")) {
                    table.addRow(new Object[]{temp.getCustomers().get(i).getOrderNum(), temp.getCustomers().get(i).getTable().getTableNumber(), temp.getCustomers().get(i).getName()});
                    table.addRow(new Object[]{"", "", ""});
                }
            }
        }
    }//GEN-LAST:event_jBtnDeliverActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        try {
            temp.writeToXmlFile(temp);
            Login login = new Login();
            this.setVisible(false);
            login.setVisible(true);
        } catch (JAXBException ex) {
            JOptionPane.showMessageDialog(this, "Error in System");
            System.exit(-1);
        } catch (ParserConfigurationException | TransformerException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in System");
            System.exit(-1);
        }
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDeliver;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JComboBox<String> jComboBoxOrderNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOrders;
    // End of variables declaration//GEN-END:variables
}

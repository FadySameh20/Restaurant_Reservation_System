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
import users.Cook;

public class CookWindow extends javax.swing.JFrame {

    ReadWrite temp;
    DefaultTableModel table;

    public CookWindow(Cook cook, ReadWrite temp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.temp = temp;
        jPanel1.setOpaque(false);
        jTableOrders.setOpaque(false);
        ((DefaultTableCellRenderer) jTableOrders.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jComboBoxOrderNum.addItem("");
        for (int x = 0; x < temp.getCustomers().size(); x++) {
            if (temp.getCustomers().get(x).getMode().equals("preparing")) {
                jComboBoxOrderNum.addItem(String.valueOf(temp.getCustomers().get(x).getOrderNum()));
            }
        }
        table = (DefaultTableModel) jTableOrders.getModel();
        jTableOrders.setRowSelectionAllowed(false);
        jTableOrders.setFocusable(false);
        setjTable();
        jComboBoxOrderNum.setToolTipText("Order number");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelOrders = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelOrderNum = new javax.swing.JLabel();
        jComboBoxOrderNum = new javax.swing.JComboBox<>();
        jBtnCook = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOrders = new javax.swing.JTable();
        jLabelDashBoard = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelOrders.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelOrders.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrders.setText("Orders");
        getContentPane().add(jLabelOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        jLabelOrderNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelOrderNum.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOrderNum.setText("Order Number :");

        jComboBoxOrderNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jBtnCook.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnCook.setText("Cook");
        jBtnCook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCookActionPerformed(evt);
            }
        });

        jBtnLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelOrderNum)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBoxOrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnCook, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrderNum)
                    .addComponent(jComboBoxOrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCook, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 329, 340));

        jTableOrders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableOrders.setForeground(new java.awt.Color(255, 255, 0));
        jTableOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orders", "Table Number", "Dish Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableOrders.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableOrders);
        if (jTableOrders.getColumnModel().getColumnCount() > 0) {
            jTableOrders.getColumnModel().getColumn(1).setResizable(false);
            jTableOrders.getColumnModel().getColumn(2).setResizable(false);
            jTableOrders.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 480, 251));

        jLabelDashBoard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDashBoard.setText("Cook DashBoard");
        getContentPane().add(jLabelDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 23, -1, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Cook.jpg"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 840, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setjTable() {
        for (int k = 0; k < temp.getCustomers().size(); k++) {
            if (temp.getCustomers().get(k).getMode().equals("ready") || temp.getCustomers().get(k).getMode().equals("delivered")) {
                continue;
            }
            int m = 0;
            table.addRow(new Object[]{temp.getCustomers().get(k).getOrderNum(), temp.getCustomers().get(k).getTable().getTableNumber(), "", ""});
            int i = table.getRowCount();
            for (; m < temp.getCustomers().get(k).getDish().size(); i++) {
                int j = 2;
                table.setValueAt(temp.getCustomers().get(k).getDish().get(m).getName(), i - 1, j++);
                table.setValueAt(temp.getCustomers().get(k).getDish().get(m).getQuantity(), i - 1, j++);
                m++;
                table.addRow(new Object[]{"", "", "", ""});
            }
        }
    }

    private void jBtnCookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCookActionPerformed

        String str;
        if (jComboBoxOrderNum.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose an order to cook");
        } else {
            str = (String) jComboBoxOrderNum.getSelectedItem();
            int x = Integer.parseInt(str);
            int m = jComboBoxOrderNum.getSelectedIndex();
            JOptionPane.showMessageDialog(this, "Cooked!");
            jComboBoxOrderNum.removeItemAt(m);
            for (int i = 0; i < temp.getCustomers().size(); i++) {
                if (temp.getCustomers().get(i).getOrderNum() == x) {
                    temp.getCustomers().get(i).setMode("ready");
                    break;
                }
            }
        }
        jComboBoxOrderNum.setSelectedItem("");
        table.setRowCount(0);
        setjTable();

    }//GEN-LAST:event_jBtnCookActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        try {
            temp.writeToXmlFile(temp);
            this.setVisible(false);
            Login login = new Login();
            login.setVisible(true);
        } catch (JAXBException | ParserConfigurationException | TransformerException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(this, "Error in System");
            System.exit(-1);
        }
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCook;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JComboBox<String> jComboBoxOrderNum;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelOrderNum;
    private javax.swing.JLabel jLabelOrders;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableOrders;
    // End of variables declaration//GEN-END:variables
}

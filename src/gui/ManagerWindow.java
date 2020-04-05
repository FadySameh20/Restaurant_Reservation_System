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
import users.Manager;

public class ManagerWindow extends javax.swing.JFrame {
    
    ReadWrite temp;
    DefaultTableModel table;
    int flagStaff = 0;
    int flagCustomers = 0;
    
    public ManagerWindow(ReadWrite temp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.temp = temp;
        jTableStaff.setOpaque(false);
        ((DefaultTableCellRenderer) jTableStaff.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jTableCustomers.setOpaque(false);
        ((DefaultTableCellRenderer) jTableCustomers.getDefaultRenderer(Object.class)).setOpaque(false);
        jScrollPane3.setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        jTableCustomers.setRowSelectionAllowed(false);
        jTableCustomers.setFocusable(false);
        jTableStaff.setRowSelectionAllowed(false);
        jTableStaff.setFocusable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnStaffDet = new javax.swing.JButton();
        jBtnCustomersDet = new javax.swing.JButton();
        jBtnStatistics = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        jLabelDashBoard = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStaff = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCustomers = new javax.swing.JTable();
        jLabelImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnStaffDet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnStaffDet.setText("Staff Details");
        jBtnStaffDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStaffDetActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnStaffDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 139, 165, 40));

        jBtnCustomersDet.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCustomersDet.setText("Customers Details");
        jBtnCustomersDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomersDetActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnCustomersDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 139, 170, 40));

        jBtnStatistics.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnStatistics.setText("Statistics");
        jBtnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStatisticsActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 139, 162, 40));

        jBtnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(866, 139, 160, 40));

        jLabelDashBoard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDashBoard.setText("Manager DashBoard");
        getContentPane().add(jLabelDashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        jTableStaff.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableStaff.setForeground(new java.awt.Color(255, 255, 255));
        jTableStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Role", "Name", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStaff.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableStaff);
        if (jTableStaff.getColumnModel().getColumnCount() > 0) {
            jTableStaff.getColumnModel().getColumn(0).setResizable(false);
            jTableStaff.getColumnModel().getColumn(1).setResizable(false);
            jTableStaff.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 197, 350, -1));

        jTableCustomers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableCustomers.setForeground(new java.awt.Color(255, 255, 0));
        jTableCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Name", "Username", "Table Number", "Seats", "Smoking Area", "Dish Name", "Dish Type", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCustomers.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableCustomers);
        if (jTableCustomers.getColumnModel().getColumnCount() > 0) {
            jTableCustomers.getColumnModel().getColumn(0).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(1).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(2).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(3).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(4).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(5).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(6).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(7).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(8).setResizable(false);
            jTableCustomers.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 197, 1010, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Manager.png"))); // NOI18N
        getContentPane().add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStaffDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStaffDetActionPerformed
        if (flagStaff == 0) {
            jPanel1.setVisible(true);
            table = (DefaultTableModel) jTableStaff.getModel();
            int j, rowsNum = 0;
            table.addRow(new Object[]{"Waiters", "", ""});
            for (int i = 0; i < temp.getUsers().size(); i++) {
                j = 1;
                if (temp.getUsers().get(i).getRole().equals("Waiter")) {
                    table.setValueAt(temp.getUsers().get(i).getName(), rowsNum, j++);
                    table.setValueAt(temp.getUsers().get(i).getUsername(), rowsNum, j++);
                    table.addRow(new Object[]{"", "", ""});
                    rowsNum++;
                }
            }
            rowsNum = table.getRowCount();
            table.addRow(new Object[]{"Cooks", "", ""});
            for (int i = 0; i < temp.getUsers().size(); i++) {
                j = 1;
                if (temp.getUsers().get(i).getRole().equals("Cooker")) {
                    table.setValueAt(temp.getUsers().get(i).getName(), rowsNum, j++);
                    table.setValueAt(temp.getUsers().get(i).getUsername(), rowsNum, j++);
                    table.addRow(new Object[]{"", "", ""});
                    rowsNum++;
                }
            }
            flagStaff = 1;
        }

    }//GEN-LAST:event_jBtnStaffDetActionPerformed

    private void jBtnCustomersDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomersDetActionPerformed
        if (flagCustomers == 0) {
            jPanel2.setVisible(true);
            table = (DefaultTableModel) jTableCustomers.getModel();
            for (int k = 0; k < temp.getCustomers().size(); k++) {
                int m = 0;
                table.addRow(new Object[]{temp.getCustomers().get(k).getOrderNum(), temp.getCustomers().get(k).getName(), temp.getCustomers().get(k).getUsername(), temp.getCustomers().get(k).getTable().getTableNumber(), temp.getCustomers().get(k).getTable().getNumberOfSeats(), temp.getCustomers().get(k).getTable().isSmokingArea(), "", "", "", temp.getCustomers().get(k).getTotalPrice()});
                int i = table.getRowCount();
                for (; m < temp.getCustomers().get(k).getDish().size(); i++) {
                    int j = 6;
                    table.setValueAt(temp.getCustomers().get(k).getDish().get(m).getName(), i - 1, j++);
                    table.setValueAt(temp.getCustomers().get(k).getDish().get(m).getType(), i - 1, j++);
                    table.setValueAt(temp.getCustomers().get(k).getDish().get(m).getQuantity(), i - 1, j++);
                    m++;
                    table.addRow(new Object[]{"", "", "", "", "", ""});
                    
                }
            }
            flagCustomers = 1;
        }

    }//GEN-LAST:event_jBtnCustomersDetActionPerformed

    private void jBtnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStatisticsActionPerformed
        
        Manager manager = new Manager();
        double totalProfit = manager.getStatistics(temp.getCustomers());
        JOptionPane.showMessageDialog(this, "Total Profit is " + totalProfit);

    }//GEN-LAST:event_jBtnStatisticsActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        try {
            Login login = new Login();
            login.setVisible(true);
            this.setVisible(false);
        } catch (JAXBException | SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            JOptionPane.showConfirmDialog(this, "Error in System");
            System.exit(-1);
        }
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCustomersDet;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JButton jBtnStaffDet;
    private javax.swing.JButton jBtnStatistics;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCustomers;
    private javax.swing.JTable jTableStaff;
    // End of variables declaration//GEN-END:variables
}

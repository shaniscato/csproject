/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTable;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kp
 */
public class Products extends javax.swing.JFrame {

    /**
     * Creates new form Products
     */
    
    DefaultTableModel model;
    int prodID;
    String prodname;
    double unit;
    int onhand;
    
    public Products() {
        initComponents();
        showTable();
    }
    public Products(int prodID, String prodname, double unit, int onhand){
        initComponents();
        showTable();
        this.prodID = prodID;
        this.prodname = prodname;
        this.unit = unit;
        this.onhand = onhand;
    }
    public int getProdID(){return prodID;}
    public String getProdName(){return prodname;}
    public double getUnitPrice(){return unit;}
    public int getOnHand(){return onhand;}
    
    
    
    /*private static class productdetails {
        private static int prodID;
        private static String prodname;
        private static double unit;
        private static int onhand;
        public productdetails(int prodID, String prodname, double unit, int onhand)
        {
            this.prodID = prodID;
            this.prodname = prodname;
            this.unit = unit;
            this.onhand = onhand;
        }
        public int getProdID(){return this.prodID;}
        public String getProdName(){return this.prodname;}
        public double getUnitPrice(){return this.unit;}
        public int getOnHand(){return this.onhand;}
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtpid = new javax.swing.JTextField();
        lblPid = new javax.swing.JLabel();
        lblpname = new javax.swing.JLabel();
        txtpname = new javax.swing.JTextField();
        lblUnitprice = new javax.swing.JLabel();
        txtunitprice = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        P_Cancel = new javax.swing.JButton();
        txtonhand = new javax.swing.JTextField();
        lblonhand = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        P_save = new javax.swing.JButton();
        P_delete = new javax.swing.JButton();
        P_exit = new javax.swing.JButton();
        homebttn = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        txtpid.setBackground(new java.awt.Color(0, 0, 0));
        txtpid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpid.setForeground(new java.awt.Color(255, 255, 0));
        txtpid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtpidFocusLost(evt);
            }
        });
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });
        txtpid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpidKeyPressed(evt);
            }
        });

        lblPid.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblPid.setForeground(new java.awt.Color(255, 255, 255));
        lblPid.setText("Product ID");

        lblpname.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblpname.setForeground(new java.awt.Color(255, 255, 255));
        lblpname.setText("Product Name");

        txtpname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblUnitprice.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblUnitprice.setForeground(new java.awt.Color(255, 255, 255));
        lblUnitprice.setText("Unit Price");

        txtunitprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        addButton.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        P_Cancel.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        P_Cancel.setText("Cancel");
        P_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_CancelActionPerformed(evt);
            }
        });

        txtonhand.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblonhand.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblonhand.setForeground(new java.awt.Color(255, 255, 255));
        lblonhand.setText("Onhand");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(P_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPid, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtpid))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblpname)
                            .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtunitprice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnitprice))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblonhand)
                            .addComponent(txtonhand, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPid)
                    .addComponent(lblpname)
                    .addComponent(lblUnitprice)
                    .addComponent(lblonhand))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtunitprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtonhand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "ProductName", "Unit Price", "Onhand"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        P_save.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        P_save.setText("Save");
        P_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_saveActionPerformed(evt);
            }
        });

        P_delete.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        P_delete.setText("Delete");
        P_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_deleteActionPerformed(evt);
            }
        });

        P_exit.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        P_exit.setText("Exit");
        P_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_exitActionPerformed(evt);
            }
        });

        homebttn.setText("Home");
        homebttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P_save, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(homebttn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(P_save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(P_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(P_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homebttn)
                .addContainerGap())
        );

        refreshButton.setText("Refresh Table");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(refreshButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpidKeyPressed
     // TODO add your handling code here:
    }//GEN-LAST:event_txtpidKeyPressed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtpidActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        model = new DefaultTableModel();
        model = (DefaultTableModel)jTable1.getModel();
        
        for(int i=0;i<100;i++)
        {
            model.addRow(new Object[]
            {
                txtpid.getText(),
                txtpname.getText(),
                txtunitprice.getText(),
                txtonhand.getText(),
            });
        }
        
        
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void P_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_saveActionPerformed
        // TODO add your handling code here:
        if(txtpid.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Please Enter Product ID!","Error!!", ERROR_MESSAGE);
        }
        else if(txtpname.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Please Enter Product Name!","Error!!", ERROR_MESSAGE);

        }
        else {
            try{
                checkData cd = new checkData();
                cd.start();
                POSDAO posDAO1 = new POSDAO();
                
                if(posDAO1.openConnection())
                {
                    prodID = Integer.valueOf(txtpid.getText());
                    prodname = txtpname.getText();
                    unit = Double.valueOf(txtunitprice.getText());
                    onhand = Integer.valueOf(txtonhand.getText());
                    Products product = new Products(prodID, prodname, unit, onhand);
                    
                    if (P_save.getText()=="Save")
                    {
                        
                        posDAO1.insertProductRecord(product);
                        JOptionPane.showMessageDialog(jPanel1,"--New Product Added--"+"\nProduct Code: "+ prodID+"\nProduct Name: "+prodname+"\nUnit Price: "+unit+"\nOnhand: "+onhand);
                        showTable();
                    }
                    else{
                        posDAO1.updateProductRecord(product);
                        JOptionPane.showMessageDialog(jPanel1,"--Product Updated--"+"\nProduct Code: "+ prodID+"\nProduct Name: "+prodname+"\nUnit Price: "+unit+"\nOnhand: "+onhand);
                        showTable();
                    }
                    clear();
                }     
            }
            catch(NullPointerException ex){
                //JOptionPane.showMessageDialog(jPanel1,"");
                System.exit(0);
            } catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_P_saveActionPerformed

    private void P_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_deleteActionPerformed
        // TODO add your handling code here:
        POSDAO posDAO1 = new POSDAO();
        if(posDAO1.openConnection())
        {
            int input = JOptionPane.showConfirmDialog(null,
                "Product Code: "+ prodID+" Product Name: "+prodname+" will be deleted! Press 'OK' to delete.", "Confirm delete...",JOptionPane.OK_CANCEL_OPTION);
            if (input == 0){
                posDAO1.deleteProductRecord(prodID);
                clear();
                JOptionPane.showMessageDialog(jPanel1,"--Product Deleted--"+"\nProduct Code: "+ prodID+"\nProduct Name: "+prodname+"\nUnit Price: "+unit+"\nOnhand: "+onhand);
            }
        }
    }//GEN-LAST:event_P_deleteActionPerformed

    private void P_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_CancelActionPerformed
        // TODO add your handling code here:
        clear();
        showTableData();
    }//GEN-LAST:event_P_CancelActionPerformed

    private void P_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_P_exitActionPerformed

    private void homebttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebttnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Welcome obj3 = new Welcome();
        obj3.setVisible(true);
        
    }//GEN-LAST:event_homebttnActionPerformed

    private void txtpidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpidFocusLost
        // TODO add your handling code here:
        checkData cd = new checkData();
        cd.start();
        
    }//GEN-LAST:event_txtpidFocusLost
    
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        showTable();
    }//GEN-LAST:event_refreshButtonActionPerformed
    public void showTable(){
        try{
            String query = "select * from products order by ProdName, ProdID";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos?" +
                                           "user=root&password=d3rhZj!k");
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            DefaultTableModel tm = (DefaultTableModel)jTable1.getModel();
            tm.setRowCount(0);
            while(rs.next())
            {
                Object row[]={rs.getInt("ProdID"),rs.getString("ProdName"),rs.getDouble("UnitPrice"),rs.getInt("Stock")};
                tm.addRow(row);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String autoOderId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showTableData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void clear(){
        txtpid.setText("");
        txtpname.setText("");
        txtunitprice.setText("");
        txtonhand.setText("");
    }
    class checkData extends Thread{

        public void run(){
            POSDAO posDAO = new POSDAO();
            if(posDAO.openConnection())
            {
                try 
                {
                    Products productFind = null;
                    if(!txtpid.getText().isEmpty())
                    {
                        productFind = posDAO.findProductRecord(Integer.valueOf(txtpid.getText()));
                        if(productFind!=null)
                        {
                            txtpname.setText(productFind.getProdName());
                            txtunitprice.setText(Double.toString(productFind.getUnitPrice()));
                            txtonhand.setText(Integer.toString(productFind.getOnHand()));
                        }
                    }
                    if(!txtpname.getText().isEmpty()){
                        P_save.setText("Update");
                    }
                    else{
                        P_save.setText("Save");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton P_Cancel;
    private javax.swing.JButton P_delete;
    private javax.swing.JButton P_exit;
    private javax.swing.JButton P_save;
    private javax.swing.JButton addButton;
    private javax.swing.JButton homebttn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPid;
    private javax.swing.JLabel lblUnitprice;
    private javax.swing.JLabel lblonhand;
    private javax.swing.JLabel lblpname;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField txtonhand;
    private javax.swing.JTextField txtpid;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtunitprice;
    // End of variables declaration//GEN-END:variables

    
}
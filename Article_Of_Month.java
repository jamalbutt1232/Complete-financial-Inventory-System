/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Naffah Amin
 */
public class Article_Of_Month extends javax.swing.JFrame {

    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
    String user="l134088";
    String pass="sofabulous12";

    String year = "None", month = "None", article = "None";
    DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Items Sold"}, 0);
    /**
     * Creates new form Article_of_month
     */
    public Article_Of_Month() {
        initComponents();
        try{
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                Statement stmt = con.createStatement();

                rs = stmt.executeQuery("SELECT distinct product_name FROM Order_detail");
               
                while(rs.next()){
                    String s=rs.getString(1);
                    articleCombo.addItem(s);
                }
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
        
        initYears();
    }
    
    private int monthNum(String s)
    {
        if(s.equals("January"))
            return 1;
        else if(s.equals("February"))
            return 2;
        else if(s.equals("March"))
            return 3;
        else if(s.equals("April"))
            return 4;
        else if(s.equals("May"))
            return 5;
        else if(s.equals("June"))
            return 6;
        else if(s.equals("July"))
            return 7;
        else if(s.equals("August"))
            return 8;
        else if(s.equals("September"))
            return 9;
        else if(s.equals("October"))
            return 10;
        else if(s.equals("November"))
            return 11;
        else if(s.equals("December"))
            return 12;
        return 0;
    }
    
    private void initYears() {
        for(int i=0;i<50;i++)
        {
            yearBox.addItem(Integer.toString(2019+i));
        }
    }
    
    private void getTotalSold()
    {
        int amount = 0;
        for (int i = 0; i < jTable1.getRowCount(); i++)
        {
            amount += Integer.parseInt(jTable1.getValueAt(i, 1)+"");
        }
        itemstotal.setText("Total Items Sold: " + amount);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        articleCombo = new javax.swing.JComboBox<String>();
        itemstotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        monthBox = new javax.swing.JComboBox<String>();
        yearBox = new javax.swing.JComboBox<String>();
        showBtn = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Items Sold"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Cooper Black", 1, 36)); // NOI18N
        jLabel3.setText("Article Of Month");

        articleCombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        articleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        articleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articleComboActionPerformed(evt);
            }
        });

        itemstotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        itemstotal.setText("Total Items Sold: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Year:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Month:");

        monthBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monthBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthBoxActionPerformed(evt);
            }
        });

        yearBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yearBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        yearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(articleCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(478, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(itemstotal)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(220, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(articleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(itemstotal)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        showBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showBtn.setText("Show Items");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        printBtn.setBackground(new java.awt.Color(51, 153, 255));
        printBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        printBtn.setText("Print Screen");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        // TODO add your handling code here:
        if (article.equals("None") || year.equals("None") || month.equals("None"))
        {
            JOptionPane.showMessageDialog(this, "Choice cannot be None");
            return;
        }
        
        model.setRowCount(0);
        jTable1.setModel(model);
        
        int m = monthNum(monthBox.getSelectedItem().toString());
        
        try
        {
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                String query = "SELECT count(product_name), Day(transaction_date) FROM Order_detail WHERE product_name=? AND Year(transaction_date)='"+year+"' AND Month(transaction_date)='"+m+"' GROUP BY Day(transaction_date)";

                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1, article);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    String d = rs.getString(1);
                    String e = rs.getString(2)+"-"+m+"-"+year;

                    model.addRow(new Object[]{e, d});
                }
                
                jTable1.setModel(model);
                getTotalSold();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString());                    
        }
    }//GEN-LAST:event_showBtnActionPerformed

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        MessageFormat header = new MessageFormat(articleCombo.getSelectedItem().toString() + ", " + monthBox.getSelectedItem().toString() + " - " + yearBox.getSelectedItem().toString());
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_printBtnActionPerformed

    private void articleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articleComboActionPerformed
        // TODO add your handling code here:
        article = articleCombo.getSelectedItem().toString();
    }//GEN-LAST:event_articleComboActionPerformed

    private void monthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthBoxActionPerformed
        // TODO add your handling code here:
        month = monthBox.getSelectedItem().toString();
    }//GEN-LAST:event_monthBoxActionPerformed

    private void yearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearBoxActionPerformed
        // TODO add your handling code here:
        year = yearBox.getSelectedItem().toString();
    }//GEN-LAST:event_yearBoxActionPerformed

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
            java.util.logging.Logger.getLogger(Article_Of_Month.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Article_Of_Month.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Article_Of_Month.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Article_Of_Month.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Article_Of_Month().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> articleCombo;
    private javax.swing.JLabel itemstotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> monthBox;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton showBtn;
    private javax.swing.JComboBox<String> yearBox;
    // End of variables declaration//GEN-END:variables
}

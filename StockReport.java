/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;

import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author Naffah Amin
 */
public class StockReport extends javax.swing.JFrame {

    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
    String user="l134088";
    String pass="sofabulous12";

    String article="None";
    DefaultTableModel model = new DefaultTableModel(new String[]{"Date" ,"Supplier Name", "Customer Name", "Quantity", "Bag Weight", 
        "Total Weight", "Updated Weight", "Location" , "Total Bags"}, 0);
    /**
     * Creates new form StockReport
     */
    Vector <String> supplierNames = new Vector <String>();
    Vector <String> addWeight = new Vector <String>();
    Vector <String> jTableIndex = new Vector <String>();
    int countNames;
    private void initYears() {
        yearBox.addItem("None");
        for(int i=0;i<50;i++)
        {
            yearBox.addItem(Integer.toString(2019+i));
        }
    }
    private void initYearsLocation() {
        yearBox1.addItem("None");
        for(int i=0;i<50;i++)
        {
            yearBox1.addItem(Integer.toString(2019+i));
        }
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
    
    public StockReport() {
        initComponents();
        fillCombo();
        LoadLocation();
        initYears();initYearsLocation();
    }
    
    private void fillCombo()
    {
        try
        {
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                Statement stmt = con.createStatement();

                rs = stmt.executeQuery("SELECT distinct name FROM Product_details_table");
               
                while(rs.next()){
                    String s=rs.getString(1);
                    articlecombo.addItem(s);
                }
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        articlecombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        showBtn = new javax.swing.JButton();
        showBtn2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        monthBox = new javax.swing.JComboBox();
        yearBox = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        locationcombo = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        monthBox1 = new javax.swing.JComboBox();
        yearBox1 = new javax.swing.JComboBox();
        showBtn3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Article Name");

        articlecombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        articlecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        articlecombo.setMinimumSize(new java.awt.Dimension(60, 30));
        articlecombo.setPreferredSize(new java.awt.Dimension(60, 30));
        articlecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articlecomboActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Stock Report");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Supplier Name", "Customer Name", "Quantity", "Bag Weight", "Weight", "Updated Weight", "Location", "Total Bags"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);

        showBtn.setText("Show Purchased Stock");
        showBtn.setMaximumSize(new java.awt.Dimension(79, 30));
        showBtn.setMinimumSize(new java.awt.Dimension(79, 30));
        showBtn.setPreferredSize(new java.awt.Dimension(60, 30));
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        showBtn2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showBtn2.setText("Show");
        showBtn2.setMaximumSize(new java.awt.Dimension(63, 30));
        showBtn2.setMinimumSize(new java.awt.Dimension(63, 30));
        showBtn2.setPreferredSize(new java.awt.Dimension(60, 30));
        showBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtn2ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        monthBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        monthBox.setMaximumRowCount(13);
        monthBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthBox.setMinimumSize(new java.awt.Dimension(56, 30));
        monthBox.setPreferredSize(new java.awt.Dimension(56, 30));

        yearBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yearBox.setMinimumSize(new java.awt.Dimension(56, 30));
        yearBox.setPreferredSize(new java.awt.Dimension(56, 30));

        jButton1.setText("Print");
        jButton1.setMaximumSize(new java.awt.Dimension(55, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(55, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(55, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Location");

        locationcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        monthBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        monthBox1.setMaximumRowCount(13);
        monthBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthBox1.setMinimumSize(new java.awt.Dimension(56, 30));
        monthBox1.setPreferredSize(new java.awt.Dimension(56, 30));

        yearBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yearBox1.setMinimumSize(new java.awt.Dimension(56, 30));
        yearBox1.setPreferredSize(new java.awt.Dimension(56, 30));

        showBtn3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showBtn3.setText("Show");
        showBtn3.setMaximumSize(new java.awt.Dimension(63, 30));
        showBtn3.setMinimumSize(new java.awt.Dimension(63, 30));
        showBtn3.setPreferredSize(new java.awt.Dimension(60, 30));
        showBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(articlecombo, 0, 200, Short.MAX_VALUE)
                                    .addComponent(locationcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(monthBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(showBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator2))
                        .addGap(18, 18, 18)
                        .addComponent(showBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(532, 532, 532)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(locationcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(articlecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fillAll()
    {
        model.setRowCount(0);
        jTable1.setModel(model);
        
        try
        {
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                String query = "select supplier_name, quantity, weight, original_weight, remaining_weight, location, date from Product_details_table "
                        + "where name=?";

                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1, article);
                rs = pst.executeQuery();float sumOfBags=0,sumOfWeights =0;
                while(rs.next())
                {
                     String a = rs.getString(1);
                    String b = rs.getString(2);
                    sumOfBags = sumOfBags + Float.parseFloat(b);
                    String c = rs.getString(3);
                    String d = rs.getString(4);
                    String e = rs.getString(5);
                    sumOfWeights= sumOfWeights + Float.parseFloat(d);
                    String f = rs.getString(6);
                    String g = rs.getString(7);
                    String none = "-";
                    model.addRow(new Object[]{g,a, none, b, c, d, sumOfWeights, f , sumOfBags});

                }
                
//                jTable1.setModel(model);
//                jTable1.setAutoCreateRowSorter(true);
//                jTable1.getRowSorter().toggleSortOrder(7);
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }
    
    private void fillAll2()
    {
        model.setRowCount(0);
        jTable1.setModel(model);
        
        int month = monthNum(monthBox.getSelectedItem().toString());
        int year = Integer.parseInt(yearBox.getSelectedItem().toString());
        float sumOfWeights =0, sumOfBags = 0;
        try
        {
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                String query = "select supplier_name, quantity, weight, original_weight, remaining_weight, location, date from Product_details_table where name=? AND Year(date)='" + year + "' AND Month(date)='" + month + "'";

                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1, article);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    String a = rs.getString(1);
                    String b = rs.getString(2);
                    sumOfBags = sumOfBags + Float.parseFloat(b);
                    String c = rs.getString(3);
                    String d = rs.getString(4);
                    String e = rs.getString(5);
                    sumOfWeights= sumOfWeights + Float.parseFloat(d);
                    String f = rs.getString(6);
                    String g = rs.getString(7);
                    String none = "-";
                    model.addRow(new Object[]{g ,a, none, b, c, d, sumOfWeights, f, sumOfBags});
                }
                
//                query = "select supplier_name, quantity, weight, original_weight, remaining_weight, location, date from Product_details_table "
//                        + "where name=? and supplier_name=?";
//
//                pst=con.prepareStatement(query);
//                pst.setString(1, article);
//                pst.setString(2, supplier);
//                rs = pst.executeQuery();
//                while(rs.next())
//                {
//                    String a = rs.getString(1);
//                    String b = rs.getString(2);
//                    String c = rs.getString(3);
//                    String d = rs.getString(4);
//                    String e = rs.getString(5);
//                    String f = rs.getString(6);
//                    String g = rs.getString(7);
//                    model.addRow(new Object[]{a, b, c, d, e, f, g});
//                }
                
                query = "select ot.customer_name, od.quantity, od.customer_bag_weight, od.transaction_date, od.supplier_name, od.weight_ordered from Order_table ot, Order_detail od where ot.id = od.id and od.product_name=? AND Year(transaction_date)='" + year + "' AND Month(transaction_date)='" + month + "'";

                pst=con.prepareStatement(query);
                pst.setString(1, article);
                rs = pst.executeQuery();
                while(rs.next())
                {
                    String a = rs.getString(1);
                    String b = rs.getString(2);
                    sumOfBags=sumOfBags - Float.parseFloat(b);
                    String c = rs.getString(3);
                    String d = rs.getString(4);
                    String e = rs.getString(5);
                    String f = rs.getString(6);
                    sumOfWeights = sumOfWeights - Float.parseFloat(f);
                    String none = "-";
                    model.addRow(new Object[]{d,e, a, b, c, f, sumOfWeights, none, sumOfBags});
                }
                
//                jTable1.setModel(model);
//                jTable1.setAutoCreateRowSorter(true);
//                jTable1.getRowSorter().toggleSortOrder(7);
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }
    private void fillAll3()
    {
        model.setRowCount(0);
        jTable1.setModel(model);
        
        int month = monthNum(monthBox1.getSelectedItem().toString());
        int year = Integer.parseInt(yearBox1.getSelectedItem().toString());
        
        try
        {
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                String query = "select supplier_name, quantity, weight, original_weight, remaining_weight, location, date from Product_details_table where location=? AND Year(date)='" + year + "' AND Month(date)='" + month + "'";

                PreparedStatement pst=con.prepareStatement(query);
                pst.setString(1, locationcombo.getSelectedItem().toString());
                rs = pst.executeQuery();
                float sumOfWeights= 0, sumOfBags = 0;
                while(rs.next())
                {
                    
                    String a = rs.getString(1);
                    String b = rs.getString(2);
                    sumOfBags = sumOfBags + Float.parseFloat(b);
                    String c = rs.getString(3);
                    String d = rs.getString(4);
                    String e = rs.getString(5);
                    sumOfWeights= sumOfWeights + Float.parseFloat(d);
                    String f = rs.getString(6);
                    String g = rs.getString(7);
                    String none = "-";
                    model.addRow(new Object[]{a, none, b, c, d, sumOfWeights, f,g, sumOfBags});
                }
//                jTable1.setModel(model);
//                jTable1.setAutoCreateRowSorter(true);
//                jTable1.getRowSorter().toggleSortOrder(7);
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }
    private void articlecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articlecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_articlecomboActionPerformed

    private void showBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtn2ActionPerformed
        // TODO add your handling code here:
        if (yearBox.getSelectedItem().toString().equals("None") || monthBox.getSelectedItem().toString().equals("None")) {
            return;
        }
        
        article = articlecombo.getSelectedItem().toString();
        if (article.equals("None"))
        {
            return;
        }
        
        fillAll2();
    }//GEN-LAST:event_showBtn2ActionPerformed

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        // TODO add your handling code here:
        article = articlecombo.getSelectedItem().toString();
        if (article.equals("None"))
        {
            return;
        }

        fillAll();
    }//GEN-LAST:event_showBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat(articlecombo.getSelectedItem().toString() + ", " + monthBox.getSelectedItem().toString() + " - " + yearBox.getSelectedItem().toString());
        try {
            jTable1.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtn3ActionPerformed
        // TODO add your handling code here:
        if (yearBox1.getSelectedItem().toString().equals("None") || monthBox1.getSelectedItem().toString().equals("None")) {
            return;
        }
        
       
        if (locationcombo.getSelectedItem().toString().equals("None"))
        {
            return;
        }
        
        fillAll3();
        
    }//GEN-LAST:event_showBtn3ActionPerformed
    public void LoadLocation()
    {
         try{
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                Statement stmt = con.createStatement();
                String query;

                rs = stmt.executeQuery("SELECT distinct(location) FROM Product_details_table");
               
                while(rs.next()){
                    String s=rs.getString(1);
                    locationcombo.addItem(s);
                }
                
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
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
            java.util.logging.Logger.getLogger(StockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox articlecombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> locationcombo;
    private javax.swing.JComboBox monthBox;
    private javax.swing.JComboBox monthBox1;
    private javax.swing.JButton showBtn;
    private javax.swing.JButton showBtn2;
    private javax.swing.JButton showBtn3;
    private javax.swing.JComboBox yearBox;
    private javax.swing.JComboBox yearBox1;
    // End of variables declaration//GEN-END:variables
}

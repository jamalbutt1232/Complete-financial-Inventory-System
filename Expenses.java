/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author JAMAL
 */
public class Expenses extends javax.swing.JFrame {

    /**
     * Creates new form Expenses
     */
    public Expenses() {
        initComponents();
        LoadCombo();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        costfield = new javax.swing.JTextField();
        expensescombo = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Expenses");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Cost");

        expensescombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expensescombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Wages", "Furniture", "Food", "Rent", "Bill", "Juices", "Tea" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Change");
        jButton2.setAlignmentY(0.0F);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(costfield)
                    .addComponent(expensescombo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(162, 162, 162))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expensescombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costfield, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
    String user="l134088";
    String pass="sofabulous12";

    public void LoadCombo()
    {
     
         try{
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                Statement stmt = con.createStatement();
                String query;

                rs = stmt.executeQuery("SELECT DISTINCT name FROM Expenses_table");
               
                while(rs.next()){
                    String s=rs.getString(1);
                    expensescombo.addItem(s);
                }
             
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
        
    
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String expense = JOptionPane.showInputDialog(null,
                        "New expense", null);
        
        expensescombo.addItem(expense);
        expensescombo.setSelectedItem(expense);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        float advanc_cost= 0 , curr_cost =0; boolean ifAdExist = false;
        
        try{
            ResultSet rs=null;
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pass);

            Statement stmt = con.createStatement();
            String query;
            query= ("SELECT ad_cost from ad_cost_table where name = ?");
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, expensescombo.getSelectedItem().toString());
            rs =pst.executeQuery();
            if(rs.next()){
                    String s=rs.getString(1);
                    advanc_cost= Float.parseFloat(s);
                    ifAdExist = true;
            }
            if(ifAdExist ==true)
            {
                if (advanc_cost > Float.parseFloat(costfield.getText()))
                {
                    advanc_cost = advanc_cost  - Float.parseFloat(costfield.getText());
                    query= "UPDATE  ad_cost_table SET ad_cost = ? WHERE name = ?";
                    pst=con.prepareStatement(query);

                    pst.setFloat(1, advanc_cost);
                    pst.setString(2,  expensescombo.getSelectedItem().toString());

                    pst.executeUpdate();
                    
                    //Update cash flow
//                    query = ("UPDATE cash_table SET cash=cash - ? where type=?");
//                    pst = con.prepareStatement(query);
//
//                    // pst.setInt(1, id);
//                    pst.setFloat(1, Float.parseFloat(costfield.getText()));
//                    pst.setString(2, "cash");
//
//                    pst.execute();

                    // finish cash flow
                    
                }
                else if (advanc_cost < Float.parseFloat(costfield.getText()))
                {
                    curr_cost = Float.parseFloat(costfield.getText()) - advanc_cost;
                    query= "UPDATE  ad_cost_table SET ad_cost = ? WHERE name = ?";
                    pst=con.prepareStatement(query);

                    pst.setFloat(1, curr_cost);
                    pst.setString(2,  expensescombo.getSelectedItem().toString());

                    pst.executeUpdate();
                    
                    //Update cash flow
                    query = ("UPDATE cash_table SET cash=cash - ? where type=?");
                    pst = con.prepareStatement(query);

                    // pst.setInt(1, id);
                    pst.setFloat(1, curr_cost);
                    pst.setString(2, "cash");

                    pst.execute();

                    // finish cash flow
                }
                else{//equal to zero
                    query= "UPDATE  ad_cost_table SET ad_cost = ? WHERE name = ?";
                    pst=con.prepareStatement(query);

                    pst.setFloat(1, Float.parseFloat(costfield.getText()));
                    pst.setString(2,  expensescombo.getSelectedItem().toString());

                    pst.executeUpdate();
                    //Update cash flow
                    query = ("UPDATE cash_table SET cash=cash - ? where type=?");
                    pst = con.prepareStatement(query);

                    // pst.setInt(1, id);
                    pst.setFloat(1, Float.parseFloat(costfield.getText()));
                    pst.setString(2, "cash");

                    pst.execute();

                    // finish cash flow
                }
            }
            else
            {
                query= "INSERT INTO Expenses_table(date,name,cost)VALUES(?,?,?)";
                pst=con.prepareStatement(query);

                pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
                pst.setString(2, expensescombo.getSelectedItem().toString());
                pst.setString(3, costfield.getText());

                pst.execute();
                
                    //Update cash flow
                query = ("UPDATE cash_table SET cash=cash - ? where type=?");
                pst = con.prepareStatement(query);

                // pst.setInt(1, id);
                pst.setFloat(1, Float.parseFloat(costfield.getText()));
                pst.setString(2, "cash");

                pst.execute();

                // finish cash flow
            }
            
            JOptionPane.showMessageDialog(null, "Expense added successfully");

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField costfield;
    private javax.swing.JComboBox<String> expensescombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

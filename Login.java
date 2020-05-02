/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jamal
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String dbURL=null;
    public Login() {
        Login.this.setResizable(false);
        initComponents();
        
    }
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
    //String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
        String user="l134088";
    String pass="sofabulous12";


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernamefield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordfield = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 255));
        setForeground(new java.awt.Color(204, 51, 255));
        setLocation(new java.awt.Point(500, 225));
        setMinimumSize(new java.awt.Dimension(375, 325));
        setPreferredSize(new java.awt.Dimension(375, 325));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Account Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password");

        passwordfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordfieldKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passwordfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        ResultSet rs=null;
        Class.forName(driver);
        Connection con=DriverManager.getConnection(url,user,pass);
        // Step 2.B: Creating JDBC Statement 
        Statement stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT username,password FROM login_table where username='"+usernamefield.getText().toString()+"' ");
        String username=null;String password=null;
        if (rs.next() ) {
           String passwordfielddata = passwordfield.getText().toString();
           password=rs.getString("password");
           if(password.equals(passwordfielddata))
           {
            JOptionPane.showMessageDialog(this,"Welcome" );
            this.setVisible(false);
            Home frame = new Home();
            frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
            frame.pack();
            frame.setVisible(true);
           }
            else
                {
                    JOptionPane.showMessageDialog(this,"Wrong password" );
                }
        } 
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Bye1" );
            JOptionPane.showMessageDialog(this,e.toString() );
        }   
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void passwordfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordfieldKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try{
            ResultSet rs=null;
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pass);
            // Step 2.B: Creating JDBC Statement 
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT username,password FROM login_table where username='"+usernamefield.getText()+"' ");
            String username=null;String password=null;
            if (rs.next() ) {
               String passwordfielddata = passwordfield.getText();
               password=rs.getString("password");
               if(password.equals(passwordfielddata))
               {
                JOptionPane.showMessageDialog(this,"Welcome" );
                this.setVisible(false);
                Home frame = new Home();
                frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
               }
                else
                    {
                        JOptionPane.showMessageDialog(this,"Wrong password" );
                    }
            } 

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,"Bye1" );
                JOptionPane.showMessageDialog(this,e.toString() );
            }   
        }
    }//GEN-LAST:event_passwordfieldKeyPressed
    
   

    public static void main(String args[]) {
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passwordfield;
    private javax.swing.JTextField usernamefield;
    // End of variables declaration//GEN-END:variables
}

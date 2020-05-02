/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;

import com.sun.glass.ui.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Vector;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jamal
 */

public class Purchasing extends javax.swing.JFrame {

    /**
     * Creates new form GenerateABill
     */
    
        boolean ifDriver= false;
        String customer;
        Vector<String> Ano = null;
        Vector<String> size = null;
        Vector<Integer> quantity = null;
        Vector<Integer> price = null;
        int j;
        String dbURL=null;
        boolean flag1=false;
        int tp=0;
        int dues=0;
        int due=0;
        int coh=0;
        int cq=0;
        boolean flag = false;
    public Purchasing() {
        Purchasing.this.setResizable(false);
        initComponents();
       
        
        init();
         LoadLocation();
        
    }
    private Timer blinkTimer;
    private boolean blinked;
    private Color blinkColour = Color.black;
    private Color foreground;
    
   
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
    public void init()
    {
        Ano = new Vector<>();
        size = new Vector<>();
        quantity = new Vector<>();
        price = new Vector<>();
        j=0;
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
        String user="l134088";
        String pass="sofabulous12";

        
        
         try{
                ResultSet rs=null;
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                // Step 2.B: Creating JDBC Statement 
                Statement stmt = con.createStatement();
                String query;

                rs = stmt.executeQuery("SELECT distinct name FROM Supplier_table");
               
                while(rs.next()){
                    String s=rs.getString(1);
                    customernamefield.addItem(s);
                }
                rs = stmt.executeQuery("SELECT distinct name FROM Product_table");
                while(rs.next()){
                    String s=rs.getString(1);
                    articlenocombo.addItem(s);
                }
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }
    public int sums(Vector<Integer> v)
    {
        int sum=0;
        for (int i=0;i<v.size();i++)
        {
            sum=sum+v.get(i);
        }
        return sum;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pricerate = new javax.swing.JTextField();
        totalmun = new javax.swing.JTextField();
        customernamefield = new javax.swing.JComboBox<>();
        articlenocombo = new javax.swing.JComboBox<>();
        sizecombo = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        totalbagsfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalweightkg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalamountf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sewingpercostfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalsewingcostfield = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        loadingpercostfield = new javax.swing.JTextField();
        totalloadingcostfield = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bardanacostfield = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalinloadingcostfield = new javax.swing.JTextField();
        inloadingcostfield = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        brokercomamount = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        totalafterfield = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        perbagfinalcostfield = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        driverDetailsButton = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        totalbardanafield = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        carrentfield = new javax.swing.JTextField();
        brokerfield = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        locationcombo = new javax.swing.JComboBox<>();
        changearticleno = new javax.swing.JButton();
        changesize = new javax.swing.JButton();
        brokercombo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        perbagfinalcostfieldkg = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        locationChange = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Purchasing");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Supplier name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Article no");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Size");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Price Rate per Kg");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total weight in MUN");

        pricerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pricerateMouseClicked(evt);
            }
        });
        pricerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricerateActionPerformed(evt);
            }
        });
        pricerate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pricerateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pricerateKeyReleased(evt);
            }
        });

        totalmun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalmunActionPerformed(evt);
            }
        });

        customernamefield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customernamefield.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        customernamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customernamefieldActionPerformed(evt);
            }
        });

        articlenocombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        articlenocombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        articlenocombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                articlenocomboActionPerformed(evt);
            }
        });

        sizecombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sizecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "25\t", "50" }));
        sizecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizecomboActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Change");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total Bags");

        totalbagsfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalbagsfieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                totalbagsfieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                totalbagsfieldMouseExited(evt);
            }
        });
        totalbagsfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalbagsfieldActionPerformed(evt);
            }
        });
        totalbagsfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalbagsfieldKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total weight in Kgs");

        totalweightkg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalweightkgActionPerformed(evt);
            }
        });
        totalweightkg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totalweightkgKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Total Amount");

        totalamountf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalamountfActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Sewing Per cost");

        sewingpercostfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sewingpercostfieldActionPerformed(evt);
            }
        });
        sewingpercostfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sewingpercostfieldKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total Sewing cost");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Loading Per cost");

        loadingpercostfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loadingpercostfieldKeyPressed(evt);
            }
        });

        totalloadingcostfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalloadingcostfieldActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Total Loading cost");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Bardana cost");

        bardanacostfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bardanacostfieldKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Un-Loading Per cost");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Total Un-Loading cost");

        inloadingcostfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inloadingcostfieldKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Broker commission");

        brokercomamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokercomamountActionPerformed(evt);
            }
        });

        jLabel18.setText("=");

        totalafterfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalafterfieldActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Total");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Per Mun Bag with rice cost:");

        driverDetailsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        driverDetailsButton.setText("Driver Details");
        driverDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverDetailsButtonActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Total Bardana cost");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Car rent");

        brokerfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokerfieldActionPerformed(evt);
            }
        });
        brokerfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                brokerfieldKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Location:");

        locationcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));

        changearticleno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changearticleno.setText("Change");
        changearticleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changearticlenoActionPerformed(evt);
            }
        });

        changesize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changesize.setText("Change");
        changesize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changesizeActionPerformed(evt);
            }
        });

        brokercombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Percentage", "Rs." }));
        brokercombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brokercomboActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Per Kg Bag with rice cost:");

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        locationChange.setText("Change");
        locationChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationChangeActionPerformed(evt);
            }
        });

        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(413, 413, 413)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel24)
                .addGap(23, 23, 23)
                .addComponent(perbagfinalcostfieldkg, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(customernamefield, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(driverDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(105, 105, 105)
                        .addComponent(articlenocombo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(changearticleno))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(143, 143, 143)
                        .addComponent(sizecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(changesize))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(totalbagsfield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(38, 38, 38)
                        .addComponent(totalweightkg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(totalmun, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(51, 51, 51)
                        .addComponent(pricerate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(75, 75, 75)
                        .addComponent(totalamountf, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(79, 79, 79)
                        .addComponent(bardanacostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(40, 40, 40)
                        .addComponent(totalbardanafield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(70, 70, 70)
                        .addComponent(sewingpercostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(58, 58, 58)
                        .addComponent(totalsewingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(65, 65, 65)
                        .addComponent(loadingpercostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(53, 53, 53)
                        .addComponent(totalloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(40, 40, 40)
                        .addComponent(inloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(28, 28, 28)
                        .addComponent(totalinloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(123, 123, 123)
                        .addComponent(carrentfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(49, 49, 49)
                                .addComponent(brokercombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(brokerfield))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(145, 145, 145)
                                .addComponent(totalafterfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(brokercomamount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel20)
                        .addGap(22, 22, 22)
                        .addComponent(perbagfinalcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel23)
                        .addGap(26, 26, 26)
                        .addComponent(locationcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(locationChange)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addComponent(customernamefield, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(driverDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(articlenocombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changearticleno)
                            .addComponent(jLabel10)
                            .addComponent(sewingpercostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(sizecombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changesize)
                            .addComponent(jLabel11)
                            .addComponent(totalsewingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(totalbagsfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(loadingpercostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(totalweightkg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(totalloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(totalmun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(inloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(pricerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(totalinloadingcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(totalamountf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(carrentfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(bardanacostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(brokercombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(brokercomamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addComponent(brokerfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(totalbardanafield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalafterfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(locationcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locationChange))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(perbagfinalcostfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(perbagfinalcostfieldkg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void customernamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customernamefieldActionPerformed
        // TODO add your handling code here:
        customer=customernamefield.getSelectedItem().toString();
        if(!customernamefield.getSelectedItem().toString().equals("None"))
        {
            customernamefield.setEnabled(false);
        }
        if(customernamefield.getSelectedItem().toString().equals("Add New"))
        {
            JTextField xField = new JTextField(20);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Customer Name:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter the New Customer Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) 
            {
                customer=xField.getText();
            }
        } 
    }//GEN-LAST:event_customernamefieldActionPerformed

    private void articlenocomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_articlenocomboActionPerformed
        // TODO add your handling code here:
        if (sizecombo.getItemCount()>0)
        {
            sizecombo.removeAllItems();
        }
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
            String user="l134088";
    String pass="sofabulous12";

        Connection con = null;

         try{
            ResultSet rs=null;
            Class.forName(driver);
            con=DriverManager.getConnection(url,user,pass);
            Statement stmt = con.createStatement();
            String query = "SELECT distinct weight FROM Product_details_table WHERE name=?";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1,articlenocombo.getSelectedItem().toString() );
            rs =pst.executeQuery();
   
            while(rs.next()){
                    String s=rs.getString(1);
                    sizecombo.addItem(s);
                }
         }
         catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e.toString() );                    
        }
    }//GEN-LAST:event_articlenocomboActionPerformed

    private void sizecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizecomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizecomboActionPerformed

    private void pricerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricerateActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_pricerateActionPerformed

    private void totalmunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalmunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalmunActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        customernamefield.setEnabled(true);
        String changeName = JOptionPane.showInputDialog(null,
        "New name", null);
        customernamefield.addItem(changeName);
        customernamefield.setSelectedItem(changeName);
        flag =true;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void totalamountfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalamountfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalamountfActionPerformed

    private void totalloadingcostfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalloadingcostfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalloadingcostfieldActionPerformed
        JTextField name=new JTextField();
        JTextField vehicleNo=new JTextField();
        JTextField biltiNo=new JTextField();
        String DriverDetailsTmp;
    private void driverDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverDetailsButtonActionPerformed
        ifDriver =true;
        
        Object[] fields={
            "Driver Name",name,
            "Vehcile no",vehicleNo,
            "Bilti no",biltiNo
        };
        
        JOptionPane.showConfirmDialog(null, fields, "Driver details",JOptionPane.OK_CANCEL_OPTION);
        
    }//GEN-LAST:event_driverDetailsButtonActionPerformed

    private void totalbagsfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalbagsfieldActionPerformed
            // TODO add your handling code here:
           
    }//GEN-LAST:event_totalbagsfieldActionPerformed

    private void totalbagsfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalbagsfieldMouseClicked
  
    }//GEN-LAST:event_totalbagsfieldMouseClicked

    private void totalbagsfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalbagsfieldKeyPressed
        // TODO add your handling code here:
   
     
    }//GEN-LAST:event_totalbagsfieldKeyPressed

    private void pricerateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricerateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
            float totalmunfloat = Float.parseFloat(totalmun.getText());
            float priceratefloat = Float.parseFloat(pricerate.getText());        
            float totalfinalrate = totalmunfloat * priceratefloat * 40;
            String totalfinalrateString ;
            totalfinalrateString = String.valueOf(totalfinalrate);
            totalamountf.setText(totalfinalrateString);          
        }        
    }//GEN-LAST:event_pricerateKeyPressed

    private void totalbagsfieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalbagsfieldMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_totalbagsfieldMouseEntered

    private void totalbagsfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalbagsfieldMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_totalbagsfieldMouseExited

    private void pricerateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pricerateKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pricerateKeyReleased

    private void pricerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pricerateMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_pricerateMouseClicked

    private void totalweightkgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalweightkgActionPerformed
    }//GEN-LAST:event_totalweightkgActionPerformed

    private void totalweightkgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalweightkgKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
         float munweight = Float.parseFloat(totalweightkg.getText());
         munweight = munweight/40;
         String totalmunweight ;
         totalmunweight = String.valueOf(munweight);
         totalmun.setText(totalmunweight);
        }
    }//GEN-LAST:event_totalweightkgKeyPressed

    private void sewingpercostfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sewingpercostfieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
         float sewingpercost = Float.parseFloat(sewingpercostfield.getText());
         int totalbags = Integer.parseInt(totalbagsfield.getText());
         sewingpercost = sewingpercost* totalbags;
         String totalsewingcost ;
         totalsewingcost = String.valueOf(sewingpercost);
         totalsewingcostfield.setText(totalsewingcost);
        }
    }//GEN-LAST:event_sewingpercostfieldKeyPressed

    private void loadingpercostfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loadingpercostfieldKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
         float loadingpercost = Float.parseFloat(loadingpercostfield.getText());
         int totalbags = Integer.parseInt(totalbagsfield.getText());
         loadingpercost = loadingpercost* totalbags;
         String totalloadingcost ;
         totalloadingcost = String.valueOf(loadingpercost);
         totalloadingcostfield.setText(totalloadingcost);
        }
        
        
    }//GEN-LAST:event_loadingpercostfieldKeyPressed

    private void inloadingcostfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inloadingcostfieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
         float inloadingpercost = Float.parseFloat(inloadingcostfield.getText());
         int totalbags = Integer.parseInt(totalbagsfield.getText());
         inloadingpercost = inloadingpercost* totalbags;
         String intotalloadingcost ;
         intotalloadingcost = String.valueOf(inloadingpercost);
         totalinloadingcostfield.setText(intotalloadingcost);
        }
    }//GEN-LAST:event_inloadingcostfieldKeyPressed

    private void bardanacostfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bardanacostfieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
         float bardanacost = Float.parseFloat(bardanacostfield.getText());
         int totalbags = Integer.parseInt(totalbagsfield.getText());
         bardanacost = bardanacost* totalbags;
         String totalbardanacost ;
         totalbardanacost = String.valueOf(bardanacost);
         totalbardanafield.setText(totalbardanacost);
        }
    }//GEN-LAST:event_bardanacostfieldKeyPressed
    public void ChangeDriver()
    {
        driverDetailsButton.setBackground(Color.yellow);    
        driverDetailsButton.setForeground(Color.BLUE);
        driverDetailsButton.setFont(new Font("Arial", Font.BOLD, 14));

        
    }
    private void brokerfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brokerfieldKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      // Enter was pressed. Your code goes here.
        if(name.getText().isEmpty())
        {
            ChangeDriver();
            
        }
      
         float totalamount =  0;
         
         if (totalamountf.getText().isEmpty())
         {
             totalamount =  0;
       
             totalamountf.setText("0");
         }
         else
         {
           totalamount =  Float.parseFloat(totalamountf.getText());
         }
         float totalbardana = 0;
         if (totalbardanafield.getText().isEmpty())
         {
             totalbardana =  0;totalbardanafield.setText("0");bardanacostfield.setText("0");
         }
         else
         {
             totalbardana = Float.parseFloat(totalbardanafield.getText());  
         }
         float totalsewing = 0;
         
         if (totalsewingcostfield.getText().isEmpty())
         {
             totalsewing =  0;totalsewingcostfield.setText("0");sewingpercostfield.setText("0");
         }
         else
         {
             totalsewing = Float.parseFloat(totalsewingcostfield.getText());
         }
         float totalinloadingcost = 0;
         if (totalinloadingcostfield.getText().isEmpty())
         {
             totalinloadingcost =  0;totalinloadingcostfield.setText("0");inloadingcostfield.setText("0");
         }
         else
         {
            totalinloadingcost = Float.parseFloat(totalinloadingcostfield.getText());
         }
         float totalonloadingcost = 0;
    
         if (totalloadingcostfield.getText().isEmpty())
         {
             totalonloadingcost =  0;totalloadingcostfield.setText("0");loadingpercostfield.setText("0");
         }
         else
         {
              totalonloadingcost = Float.parseFloat(totalloadingcostfield.getText());         
         }
         
         float carrent = 0;
    
         if (carrentfield.getText().isEmpty())
         {
             carrent =  0;carrentfield.setText("0");
         }
         else
         {
             carrent = Float.parseFloat(carrentfield.getText());     
         }
         float totalm =0;
         totalm =Float.parseFloat(totalmun.getText());
         
         float beforeBrokercom = totalamount + totalbardana + totalsewing + totalinloadingcost + totalonloadingcost+
                 carrent;
         float brokerMoney=0 , amountAfterBrokerCom=0,perbagfinalcost= 0 ; String a ;
         if (brokercombo.getSelectedItem().toString().equalsIgnoreCase("Rs."))
         {
             brokerMoney = Float.parseFloat(brokerfield.getText());    
             float totalbagsf = Float.parseFloat(totalbagsfield.getText());
             brokerMoney = brokerMoney * totalbagsf ;
         
             amountAfterBrokerCom= beforeBrokercom + brokerMoney ;
             
             perbagfinalcost = amountAfterBrokerCom / totalm;
        
             a = String.valueOf(brokerMoney);
             brokercomamount.setText(a);
         
         }
         else
         {
              brokerMoney = totalamount + totalbardana + totalsewing + totalinloadingcost + totalonloadingcost+
                 carrent;
              float brokerPercent = Float.parseFloat(brokerfield.getText());
              brokerPercent = brokerPercent / 100 ;
              brokerPercent = brokerMoney * brokerPercent ;
              amountAfterBrokerCom= beforeBrokercom + brokerPercent ;
              perbagfinalcost = amountAfterBrokerCom / totalm;
              a = String.valueOf(brokerPercent);
              brokercomamount.setText(a);   
          
         }
   
         a = String.valueOf(amountAfterBrokerCom);
         totalafterfield.setText(a);
         
         a = String.valueOf(perbagfinalcost);
         perbagfinalcostfield.setText(a);
         
         //perbagfinalcostfieldkg
         a = String.valueOf(perbagfinalcost/40);
         perbagfinalcostfieldkg.setText(a);
         
        }
    }//GEN-LAST:event_brokerfieldKeyPressed
    public void SaveForProfitLoss()
    {
        boolean ifDatainProfitLossTable = false;
        try {
        ResultSet rs = null;
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();

        String query = null;
        PreparedStatement pst = null;
        
        query = "SELECT TOP 1 date FROM pl_table ORDER BY date DESC";

        java.util.Date d = null;
        rs = stmt.executeQuery(query);
        if(rs.next())
        {
            ifDatainProfitLossTable = true;
            d = rs.getDate("date");
            JOptionPane.showMessageDialog(null, d);
        }
        String strMonthOfTable = "0";
        String strYearOfTable = "0" ;
        if(ifDatainProfitLossTable == true)
        {
            SimpleDateFormat extractMonthOfTable = new SimpleDateFormat("MM"); // two digit numerical represenation
            strMonthOfTable= extractMonthOfTable.format(d);                 
            SimpleDateFormat extractYearOfTable = new SimpleDateFormat("YYYY"); // four digit numerical represenation
            strYearOfTable= extractYearOfTable.format(d);     
        }
        

        int monthOfTable = Integer.parseInt(strMonthOfTable);
        int yearOfTable = Integer.parseInt(strYearOfTable);

        java.util.Date now = new java.util.Date();
        SimpleDateFormat extractMonth = new SimpleDateFormat("MM"); // two digit numerical represenation
        String strMonth = extractMonth.format(now);     
        SimpleDateFormat extractYear = new SimpleDateFormat("YYYY"); // four digit numerical represenation
        String strYear = extractYear.format(now);     

        int todaysmonth = Integer.parseInt(strMonth);
        int todaysyear = Integer.parseInt(strYear);
        if (ifDatainProfitLossTable == true)
        {
            if (monthOfTable == todaysmonth && yearOfTable == todaysyear)
            {
                query= "UPDATE  pl_table SET [ordered] =[ordered] + ?  WHERE Year(date)='"+todaysyear+"' AND Month(date)='"+todaysmonth+"'";
                pst=con.prepareStatement(query);

                pst.setFloat(1, Float.parseFloat(totalamountf.getText()));

                pst.executeUpdate();

            }
            else if (todaysmonth > monthOfTable && ifDatainProfitLossTable ==true  )
            {
                float old_weight_p = 0;
                query= "SELECT sum(ordered) as previousOrdered from  pl_table";
                pst = con.prepareStatement(query);
                rs = pst.executeQuery();

                if (rs.next()) {

                    String s = rs.getString("previousOrdered");

                    old_weight_p = Float.parseFloat(s);
                }
                
                
                query= "INSERT INTO  pl_table (date , ordered , old_weight)  VALUES(?,?,?)";

                pst = con.prepareStatement(query);
                pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
                pst.setString(2, totalamountf.getText());
                pst.setFloat(3, old_weight_p);
                pst.execute();

            }
        }else
        {
        
            query= "INSERT INTO  pl_table (date , ordered, old_weight)  VALUES(?,?,?)";

            pst = con.prepareStatement(query);
            pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
            pst.setString(2, totalamountf.getText());
            pst.setFloat(3, Float.parseFloat("0"));
            pst.execute();
        }
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }
   
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
    String user="l134088";
    String pass="sofabulous12";


    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        

         String customername = customernamefield.getSelectedItem().toString();
          float totalamount =  0;
         
         if (totalamountf.getText().isEmpty())
         {
             totalamount =  0;
       
             totalamountf.setText("0");
         }
         else
         {
           totalamount =  Float.parseFloat(totalamountf.getText());
         }
         float totalbardana = 0;
         if (totalbardanafield.getText().isEmpty())
         {
             totalbardana =  0;totalbardanafield.setText("0");bardanacostfield.setText("0");
         }
         else
         {
             totalbardana = Float.parseFloat(totalbardanafield.getText());  
         }
         float totalsewing = 0;
         
         if (totalsewingcostfield.getText().isEmpty())
         {
             totalsewing =  0;totalsewingcostfield.setText("0");sewingpercostfield.setText("0");
         }
         else
         {
             totalsewing = Float.parseFloat(totalsewingcostfield.getText());
         }
         float totalinloadingcost = 0;
         if (totalinloadingcostfield.getText().isEmpty())
         {
             totalinloadingcost =  0;totalinloadingcostfield.setText("0");inloadingcostfield.setText("0");
         }
         else
         {
            totalinloadingcost = Float.parseFloat(totalinloadingcostfield.getText());
         }
         float totalonloadingcost = 0;
    
         if (totalloadingcostfield.getText().isEmpty())
         {
             totalonloadingcost =  0;totalloadingcostfield.setText("0");loadingpercostfield.setText("0");
         }
         else
         {
              totalonloadingcost = Float.parseFloat(totalloadingcostfield.getText());         
         }
         
         float carrent = 0;
    
         if (carrentfield.getText().isEmpty())
         {
             carrent =  0;carrentfield.setText("0");
         }
         else
         {
             carrent = Float.parseFloat(carrentfield.getText());     
         }
         float totalm =0;
         int totalbags = Integer.parseInt(totalbagsfield.getText());
         String weightinString= sizecombo.getSelectedItem().toString();
         float weight = Float.parseFloat(weightinString);


         //
         float perBagBardana = Float.parseFloat(bardanacostfield.getText());
         float sewintPerBag =Float.parseFloat(sewingpercostfield.getText());
         float outloadPerBag =Float.parseFloat(loadingpercostfield.getText());
         float inloadPerBag= Float.parseFloat(inloadingcostfield.getText());
         float caRrent = Float.parseFloat(carrentfield.getText());

        //
         float remainingWeight = Float.parseFloat(totalweightkg.getText());
         float totalweightkgOriginal = remainingWeight; // initially
         

        int id=1;
         //assumed values
        String location= locationcombo.getSelectedItem().toString();
        String article_no = articlenocombo.getSelectedItem().toString();
        
        String typeOfProduct= "rice";
        String receiveamount = JOptionPane.showInputDialog(null,
        "Paying", null);
        Float receiveamountfloat = Float.parseFloat(receiveamount);
        

        try{
        ResultSet rs=null;
        Class.forName(driver);
        Connection con=DriverManager.getConnection(url,user,pass);
        // Step 2.B: Creating JDBC Statement 
        Statement stmt = con.createStatement();
        String query;
        query= "INSERT INTO Product_table(name,type)VALUES(?,?)";
        PreparedStatement pst=con.prepareStatement(query);
//        pst.setInt(1, id);
        pst.setString(1, article_no);
        pst.setString(2, typeOfProduct);
        pst.execute();
        
        float totalbagcost; float olddue,storeOldDue=0;
        if ( flag == true)
        {
            olddue= 0;storeOldDue = 0;
            totalbagcost =(totalamount - receiveamountfloat); 
        }
        else
        {
            
//           
            stmt = con.createStatement();
           
            query = "SELECT dues FROM Supplier_table WHERE name=?";
            pst=con.prepareStatement(query);
            pst.setString(1,customernamefield.getSelectedItem().toString() );
            rs =pst.executeQuery();
            String s = null;
            if(rs.next()){
                    s=rs.getString(1);     
            }   
            if(s.equals(null))
            {
                s = "0";
            }
            olddue= Float.parseFloat(s);
            storeOldDue = olddue;
            totalbagcost = olddue + (totalamount - receiveamountfloat); 

            
            
        }
        
 
        //totalbagcost =  (totalamount - receiveamountfloat); 
        
//        if(totalbagcost  > 0)
//        {
//            olddue = totalbagcost;
//        }
        //
        if(flag== true)
        {
            query =("INSERT INTO Supplier_table(name,dues,oldest_dues)VALUES(?,?,?)");        
            pst=con.prepareStatement(query);


            pst.setString(1, customernamefield.getSelectedItem().toString());
            pst.setFloat(2, totalbagcost);
            pst.setString(3, "0");
            pst.execute(); 
       
        }
        else
        {
                query= "UPDATE Supplier_table SET [dues]= ? where name=?";
                pst=con.prepareStatement(query);
                pst.setFloat(1, totalbagcost);
                pst.setString(2, customernamefield.getSelectedItem().toString());

                pst.executeUpdate();
        
        }
        //
        query= "INSERT INTO Product_details_table(name,location,quantity,weight,supplier_name,original_weight,receiving,rate,remaining_weight,date,total_cash,old_due,update_quantity)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst=con.prepareStatement(query);
        
        //pst.setInt(1,id); 
        pst.setString(1, article_no);
        pst.setString(2, location);
        pst.setInt(3, totalbags);
        pst.setFloat(4, weight);        
        pst.setString(5, customername); 
        pst.setFloat(6, remainingWeight);
        pst.setFloat(7, receiveamountfloat);         
        pst.setFloat(8, Float.parseFloat(pricerate.getText())); 
        pst.setFloat(9, remainingWeight); 
        pst.setTimestamp(10,new java.sql.Timestamp(System.currentTimeMillis()));
//        pst.setDate(10,  (sqlDate)); 
//        pst.setFloat(11,(remainingWeight* Float.parseFloat(pricerate.getText()))- receiveamountfloat );
        pst.setFloat(11,totalbagcost );
        pst.setFloat(12,storeOldDue );
        pst.setFloat(13,totalbags );
        pst.execute();

// 
        
        query =("INSERT INTO Extra_formula_table(sewing,in_load,out_load,total_bags,car_rent,bardana,broker,total_amount,oneKg)VALUES(?,?,?,?,?,?,?,?,?)");        
        pst=con.prepareStatement(query);    
//        pst.setInt(1, id);
        pst.setFloat(1, sewintPerBag );
        pst.setFloat(2, inloadPerBag);
        pst.setFloat(3, outloadPerBag);        
        pst.setInt(4, totalbags); 
        pst.setFloat(5, caRrent); 
        pst.setFloat(6, perBagBardana); 
        pst.setString(7, brokerfield.getText()); 
        pst.setString(8, totalafterfield.getText());         
        pst.setString(9, perbagfinalcostfieldkg.getText());         
        pst.execute();
        
        if(!name.getText().isEmpty())
        {
            if ( ifDriver == true)
            {
                query =("INSERT INTO Driver_detail_table(name,car_no,bilti_no,supplier_name)VALUES(?,?,?,?)");        
                pst=con.prepareStatement(query);


        //        pst.setInt(1, id);
                pst.setString(1, name.getText());
                pst.setString(2, vehicleNo.getText());
                pst.setString(3, biltiNo.getText());
                pst.setString(4, customername);
                pst.execute();
            }
        }
        //Update cash flow
        query = ("UPDATE cash_table SET cash=cash - ? where type=?");
        pst = con.prepareStatement(query);

        // pst.setInt(1, id);
        pst.setFloat(1, receiveamountfloat);
        pst.setString(2, "cash");

        pst.execute();
        
        // finish cash flow
        
        
        SaveForProfitLoss();
        JOptionPane.showMessageDialog(null, "Purchased data added successfully");

        }


        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Bye Purchasing" );
            JOptionPane.showMessageDialog(this,e.toString() );
        } 

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changearticlenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changearticlenoActionPerformed
        // TODO add your handling code here:
        String changeArticleNo = JOptionPane.showInputDialog(null,
                        "New Article name", null);
        
        articlenocombo.addItem(changeArticleNo);
        articlenocombo.setSelectedItem(changeArticleNo);

 
    }//GEN-LAST:event_changearticlenoActionPerformed

    private void changesizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changesizeActionPerformed
        // TODO add your handling code here:
        String changesize = JOptionPane.showInputDialog(null,
                        "New Size", null);
        
        sizecombo.addItem(changesize);
        sizecombo.setSelectedItem(changesize);

        
    }//GEN-LAST:event_changesizeActionPerformed

    private void brokercomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokercomboActionPerformed
        // TODO add your handling code here:
        brokercombo.setEnabled(false);
    }//GEN-LAST:event_brokercomboActionPerformed

    private void brokerfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokerfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokerfieldActionPerformed

    private void sewingpercostfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sewingpercostfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sewingpercostfieldActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           //Printing
        PrinterJob jb=PrinterJob.getPrinterJob();
        jb.setJobName("Printable");
        jb.setPrintable(new Printable(){
            public int print(Graphics g,PageFormat pf,int num){
                int cc=coh+cq;
              //  Bill1 b=new Bill1(customernamefield.getSelectedItem().toString());
                if(num>0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2=(Graphics2D)g;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(.65, 1.0);
                   //b.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
                  // b.setVisible(true);
                jPanel1.paint(g2);
              // b.dispose();
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok=jb.printDialog();
        if(ok){
            JOptionPane.showMessageDialog(null, "Printing...");
            try{
                jb.print();
                flag1=true;
                JOptionPane.showMessageDialog(null, "Printing Complete...");
            }
            catch(PrinterException ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void totalafterfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalafterfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalafterfieldActionPerformed

    private void brokercomamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brokercomamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brokercomamountActionPerformed

    private void locationChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationChangeActionPerformed
        // TODO add your handling code here:
        //locationChange
        String newLocation = JOptionPane.showInputDialog(null,
        "New Location", null);
        locationcombo.addItem(newLocation);
        locationcombo.setSelectedItem(newLocation);
        

    }//GEN-LAST:event_locationChangeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Purchasing frame=new Purchasing();
        frame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    
    public static void main(String args[]) {
   

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchasing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> articlenocombo;
    private javax.swing.JTextField bardanacostfield;
    private javax.swing.JTextField brokercomamount;
    private javax.swing.JComboBox<String> brokercombo;
    private javax.swing.JTextField brokerfield;
    private javax.swing.JTextField carrentfield;
    private javax.swing.JButton changearticleno;
    private javax.swing.JButton changesize;
    private javax.swing.JComboBox<String> customernamefield;
    private javax.swing.JButton driverDetailsButton;
    private javax.swing.JTextField inloadingcostfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField loadingpercostfield;
    private javax.swing.JButton locationChange;
    private javax.swing.JComboBox<String> locationcombo;
    private javax.swing.JTextField perbagfinalcostfield;
    private javax.swing.JTextField perbagfinalcostfieldkg;
    private javax.swing.JTextField pricerate;
    private javax.swing.JTextField sewingpercostfield;
    private javax.swing.JComboBox<String> sizecombo;
    private javax.swing.JTextField totalafterfield;
    private javax.swing.JTextField totalamountf;
    private javax.swing.JTextField totalbagsfield;
    private javax.swing.JTextField totalbardanafield;
    private javax.swing.JTextField totalinloadingcostfield;
    private javax.swing.JTextField totalloadingcostfield;
    private javax.swing.JTextField totalmun;
    private javax.swing.JTextField totalsewingcostfield;
    private javax.swing.JTextField totalweightkg;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ali_rice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Jamal
 */
public class Ledger extends javax.swing.JFrame {
    DefaultTableModel dm;

    /**
     * Creates new form Ledger
     */
    String dbURL=null;
    public Ledger() {
        Ledger.this.setResizable(false);
        initComponents();
        Loadpurchasename();
        Loadcustomername();
    }
    
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;databaseName=AliDB";
        String user="l134088";
    String pass="sofabulous12";

    
   public void Loadpurchasename()
   {
       try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                Statement stmt = con.createStatement();
                String query;
                query= "SELECT distinct name FROM Supplier_table";
                PreparedStatement pst=con.prepareStatement(query);

                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                String s=rs.getString(1);
                        purchasernamescombo.addItem(s);
                }   
            }
            catch (SQLException ex) {
                System.out.println("The following error has occured: " + ex.getMessage());
            }
            catch(Exception e)
            {

            }
   }
   public void Loadcustomername()
   {
           try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,user,pass);
                Statement stmt = con.createStatement();
                String query;
                query= "SELECT distinct name FROM Customer_table";
                PreparedStatement pst=con.prepareStatement(query);

                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                String s=rs.getString(1);
                customernamescombo.addItem(s);
                }   
            }
            catch (SQLException ex) {
                System.out.println("The following error has occured: " + ex.getMessage());
            }
            catch(Exception e)
            {
                System.out.println("The following error has occured: " + e.getMessage());
            }
   }
   public float getSum(JTable table,int colNo)
   {
            float sumForcash=0; float num;
            for(int i=0;i<table.getRowCount();i++)
            {
                if (!table.getValueAt(i, colNo).toString().equals("-"))
                {
                    num=Float.parseFloat(table.getValueAt(i, colNo).toString());
                    sumForcash=sumForcash+num;
                }

            }

            return sumForcash;	
   }
    
    
    public float getSum(int colNo)
   {
            float sumForcash=0; float num;
            for(int i=0;i<tablee.getRowCount();i++)
            {
                if (!tablee.getValueAt(i, colNo).toString().equals("-"))
                {
                    num=Float.parseFloat(tablee.getValueAt(i, colNo).toString());
                    sumForcash=sumForcash+num;
                }

            }

            return sumForcash;	
   }
    public void getreturnvalues()
    {
//        try{
//        query= "SELECT date,id,customer_name,total_bags,weight from return_table where customer_name=?";
//
//                    pst=con.prepareStatement(query);
//                    pst.setString(1, customernamescombo.getSelectedItem().toString());
//                    rs = pst.executeQuery();
//                    float sumBalance = 0;
//                    while(rs.next()){
//                            Object o[] = {
//                                rs.getString("date"),
//                                rs.getInt("id"), 
//                                rs.getString("customer_name"), 
//                                rs.getInt("total_bags"),
//                                rs.getFloat("weight"),
//                    };    
//        
//        
//        
//        }}
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,e);
//        }
    
    
    
//    }
    }
    
    public void DisplayTableRec(JTable TableSupply , String type)
    {

        if (type.equals("Seller"))
        {    
            DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Bill No", "Article", "Quantity", 
        "Rate", "Total Weight", "Bill Price", "Credit" , "Debit" , "Total"}, 0);
      

                field.setVisible(false); boolean check=true;
                dm=(DefaultTableModel) tablee.getModel();

                 try{
                        Class.forName(driver);
                        Connection con=DriverManager.getConnection(url,user,pass);

                        Statement stmt = con.createStatement();
                        DefaultTableModel tm=(DefaultTableModel)tablee.getModel();
                        tm.setRowCount(0);
                        int sum=0;boolean flag=true;
                        String empty = " ";
                        String query;
                        //
                        query= "SELECT oldest_dues from Customer_table where name=?";
      
                        PreparedStatement pst=con.prepareStatement(query);
                        pst=con.prepareStatement(query);
                        pst.setString(1, customernamescombo.getSelectedItem().toString());
                        ResultSet rs = pst.executeQuery();
                        rs = pst.executeQuery();
                        
                        if(rs.next()){
                                Object o[] = {
                                    "-",
                                    "-",
                                    "-",
                                    "-", 
                                    "-","-",
                                    "-","-",
                                    "-",
                                    rs.getFloat("oldest_dues"),
                                };
                                tm.addRow(o);
                      
                            }
                        
                        
                        
                        
                        //
                        float sumBalanceExtractReceive = 0 ;
                      
                        query= "SELECT Order_table.id, rate,total_rate, weight_ordered,quantity, product_name,transaction_date, total_rice_price,receiving,total_cash, old_due "
                                + "from Order_detail join Order_table on Order_detail.id=Order_table.id "
                                + "where Order_table.customer_name=?";

                        pst=con.prepareStatement(query);
                        pst.setString(1, customernamescombo.getSelectedItem().toString());
                        rs = pst.executeQuery();
                        float sumBalance = 0;
                        while(rs.next()){
                                Object o[] = {
                                    rs.getString("transaction_date"),
                                    rs.getInt("id"), 
                                    rs.getString("product_name"), 
                                    rs.getInt("quantity"),
                                    rs.getFloat("rate"),
                                    rs.getFloat("weight_ordered"),
                                    rs.getFloat("total_rice_price"), // Bill price
                                    rs.getFloat("total_rice_price"), // Bill price
                                    rs.getFloat("receiving"),
                                    rs.getFloat("total_rate"),
                                    
                                    
                                };
                        String stringBill = String.valueOf(o[6]); 
                        String stringReceive = String.valueOf(o[8]); 

                        sumBalance = sumBalance + Float.parseFloat(stringBill);

                        sumBalanceExtractReceive =sumBalance - Float.parseFloat(stringReceive);  
                        o[9]= sumBalanceExtractReceive;
                        if (sumBalanceExtractReceive > 0)
                        {
                            String adder = String.valueOf(o[9]);

                            o[9]=adder;
                            tm.addRow(o);
                        }else
                        {
                            String adder = String.valueOf(o[9]);

                            o[9]=adder;
                            tm.addRow(o);
                        }

                    }

//                    /////////adding returning data
//                    query= "SELECT date,id,total_bags,weight from return_table where customer_name=?";
//
//                    pst=con.prepareStatement(query);
//                    pst.setString(1, customernamescombo.getSelectedItem().toString());
//                    rs = pst.executeQuery();
//                    
//                    while(rs.next()){
//                            Object o[] = {
//                                rs.getString("date"),
//                                rs.getInt("id"),"-",                       
//                                rs.getInt("total_bags"),"-",
//                                rs.getFloat("weight"),"-","-","-","-",
//                    };    
//                    tm.addRow(o);
//                    }        
//                    //////////


//                    query= "SELECT date, name,dues_paid,calculateTotal from Dues where name=? and type=? order by date";
                    query= "SELECT date,id,total_bags,weight,rate,calculateTotal from return_table where customer_name=?";

                    pst=con.prepareStatement(query);
                    pst.setString(1, customernamescombo.getSelectedItem().toString());
                    
                    rs = pst.executeQuery();

                    while(rs.next()){
                            Object o[] = {
                                rs.getString("date"),
                                rs.getString("id"),"-", rs.getFloat("total_bags"),rs.getFloat("rate"),rs.getFloat("weight"),
                                "-",
                                "-",rs.getFloat("rate")*rs.getFloat("weight"),rs.getFloat("calculateTotal"),
                            };
         
                                

//                                /sumBalanceExtractReceive
                                Float creditToCut1 = (Float) o[8];
                                sumBalanceExtractReceive=sumBalanceExtractReceive - creditToCut1;
                                Float o9Value1 = (Float) o[9];
                                if (o9Value1 > 0)
                                {
                                    String adder = String.valueOf(o[9]);//+ " db";
                                    o[9]=adder;
                                    tm.addRow(o);
                                }else
                                {
//                                    String adder = o[9]+ " db";
//                                    o[9]=adder;

                                    String adder = String.valueOf(o[9]);
                                    Float num = Float.parseFloat(adder) * -1;
                                    String numBackToStringAsNeedToAddCr = Float.toString(num);
                                    o[9]=numBackToStringAsNeedToAddCr ;
                                    o[9] = o[9];//+ " cr";
                                    tm.addRow(o);
                                }

//                                tm.addRow(o);
                        }    

                
                query= "SELECT date, name,dues_paid,calculateTotal from Dues where name=? and type=? order by date";


                pst=con.prepareStatement(query);
                pst.setString(1, customernamescombo.getSelectedItem().toString());
                pst.setString(2, type);
                rs = pst.executeQuery();

                while(rs.next()){
                        Object o[] = {
                            rs.getString("date"),
                            "-","-", "-","-","-",
                            "-",
                            "-",rs.getFloat("dues_paid"),rs.getFloat("calculateTotal"),
                        };



//                                /sumBalanceExtractReceive
                            Float creditToCut = (Float) o[8];
                            sumBalanceExtractReceive=sumBalanceExtractReceive - creditToCut;
                            Float o9Value = (Float) o[9];
                            if (o9Value > 0)
                            {
                                String adder = String.valueOf(o[9]);//+ " db";
                                o[9]=adder;
                                tm.addRow(o);
                            }else
                            {
//                                    String adder = o[9]+ " db";
//                                    o[9]=adder;

                                String adder = String.valueOf(o[9]);
                                Float num = Float.parseFloat(adder) * -1;
                                String numBackToStringAsNeedToAddCr = Float.toString(num);
                                o[9]=numBackToStringAsNeedToAddCr ;
                                o[9] = o[9];//+ " cr";
                                tm.addRow(o);
                            }

//                                tm.addRow(o);
                    }
                      
                        
                        
                        
                    tablee.setAutoCreateRowSorter(true);
                    tablee.getRowSorter().toggleSortOrder(0);
                     
 
//                    
                   float ifneededFirstRow = 0; 
                   query = "DELETE FROM Ledger_table";
                   pst=con.prepareStatement(query);
                   pst.executeUpdate();
                   float c=0;
                    TableModel tm1 = tablee.getModel();
                    for (int i = 0; i <= tm.getRowCount() -1 ; i++) {
                        
                            try{
                                rs=null;
                                Class.forName(driver);
                                con=DriverManager.getConnection(url,user,pass);
                                // Step 2.B: Creating JDBC Statement 
                                stmt = con.createStatement();

                                Object dateobject = tm.getValueAt(i, 0);
                                Object billnoobject = tm.getValueAt(i,1);
                                Object articlenoobject = tm.getValueAt(i, 2);
                                Object quantityobject = tm.getValueAt(i, 3);
                                Object rateobject = tm.getValueAt(i, 4);
                                Object totalweightobject = tm.getValueAt(i, 5);
                                Object billpriceobject = tm.getValueAt(i, 6);
                                Object debitobject = tm.getValueAt(i, 7);
                                Object creditobject = tm.getValueAt(i,8);

                                String dateobjectstring = String.valueOf(dateobject);  
                                String billnoobjectstring = String.valueOf(billnoobject);  
                                String articlenoobectstring = String.valueOf(articlenoobject);  
                                String quantityobjectstring = String.valueOf(quantityobject);  
                                String rateobjectstring = String.valueOf(rateobject);  
                                String totalweightobjectstring = String.valueOf(totalweightobject);  
                                String billpriceobjectstring = String.valueOf(billpriceobject);  
                                String debitobjectstring = String.valueOf(debitobject);  
                                String creditobjectstring = String.valueOf(creditobject);  
                                
                                if (creditobjectstring.equals("-"))
                                {
                                   Object totalbalanceobject = tm.getValueAt(i,9);
                                   String totalbalanceobjectstring = String.valueOf(totalbalanceobject);
                                   ifneededFirstRow = Float.parseFloat(totalbalanceobjectstring);
                                }
                                    
                                query= "INSERT INTO Ledger_table(date,bill_no,article_no,quantity,rate,total_weight,bill_price,debit,credit)VALUES(?,?,?,?,?,?,?,?,?)";
                                pst=con.prepareStatement(query);
                        //        pst.setInt(1, id);
                                pst.setString(1, (dateobjectstring));
                                pst.setString(2, (billnoobjectstring));
                                pst.setString(3, articlenoobectstring);
                                pst.setString(4, (quantityobjectstring));
                                pst.setString(5,(rateobjectstring));
                                pst.setString(6,(totalweightobjectstring));
                                pst.setString(7,(billpriceobjectstring));
                                pst.setString(8,(debitobjectstring));
                                pst.setString(9, (creditobjectstring));
                                pst.execute();
                            }catch(Exception e)
                            {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        
                    }

                    tm.setRowCount(0);
                    query= "SELECT date, bill_no,article_no,quantity,rate,total_weight,bill_price,debit,credit from Ledger_table order by date";
                    float sumfBalance = 0;
                    try{
                        pst=con.prepareStatement(query);
                       
                        rs = pst.executeQuery();
                        //boolean check1= false;
                        while(rs.next()){
                            Object o[] = {
                                rs.getString("date"),
                                rs.getString("bill_no"), 
                                rs.getString("article_no"), 
                                rs.getString("quantity"),
                                rs.getString("rate"),
                                rs.getString("total_weight"),
                                (rs.getString("bill_price")),
                                rs.getString("credit"),
                                (rs.getString("debit")),
                               
                                "-",
                                };
//                            if(check1 == true)
//                            {
//                                String o2Value = (String) o[2];
//                                Float temp8Value = (Float) o[7];
//                                Float temp9Value = (Float) o[8];
//
//                                if(o2Value.equalsIgnoreCase("-"))
//                                {
//                                    o[7] = temp9Value;
//                                    o[8] = temp8Value;
//
//                                }
//                            }
                            tm.addRow(o);
                           // check1=true;
                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Getting data from ledger");
                        JOptionPane.showMessageDialog(null, e);
                    }
                    
                    //Now setting data
                    c= c +ifneededFirstRow;
                    for (int i = 0; i <=tm.getRowCount() -1 ; i++) {
                        if(i ==0)
                        {
                            
                        }
                        else
                        {
                            float convertedToFloatCredit=0,convertedToFloatDebit = 0,sub=0;                     
                            Object debitObject = tm.getValueAt(i, tm.getColumnCount() -3);
                            Object creditObject = tm.getValueAt(i, tm.getColumnCount() -2);

                            String convertedToStringDebit = String.valueOf(debitObject);  
                            String convertedToStringCredit = String.valueOf(creditObject);  

                            if(convertedToStringCredit.equals("-"))
                            {
                                convertedToStringCredit  ="0"; 
                                convertedToFloatDebit =Float.parseFloat(convertedToStringDebit);  
                                convertedToFloatCredit = Float.parseFloat(convertedToStringCredit); 
                                sub = convertedToFloatDebit;
                                c = c- sub;
                            }
                            else
                            {
                                convertedToFloatDebit =Float.parseFloat(convertedToStringDebit);  
                                convertedToFloatCredit = Float.parseFloat(convertedToStringCredit); 
                                sub = convertedToFloatCredit - convertedToFloatDebit;
                                c = c+ sub;
                            }
                        }

                        
                        
                        if ( c  > 0 )
                        {
                            String convertString = Float.toString(c)+ " cr";
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);        
                        }
                        else if(c<0)
                        {
                            
                            String convertString = Float.toString(c)+ " db";
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);                               
                        }
                        else
                        {
                            String convertString = Float.toString(c);
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);                  
                        }
                        
                }
                totalfield.setText((String) tm.getValueAt(tm.getRowCount()-1, tm.getColumnCount()-1));
                /////////adding returning data
//                query= "SELECT date,id,total_bags,weight,rate from return_table where customer_name=?";
//
//                pst=con.prepareStatement(query);
//                pst.setString(1, customernamescombo.getSelectedItem().toString());
//                rs = pst.executeQuery();
//
//                while(rs.next()){
//                        Object o[] = {
//                            rs.getString("date"),
//                            rs.getString("id"),"-",                       
//                            rs.getFloat("total_bags"),rs.getFloat("rate"),
//                            rs.getFloat("weight"),"-","-","-","-",
//                };    
//                tm.addRow(o);
//                }        
//                tablee.setAutoCreateRowSorter(true);
//                tablee.getRowSorter().toggleSortOrder(0);
                
                Border blackline =  BorderFactory.createLineBorder(Color.black);
                tablee.setBorder(blackline);
//////////
                ////////////////////////////////////////////////////
                if(check ==true)
                {
                    field.setVisible(true);
                    field.setText("No record to display");
                    check=false;
                }
//                        else
//                        {
//                quanfield.setText(Integer.toString(getSum(tablee ,2)));
//                billfield.setText(Integer.toString(getSum(3))); 
//                recfield.setText(Integer.toString(getSum(4)));
//                totalfield.setText(tablee.getValueAt(tablee.getRowCount()-1, 6).toString());                            }

                 }
                 catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this,e.toString() );                    
                }
                    
            ////
        }
        else if (type.equalsIgnoreCase("Purchaser"))
        {

//            quanfield.setText("");
//            billfield.setText(""); 
//            recfield.setText("");
//            totalfield.setText("");     
        DefaultTableModel model = new DefaultTableModel(new String[]{"Date", "Bill No", "Article", "Quantity", 
        "Rate", "Total Weight", "Bill Price", "Debit" , "Credit" , "Total"}, 0);
       
            

                 try{
                        Class.forName(driver);
                        Connection con=DriverManager.getConnection(url,user,pass);

                        Statement stmt = con.createStatement();
                        DefaultTableModel tm=(DefaultTableModel)tablee.getModel();
                        tm.setRowCount(0);
                        int sum=0;boolean flag=true;
                        String empty = " ";
                        String query;
                        //
                        query= "SELECT oldest_dues from Supplier_table where name=?";
      
                        PreparedStatement pst=con.prepareStatement(query);
                        pst=con.prepareStatement(query);
                        pst.setString(1, purchasernamescombo.getSelectedItem().toString());
                        ResultSet rs = pst.executeQuery();
                        rs = pst.executeQuery();
                        
                        if(rs.next()){
                                Object o[] = {
                                    "-",
                                    "-",
                                    "-",
                                    "-", 
                                    "-","-",
                                    "-","-",
                                    "-",
                                    rs.getFloat("oldest_dues"),
                                };
                                tm.addRow(o);
                      
                            }
                        //
                        float sumBalanceExtractReceive = 0 ;
                        query= "SELECT id,name, original_weight, rate,quantity, date, original_weight,receiving,total_cash from Product_details_table where supplier_name=? order by date";
      

                        pst=con.prepareStatement(query);
                        pst.setString(1, purchasernamescombo.getSelectedItem().toString());
                        rs = pst.executeQuery();
                        float sumBalance = 0;
                        while(rs.next()){
                                Object o[] = {
                                    rs.getString("date"),
                                    rs.getInt("id"), 
                                    rs.getString("name"), 
                                    rs.getInt("quantity"),
                                    rs.getFloat("rate"),
                                    rs.getFloat("original_weight"),
                                    (rs.getFloat("original_weight"))*rs.getFloat("rate"), // Bill price
                                    (rs.getFloat("original_weight"))*rs.getFloat("rate"), // Bill price
                                    rs.getFloat("receiving"),
                                    rs.getFloat("total_cash"),
                                    
                                    
                                };
                                String stringBill = String.valueOf(o[6]); 
                                String stringReceive = String.valueOf(o[8]); 
                                
                                sumBalance = sumBalance + Float.parseFloat(stringBill);
                                
                                sumBalanceExtractReceive =sumBalance - Float.parseFloat(stringReceive);  
                                o[9]= sumBalanceExtractReceive;
                                if (sumBalanceExtractReceive > 0)
                                {
                                    String adder = String.valueOf(o[9]);
//                                    String adder = o[9]+ " db";
                                    o[9]=adder;
                                    tm.addRow(o);
                                }else
                                {
                                    String adder = String.valueOf(o[9]);
//                                    String adder = o[9]+ " cr";
                                    o[9]=adder;
                                    tm.addRow(o);
                                }
                                
                            }
                        
                                                //
                    query= "SELECT date,id,total_bags,weight,rate,calculateTotal from purchase_return_table where customer_name=?";

                    pst=con.prepareStatement(query);
                    pst.setString(1, purchasernamescombo.getSelectedItem().toString());
                    
                    rs = pst.executeQuery();

                    while(rs.next()){
                            Object o[] = {
                                rs.getString("date"),
                                rs.getString("id"),"-", rs.getFloat("total_bags"),rs.getFloat("rate"),rs.getFloat("weight"),
                                "-",
                                "-",rs.getFloat("rate")*rs.getFloat("weight"),rs.getFloat("calculateTotal"),
                            };

//                                /sumBalanceExtractReceive
                                Float creditToCut1 = (Float) o[8];
                                sumBalanceExtractReceive=sumBalanceExtractReceive - creditToCut1;
                                Float o9Value1 = (Float) o[9];
                                if (o9Value1 > 0)
                                {
                                    String adder = String.valueOf(o[9]);//+ " db";
                                    o[9]=adder;
                                    tm.addRow(o);
                                }else
                                {
//                                    String adder = o[9]+ " db";
//                                    o[9]=adder;

                                    String adder = String.valueOf(o[9]);
                                    Float num = Float.parseFloat(adder) * -1;
                                    String numBackToStringAsNeedToAddCr = Float.toString(num);
                                    o[9]=numBackToStringAsNeedToAddCr ;
                                    o[9] = o[9];//+ " cr";
                                    tm.addRow(o);
                                }

//                                tm.addRow(o);
                        }    
                        ///                        
                        query= "SELECT date, name,dues_paid,calculateTotal from Dues where name=? and type=? order by date";
      

                        pst=con.prepareStatement(query);
                        pst.setString(1, purchasernamescombo.getSelectedItem().toString());
                        pst.setString(2, type);
                        rs = pst.executeQuery();

                        while(rs.next()){
                                Object o[] = {
                                    rs.getString("date"),
                                    "-","-", "-","-","-",
                                    "-","-",
                                    rs.getFloat("dues_paid"),rs.getFloat("calculateTotal"),
                                };
//                                /sumBalanceExtractReceive
                                Float creditToCut = (Float) o[8];
                                sumBalanceExtractReceive=sumBalanceExtractReceive - creditToCut;
                                Float o9Value = (Float) o[9];
                                if (o9Value > 0)
                                {
                                    String adder = String.valueOf(o[9]);//+ " db";
                                    o[9]=adder;
                                    tm.addRow(o);
                                }else
                                {
//                                    String adder = o[9]+ " db";
//                                    o[9]=adder;
                                    
                                    String adder = String.valueOf(o[9]);
                                    Float num = Float.parseFloat(adder) * -1;
                                    String numBackToStringAsNeedToAddCr = Float.toString(num);
                                    o[9]=numBackToStringAsNeedToAddCr ;
                                    o[9] = o[9];//+ " cr";
                                    tm.addRow(o);
                                }
                                
//                                tm.addRow(o);
                        }
//                        tablee.setAutoCreateRowSorter(true);
//                       tablee.getRowSorter().toggleSortOrder(0);
                     
 
//                    
                   float ifneededFirstRow = 0; 
                   query = "DELETE FROM Ledger_table";
                   pst=con.prepareStatement(query);
                   pst.executeUpdate();
                   float c=0;
                    TableModel tm1 = tablee.getModel();
                    for (int i = 0; i <= tm.getRowCount() -1 ; i++) {
                        
                            try{
                                rs=null;
                                Class.forName(driver);
                                con=DriverManager.getConnection(url,user,pass);
                                // Step 2.B: Creating JDBC Statement 
                                stmt = con.createStatement();

                                Object dateobject = tm.getValueAt(i, 0);
                                Object billnoobject = tm.getValueAt(i,1);
                                Object articlenoobject = tm.getValueAt(i, 2);
                                Object quantityobject = tm.getValueAt(i, 3);
                                Object rateobject = tm.getValueAt(i, 4);
                                Object totalweightobject = tm.getValueAt(i, 5);
                                Object billpriceobject = tm.getValueAt(i, 6);
                                Object debitobject = tm.getValueAt(i, 7);
                                Object creditobject = tm.getValueAt(i,8);

                                String dateobjectstring = String.valueOf(dateobject);  
                                String billnoobjectstring = String.valueOf(billnoobject);  
                                String articlenoobectstring = String.valueOf(articlenoobject);  
                                String quantityobjectstring = String.valueOf(quantityobject);  
                                String rateobjectstring = String.valueOf(rateobject);  
                                String totalweightobjectstring = String.valueOf(totalweightobject);  
                                String billpriceobjectstring = String.valueOf(billpriceobject);  
                                String debitobjectstring = String.valueOf(debitobject);  
                                String creditobjectstring = String.valueOf(creditobject);  
                                
                                if (creditobjectstring.equals("-"))
                                {
                                   Object totalbalanceobject = tm.getValueAt(i,9);
                                   String totalbalanceobjectstring = String.valueOf(totalbalanceobject);
                                   ifneededFirstRow = Float.parseFloat(totalbalanceobjectstring);
                                }
                                    
                                query= "INSERT INTO Ledger_table(date,bill_no,article_no,quantity,rate,total_weight,bill_price,debit,credit)VALUES(?,?,?,?,?,?,?,?,?)";
                                pst=con.prepareStatement(query);
                        //        pst.setInt(1, id);
                                pst.setString(1, (dateobjectstring));
                                pst.setString(2, (billnoobjectstring));
                                pst.setString(3, articlenoobectstring);
                                pst.setString(4, (quantityobjectstring));
                                pst.setString(5,(rateobjectstring));
                                pst.setString(6,(totalweightobjectstring));
                                pst.setString(7,(billpriceobjectstring));
                                pst.setString(8,(debitobjectstring));
                                pst.setString(9, (creditobjectstring));
                                pst.execute();
                            }catch(Exception e)
                            {
                                JOptionPane.showMessageDialog(null, e);
                            }
                        
                    }

                    tm.setRowCount(0);
                    query= "SELECT date, bill_no,article_no,quantity,rate,total_weight,bill_price,debit,credit from Ledger_table order by date ASC";
                    float sumfBalance = 0;
                    try{
                        pst=con.prepareStatement(query);
                       
                        rs = pst.executeQuery();
                        
                        while(rs.next()){
                            Object o[] = {
                                rs.getString("date"),
                                rs.getString("bill_no"), 
                                rs.getString("article_no"), 
                                rs.getString("quantity"),
                                rs.getString("rate"),
                                rs.getString("total_weight"),
                                (rs.getString("bill_price")),
                                (rs.getString("debit")),
                                rs.getString("credit"),
                                "-",
                                };
                                tm.addRow(o);

                        }
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "Getting data from ledger");
                        JOptionPane.showMessageDialog(null, e);
                    }
                    
                    //Now setting data
                    c= c +ifneededFirstRow;
                    for (int i = 0; i <=tm.getRowCount() -1 ; i++) {
                        if(i ==0)
                        {
                            
                        }
                        else
                        {
                            float convertedToFloatCredit=0,convertedToFloatDebit = 0,sub=0;                     
                            Object debitObject = tm.getValueAt(i, tm.getColumnCount() -3);
                            Object creditObject = tm.getValueAt(i, tm.getColumnCount() -2);

                            String convertedToStringDebit = String.valueOf(debitObject);  
                            String convertedToStringCredit = String.valueOf(creditObject);  

                            if(convertedToStringDebit.equals("-"))
                            {
                                convertedToStringDebit  ="0"; 
                                convertedToFloatCredit =Float.parseFloat(convertedToStringCredit);  
                                convertedToFloatDebit = Float.parseFloat(convertedToStringDebit); 
                                sub = convertedToFloatCredit;
                                c = c- sub;
                            }
                            else
                            {
                                convertedToFloatCredit =Float.parseFloat(convertedToStringCredit);  
                                convertedToFloatDebit = Float.parseFloat(convertedToStringDebit); 
                                sub = convertedToFloatDebit - convertedToFloatCredit;
                                c = c+ sub;
                            }
                        }

                        
                        
                        if ( c  > 0 )
                        {
                            String convertString = Float.toString(c)+ " db";
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);        
                        }
                        else if (c<0)
                        {
                            
                            String convertString = Float.toString(c)+ " cr";
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);                               
                        }
                        else
                        {
                            String convertString = Float.toString(c);
                            tm.setValueAt(convertString, i, tm.getColumnCount() -1);                  
                        }
                        
                }
                totalfield.setText((String) tm.getValueAt(tm.getRowCount()-1, tm.getColumnCount()-1));
                ////////////////////////////////////////////////////
                
//                        else
//                        {
//                quanfield.setText(Integer.toString(getSum(tablee ,2)));
//                billfield.setText(Integer.toString(getSum(3))); 
//                recfield.setText(Integer.toString(getSum(4)));
//                totalfield.setText(tablee.getValueAt(tablee.getRowCount()-1, 6).toString());                            }

                 }
                 catch(Exception e)
                {
                    JOptionPane.showMessageDialog(this,e.toString() );                    
                }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        field = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablee = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        purchasernamescombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        customernamescombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        totalfield = new javax.swing.JTextField();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Bill No", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(947, 502));

        field.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Bill no", "Article", "Quantity", "Rate", "Total weight", "Bill price", "Debit", "Credit", "Total"
            }
        ));
        tablee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablee);
        if (tablee.getColumnModel().getColumnCount() > 0) {
            tablee.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name:");

        purchasernamescombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        purchasernamescombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        purchasernamescombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchasernamescomboActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Purchaser");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(purchasernamescombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(purchasernamescombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Name:");

        customernamescombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customernamescombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        customernamescombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customernamescomboActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Seller");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(customernamescombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(customernamescombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel6.setText("Ledger");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(404, 404, 404)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(1213, 1213, 1213)
                    .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(767, 767, 767)
                    .addComponent(field, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        totalfield.setEditable(false);
        totalfield.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void tableeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               //Printing
        MessageFormat header = new MessageFormat(""+ ", " + purchasernamescombo.getSelectedItem().toString() );
        try {
            tablee.print(JTable.PrintMode.FIT_WIDTH, header, null);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }       
               
    }//GEN-LAST:event_jButton1ActionPerformed

    private void purchasernamescomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchasernamescomboActionPerformed
        
        //customernamescombo.setSelectedItem("Select");
      
        if(purchasernamescombo.getSelectedItem().toString().equalsIgnoreCase("Select"))
        {
            return;
        }
        if(tablee.getRowCount() >= 1)
        {
            DefaultTableModel model = (DefaultTableModel) tablee.getModel();
            model.setRowCount(0);
        }
        DisplayTableRec(tablee , "Purchaser");
        
                
    }//GEN-LAST:event_purchasernamescomboActionPerformed

    private void customernamescomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customernamescomboActionPerformed
 //       // TODO add your handling code here:
   //     purchasernamescombo.setSelectedItem("Select");
        
        if(customernamescombo.getSelectedItem().toString().equalsIgnoreCase("Select"))
        {
            return;
        }
        if(tablee.getRowCount() >= 1)
        {
            DefaultTableModel model = (DefaultTableModel) tablee.getModel();
            model.setRowCount(0);
        }
        
        DisplayTableRec(tablee , "Seller");
        
    }//GEN-LAST:event_customernamescomboActionPerformed

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
            java.util.logging.Logger.getLogger(Ledger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ledger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ledger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ledger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Ledger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customernamescombo;
    private javax.swing.JLabel field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> purchasernamescombo;
    private javax.swing.JTable table;
    private javax.swing.JTable tablee;
    private javax.swing.JTextField totalfield;
    // End of variables declaration//GEN-END:variables
}

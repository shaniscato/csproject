/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shani
 */
public class POSDAO {
    // private Connection myConn = null;
    Connection myConn = null;
    
    public boolean openConnection() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            myConn =
               DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pos?" +
                                           "user=root&password=d3rhZj!k");

            System.out.println("Connection Successful");
                return true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        /*try {
            // db parameters
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String user = "root";
            String password = "d3rhZj!k";
            // create a connection to the database
            myConn = DriverManager.getConnection(url, user, password);
            if (myConn != null){
            
                System.out.println("Connection Successful");
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connection Unsuccessful");
            
        }
        return false;*/
    }

    public void closeConnection() {
        try {
            if (myConn != null)
                myConn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void insertProductRecord(Products product) throws SQLException
    {
        String query = "insert into products (ProdID, ProdName, UnitPrice, Stock) values (?,?,?,?)";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,product.getProdID());
            myPreStmt.setString(2, product.getProdName());
            myPreStmt.setDouble(3, product.getUnitPrice());
            myPreStmt.setInt(4, product.getOnHand());
            myPreStmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }
    public void insertSalesRecord(POS sale) throws SQLException
    {
        String query = "insert into saledetails (InvoiceNum, LineNum, ProdID, Qty, Subtotal) values (?,?,?,?,?)";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, sale.getInvoiceNum());
            myPreStmt.setInt(2,sale.getLineNum());
            myPreStmt.setInt(3,sale.ProdID);
            myPreStmt.setInt(4,sale.Qty);
            myPreStmt.setDouble(5, sale.Subtotal);
            myPreStmt.execute("set foreign_key_checks=0");
            myPreStmt.executeUpdate();
            myPreStmt.execute("set foreign_key_checks=1");
        }
        catch(Exception e){
            System.out.println("Sales Details exception!");
            System.out.println(e.getMessage());
        }
    }
    public void insertSalesSummary(POS sale)
    {
        String query = "insert ignore into salesummary (QtySold, TotRevenue) values (?,?)";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,sale.Qty);
            myPreStmt.setDouble(2,sale.getTotRevenue());
             myPreStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public POS SaleSummary(){
        POS saleSummary = null;
        String query = "SELECT * FROM pos.salesummary WHERE InvoiceNum=(SELECT max(InvoiceNum) FROM pos.salesummary)"; 
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            while(rs.next())
            {
                saleSummary = new POS(rs.getInt("InvoiceNum"),rs.getString("Date"),rs.getInt("QtySold"),rs.getDouble("TotRevenue"));
                return saleSummary;
            }
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Products findProductRecord(int prodID) throws SQLException{
        Products theOne = null;
        String query = "select * from products where ProdID = ?";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, prodID);
            ResultSet rs = myPreStmt.executeQuery();
            while(rs.next())
            {
                theOne = new Products(rs.getInt("ProdID"),rs.getString("ProdName"),rs.getDouble("UnitPrice"),rs.getInt("Stock"));
            }
            
        }
        catch (Exception e) {
            System.out.println("Got an exception! Error in Find Record");
            System.out.println(e.getMessage());
        }
        return theOne;
    } 
    /*public ArrayList<Products> ShowAllProducts(){
        ArrayList<Products> productsList = new ArrayList<>();
        String query = "select * from products";
        try {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            ResultSet rs = myPreStmt.executeQuery();
            Products.jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            Products product;
            while(rs.next()){
                product = new Products(rs.getInt("ProdID"),rs.getString("ProdName"),rs.getDouble("UnitPrice"),rs.getInt("Stock"));
                productsList.add(product);

            }
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productsList;
    }*/
    public POS findSalesRecord(int InvoiceNum){
        POS theOne = null;
        String query = "select salesummary.Date,saledetails.LineNum, saledetails.InvoiceNum, saledetails.ProdID, products.ProdName, saledetails.Qty, saledetails.Subtotal FROM salesummary, saledetails, products where saledetails.InvoiceNum = salesummary.InvoiceNum AND products.ProdID = saledetails.ProdID;";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, InvoiceNum);
            ResultSet rs = myPreStmt.executeQuery();
            
            while(rs.next())
            {
                //theOne = new POS(rs.getDate("Date"),rs.getInt("LineNum"),rs.getInt("InvoiceNum"),rs.getInt("ProdID"),rs.getString("ProdName"),rs.getInt("Qty"),rs.getDouble("Subtotal"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return theOne;
    }
    public void updateProductRecord(Products product){
        String query = "update products set ProdName = ?, UnitPrice = ?, Stock = ? where ProdID=?";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            
            myPreStmt.setString(1, product.getProdName());
            myPreStmt.setDouble(2, product.getUnitPrice());
            myPreStmt.setInt(3, product.getOnHand());
            myPreStmt.setInt(4,product.getProdID());
            myPreStmt.execute();
        }
        catch(Exception e){
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }
    public void updateSalesRecord(POS sale)
    {
        String query = "update ignore saledetails set InvoiceNum=?, ProdID=?, Qty=?, Subtotal=? where saledetails.InvoiceNum=salesummary.InvoiceNum AND saledetails.LineNum=?";
        try
        {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,sale.getInvoiceNum());
            myPreStmt.setInt(2,sale.getProdID());
            myPreStmt.setInt(3,sale.getQuantity());
            myPreStmt.setDouble(4, sale.getSubtotal());
            myPreStmt.setInt(5, sale.getLineNum());
            myPreStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateSalesSummary(POS sales)
    {
        String query = "update salesummary set InvoiceNum=?, Date=?,QtySold=?,TotRevenue=?";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,sales.getInvoiceNum());
            myPreStmt.setDate(2,sales.getSQLDate());
            myPreStmt.setInt(3, sales.getQuantity());
            //myPreStmt.setInt(4, sales.getTotRevenue());
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteProductRecord(int prodID)
    {
        String query = "delete from products where ProdID = ?";
        try
        {
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1,prodID);
            myPreStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteSalesRecord(int InvoiceNum, int LineNum)
    {
        String query = "delete from saledetails where LineNum = ?, InvoiceNum = ?";
        try{
            PreparedStatement myPreStmt = myConn.prepareStatement(query);
            myPreStmt.setInt(1, LineNum);
            myPreStmt.setInt(2, InvoiceNum);
            myPreStmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(POSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
}

